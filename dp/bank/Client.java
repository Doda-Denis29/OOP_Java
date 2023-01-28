package ro.uvt.dp.bank;

import java.util.ArrayList;

import ro.uvt.dp.account.AccountFactory;
import ro.uvt.dp.extras.MyExeptions;
import ro.uvt.dp.account.Account;
import ro.uvt.dp.account.Account.TYPE;

public class Client {
	private String name, address, accountNumber_;
	private double sum_;
	private TYPE type_;
	private ArrayList<Account> accounts;

	public Client(ClientBuilder builder) throws MyExeptions {
		this.name = ClientBuilder.name;
		this.address = ClientBuilder.address;
		accounts = new ArrayList<>();
		addAccount(ClientBuilder.type, ClientBuilder.accountNumber, ClientBuilder.sum);
	}

	public void addAccount(TYPE type, String accountNumber, double sum) throws MyExeptions {
		Account c;
		AccountFactory accountFactory = new AccountFactory();
		this.sum_ = sum;
		this.accountNumber_ = accountNumber;
		this.type_ = type;
		c = accountFactory.makeAccount(accountNumber, sum, type);
		accounts.add(c);
	}

	public Account getAccount(String accountCode) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber().equals(accountCode)) {
				return accounts.get(i);
			}
		}
		return null;
	}

	public void closeAccount(String accountCode){
		for(int i = 0; i < accounts.size(); i++){
			if(accounts.get(i).getAccountNumber().equals(accountCode)){
				Account c = accounts.get(i);
				accounts.remove(c);
			}
		}
	}

/*	public void blockedAccount(String accountCode){
		for(int i = 0; i < accounts.size(); i++){
			if()
		}
	}*/

	@Override
	public String toString() {
		return "\n\tClient [name=" + name + ", address=" + address + ", accounts=" + accounts + ", birthDate=" + ClientBuilder.birthDate + "]";
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getAccountNumber() {
		return accountNumber_;
	}

	public TYPE getType() {
		return type_;
	}

	public double getSum() {
		return sum_;
	}

	public void setName(String name_) {
		this.name = name_;
	}
	public void setAddress(String address_) {
		this.address = address_;
	}

	public void setType(TYPE type) {
		this.type_ = type;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber_ = accountNumber;
	}
	public void setSum(Double sum) {
		this.sum_ = sum;
	}

	public static class ClientBuilder {
		public static String name;
		public static String address;
		public static String birthDate;
		public static String accountNumber;

		public static double sum;

		public static Account.TYPE type;

		public ClientBuilder(String name, String address, Account.TYPE type, String accountNumber, double sum) {
			this.name = name;
			this.address = address;
			this.type = type;
			this.accountNumber = accountNumber;
			this.sum = sum;
		}

		public ClientBuilder birthDate(String birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Client build() throws MyExeptions {
			Client client = new Client(this);
			return client;
		}
	}
}
