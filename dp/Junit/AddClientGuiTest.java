package ro.uvt.dp.Junit;

import org.junit.Before;
import org.junit.Test;
import ro.uvt.dp.account.Account;
import ro.uvt.dp.bank.AddClientGui;
import ro.uvt.dp.bank.Bank;
import ro.uvt.dp.bank.Client;

import static org.junit.Assert.*;

public class AddClientGuiTest {
    private Bank bank;
    private String bankName;

    @Before
    public void setUp() {
        bank = new Bank("bank");
        bankName = "Test Bank";
    }

    @Test
    public void testAddClient() {
        AddClientGui gui = new AddClientGui(bank, bankName);
        gui.name_txt.setText("John Doe");
        gui.address_txt.setText("123 Main St");
        gui.type_txt.setText("EUR");
        gui.confirm.doClick();
        Client client = bank.getClient("John Doe");
        assertNotNull(client);
        assertEquals("John Doe", client.getName());
        assertEquals("123 Main St", client.getAddress());
        assertEquals(Account.TYPE.EUR, client.getType());
    }
}
