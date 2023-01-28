package ro.uvt.dp.account;

import ro.uvt.dp.extras.MyExeptions;

public class AccountFactory {
    public Account makeAccount(String accountNumber, double sum, Account.TYPE type) throws MyExeptions {

        switch (type){
            case EUR -> {
                return new AccountEUR(accountNumber, sum);
            }
            case RON -> {
                return new AccountRON(accountNumber, sum);
            }
            default -> {
                return null;
            }
        }
    }
}
