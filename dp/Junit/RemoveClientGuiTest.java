package ro.uvt.dp.Junit;

import org.junit.Before;
import org.junit.Test;
import ro.uvt.dp.account.Account;
import ro.uvt.dp.bank.Bank;
import ro.uvt.dp.bank.Client;
import ro.uvt.dp.bank.RemoveClientGui;
import ro.uvt.dp.extras.MyExeptions;

import javax.swing.*;

import static org.junit.Assert.*;

public class RemoveClientGuiTest {
    private Bank bank;
    private RemoveClientGui removeClientGui;

    @Before
    public void setUp() throws MyExeptions {
        bank = new Bank("123");
        Client client = new Client.ClientBuilder("John Doe", "Timisoara", Account.TYPE.EUR, "EUR001", 200.9).birthDate("19 Jan 2002").build();
        bank.addClient(client);
        JTable table = new JTable();
        removeClientGui = new RemoveClientGui(table, "123", bank);
    }

    @Test
    public void testRemoveClient() {
        removeClientGui.textField.setText("John Doe");
        removeClientGui.confirm.doClick();
        assertEquals("Done", removeClientGui.done.getText());
    }
}