package ro.uvt.dp.Junit;

import org.junit.jupiter.api.Test;
import ro.uvt.dp.account.Account;
import ro.uvt.dp.account.AccountEUR;
import ro.uvt.dp.account.AccountFactory;
import ro.uvt.dp.account.AccountRON;
import ro.uvt.dp.extras.MyExeptions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class AccountFactoryTest {

    AccountFactory accountFactory = new AccountFactory();
    Account.TYPE type;
    double sum = 100;
    String accountName = "GenericAccountName";
    
    @Test
    void makeAccountEur() throws MyExeptions {
        Account testAccount;
        AccountEUR testaccountEur = new AccountEUR(accountName, sum);
        type = Account.TYPE.EUR;
        testAccount = accountFactory.makeAccount(accountName, sum, type);
        assertSame(testaccountEur, testAccount);
    }

    @Test
    void makeAccountRon() throws MyExeptions {
        Account testAccount;
        AccountRON testaccountRon = new AccountRON(accountName, sum);
        type = Account.TYPE.RON;
        testAccount = accountFactory.makeAccount(accountName, sum, type);
        assertSame(testaccountRon, testAccount);
    }

    public static class BankAdminGuiTest {

    }
}