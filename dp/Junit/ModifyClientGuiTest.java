package ro.uvt.dp.Junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ro.uvt.dp.bank.Bank;
import ro.uvt.dp.bank.Client;
import ro.uvt.dp.account.Account;
import ro.uvt.dp.bank.ModifyClientGui;
import ro.uvt.dp.extras.MyExeptions;

public class ModifyClientGuiTest {

    @Test
    public void testModifyClientGui() throws MyExeptions {
        Bank bank = new Bank("testBank");
        Client client = new Client.ClientBuilder("John Doe", "Timisoara", Account.TYPE.EUR, "EUR001", 200.9).birthDate("19 Jan 2002").build();
        bank.addClient(client);
        ModifyClientGui gui = new ModifyClientGui(bank, "testBank", "acc1");

        // check if the client information is displayed correctly
        assertEquals(client.getName(), gui.name_txt.getText());
        assertEquals(client.getAddress(), gui.address_txt.getText());
        assertEquals(client.getType().toString(), gui.type_txt.getText());
        assertEquals(client.getAccountNumber(), gui.accountNumber_txt.getText());
        assertEquals(Double.toString(client.getSum()), gui.sum_txt.getText());

        // modify the client information
        gui.name_txt.setText("Jane Doe");
        gui.address_txt.setText("new address");
        gui.type_txt.setText("RON");
        gui.accountNumber_txt.setText("acc2");
        gui.sum_txt.setText("2000");

        // trigger the confirm button
        gui.confirm.doClick();

        // check if the client information is updated correctly
        assertEquals("Jane Doe", client.getName());
        assertEquals("new address", client.getAddress());
        assertEquals(Account.TYPE.RON, client.getType());
        assertEquals("acc2", client.getAccountNumber());
        assertEquals(2000, client.getSum());
    }
}