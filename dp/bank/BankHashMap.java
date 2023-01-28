package ro.uvt.dp.bank;

import java.util.HashMap;

public class BankHashMap {
    private HashMap<String, String> bankHash;
    private HashMap<String, Bank> bankHashOfBankHash;
    private static BankHashMap bankHashMapInstance = null;

    public static synchronized BankHashMap getInstance() {
        if(bankHashMapInstance == null) {
            bankHashMapInstance = new BankHashMap();
        }
        return bankHashMapInstance;
    }

    private BankHashMap() {
        bankHash = new HashMap<>();
        bankHashOfBankHash = new HashMap<>();
    }

    public void addBankData(Bank bank) {
        bankHash.put(bank.getBankCode(), bank.getBankPIN());
        bankHashOfBankHash.put(bank.getBankCode(), bank);
    }

    public void removeBankData(Bank bank) {
        bankHash.remove(bank.getBankCode(), bank.getBankPIN());
        bankHashOfBankHash.remove(bank.getBankCode(), bank);
    }

    public boolean validBankUser(String bankCode_, String bankPIN_) {
        if(!emptyBankCode(bankCode_, bankPIN_)) {
            if (bankHash.get(bankCode_).equals(bankPIN_)) {
                return true;
            }
        }
        return false;
    }

    public Bank getBank(String bankCode_) {
        if(!bankCode_.equals("")) {
            return bankHashOfBankHash.get(bankCode_);
        }
        return null;
    }

    private boolean emptyBankCode(String bankCode_, String bankPIN_) {
        return bankCode_.equals("") || bankPIN_.equals("");
    }
}
