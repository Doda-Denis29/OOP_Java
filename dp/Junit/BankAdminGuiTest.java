package ro.uvt.dp.Junit;

import org.junit.Test;
import ro.uvt.dp.bank.BankAdminGui;

import javax.swing.*;

import static org.junit.Assert.*;

public class BankAdminGuiTest {
    @Test
    public void testGetIcon() {
        BankAdminGui gui = new BankAdminGui("Test Bank");
        String icon = gui.getIcon("Test Bank");
        assertNotNull(icon);
        assertTrue(icon.endsWith(".png") || icon.endsWith(".jpg"));
    }

    @Test
    public void testAddClientButton() {
        BankAdminGui gui = new BankAdminGui("Test Bank");
        JButton addClientButton = gui.getAddClient();
        assertNotNull(addClientButton);
        assertEquals("Add client", addClientButton.getText());
    }
}
