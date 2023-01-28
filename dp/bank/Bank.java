package ro.uvt.dp.bank;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

	private ArrayList<Client> clients;
	private String bankCode, bankPIN;
	private static Bank bankInstance = null;

	public static Bank getInstance(String bankCode_){
		if(bankInstance == null) {
			synchronized (Bank.class) {
				if(bankInstance == null) {
					bankInstance = new Bank(bankCode_);
				}
			}
		}
		return bankInstance;
	}

	private String generatePIN() {
		Random rand = new Random();
		int num = rand.nextInt(10000);
		if(num < 1000 && num >= 100) {
			num *= 10;
		}
		else if (num < 100) {
			num *= 100;
		}
		return Integer.toString(num);
	}

	public Bank(String bankCode_) {
		this.bankCode = bankCode_;
		this.bankPIN = generatePIN();
		System.out.println("Bank pin for: " + bankCode_ + " is " + bankPIN);
		clients = new ArrayList<>();
	}

	public void addClient(Client c) {
		clients.add(c);
	}


	public Client getClient(String name_) {
		for (Client client:
				clients) {
			if (client.getName().equals(name_)) {
				return client;
			}
		}
		return null;
	}

	public ArrayList putAllClients() {
		return clients;
	}



	public String getBankPIN() {
		return bankPIN;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void removeClient(Client c){
		clients.remove(c);
	}

	@Override
	public String toString() {
		return "Bank [code=" + bankCode + ", clients=" + clients + "]";
	}

}
