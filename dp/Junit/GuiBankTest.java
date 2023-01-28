package ro.uvt.dp.Junit;

import org.junit.Test;
import ro.uvt.dp.bank.Bank;
import ro.uvt.dp.bank.BankHashMap;
import ro.uvt.dp.bank.GuiBank;

import static org.junit.Assert.*;

public class GuiBankTest {

    @Test
    public void testLogin() {
        GuiBank guiBank = GuiBank.getInstance();
        Bank bank = new Bank("testBank");
        BankHashMap bankHashMap = BankHashMap.getInstance();
        bankHashMap.addBankData(bank);

        // Test valid login
        guiBank.user_txt.setText("testBank");
        guiBank.passw_txt.setText("1234");
        guiBank.UserButton.doClick();
        assertEquals("Valid", guiBank.labelValidInvalid.getText());

        // Test invalid login
        guiBank.user_txt.setText("testBank");
        guiBank.passw_txt.setText("12345");
        guiBank.UserButton.doClick();
        assertEquals("Invalid", guiBank.labelValidInvalid.getText());

        // Test empty login fields
        guiBank.user_txt.setText("");
        guiBank.passw_txt.setText("");
        guiBank.UserButton.doClick();
        assertEquals("User name/Password not typed", guiBank.labelUsernameNotvalid.getText());
    }
}
