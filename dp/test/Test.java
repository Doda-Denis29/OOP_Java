package ro.uvt.dp.test;

import ro.uvt.dp.account.Account;
import ro.uvt.dp.bank.*;
import ro.uvt.dp.extras.MyExeptions;
import ro.uvt.dp.observer.Observable;

public class Test {

	public static void main(String[] args) throws MyExeptions {
		BankHashMap bankHashMap = BankHashMap.getInstance();
		Bank bcr = new Bank("BCR bank");
		bankHashMap.addBankData(bcr);
		//Bank bcr = Bank.getInstance("BCR bank");
		Client cl1 = new Client.ClientBuilder("Ionescu Ion", "Timisoara", Account.TYPE.EUR, "EUR124", 200.9).birthDate("19 Jan 2002").build();
		bcr.addClient(cl1);
		cl1.addAccount(Account.TYPE.RON, "RON1234", 400);
		Client cl2 = new Client.ClientBuilder("Marin Marin", "Timisoara", Account.TYPE.RON, "RON126", 100).birthDate("18 Mar 1999").build();
		bcr.addClient(cl2);
		//System.out.println(bcr);

		Bank cec = new Bank("CEC bank");
		bankHashMap.addBankData(cec);
		//Bank cec = Bank.getInstance("CEC bank");
		Client cl3 = new Client.ClientBuilder("Ionescu Andrei", "Timisoara", Account.TYPE.EUR, "EUR154", 200.9).birthDate("19 Jan 2002").build();
		cec.addClient(cl3);
		cl1.addAccount(Account.TYPE.RON, "RON1234", 400);
		Client cl4 = new Client.ClientBuilder("Marin Maria", "Timisoara", Account.TYPE.RON, "RON106", 100).birthDate("18 Mar 1999").build();
		cec.addClient(cl4);
		//System.out.println(cec);

		Bank alpha = new Bank("ALPHA bank");
		bankHashMap.addBankData(alpha);

		Client cl5 = new Client.ClientBuilder("Mircea Alex", "Resita", Account.TYPE.EUR, "EUR154", 500).birthDate("19 Jan 2002").build();
		alpha.addClient(cl5);

		Observable observable = Observable.getInstance();

		GuiBank guiBank = GuiBank.getInstance();
	}
}
