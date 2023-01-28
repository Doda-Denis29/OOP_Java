package ro.uvt.dp.Junit;

import org.junit.Test;
import org.junit.Before;
import ro.uvt.dp.bank.BankHashMap;
import ro.uvt.dp.bank.CreateBankGui;

import static org.junit.Assert.*;

public class CreateBankGuiTest {
    private CreateBankGui createBankGui;

    @Before
    public void setUp() {
        createBankGui = new CreateBankGui();
    }

    @Test
    public void testCreateBank() {
        createBankGui.bankUser_txt.setText("MyBank");
        createBankGui.ConfirmAndCreate.doClick();
        BankHashMap bankHashMap = BankHashMap.getInstance();
        assertTrue(bankHashMap.validBankUser("MyBank", createBankGui.bankPinGenerated.getText()));
        assertEquals("Bank created", createBankGui.labelCreated.getText());
    }

    @Test
    public void testInvalidName() {
        createBankGui.bankUser_txt.setText("MyBank1");
        createBankGui.ConfirmAndCreate.doClick();
        assertEquals("Invalid name/Bank name must contain bank", createBankGui.labelUsernameNotvalid.getText());
    }

    @Test
    public void testEmptyName() {
        createBankGui.bankUser_txt.setText("");
        createBankGui.ConfirmAndCreate.doClick();
        assertEquals("Empty bank name", createBankGui.labelUsernameNotvalid.getText());
    }
    @Test
    public void testGoBackButton() {
        createBankGui.GoBack.doClick();
        assertFalse(createBankGui.createBankUI.getFrame().isVisible());
    }
}