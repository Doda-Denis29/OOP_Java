package ro.uvt.dp.bank;

import ro.uvt.dp.interfaces.Observer;

public class BankObserver implements Observer {

    private Bank bank;

    private BankObserver(String bankCode) {
    }

    public void createBankObserver(String bankCode) {

    }
    @Override
    public void update() {
        bank.getBankCode();
        System.out.println("Bank observer has been called and the current bank code is " + bank.getBankCode());
    }
}
