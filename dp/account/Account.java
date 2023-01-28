package ro.uvt.dp.account;

import ro.uvt.dp.extras.MyExeptions;
import ro.uvt.dp.interfaces.Operations;

public abstract class Account implements Operations {

	protected String accountCode;
	protected double amount = 0;

	public enum TYPE {
		EUR, RON
	};

	protected Account(String accountNumber, double sum) throws MyExeptions {
		this.accountCode = accountNumber;
		depose(sum);
	}

	@Override
	public double getTotalAmount() {
		return amount + amount * getInterest();
	}

	@Override
	public void depose(double sum) throws MyExeptions {
		if(sum < 0) {
			throw new MyExeptions();
		}
		this.amount = sum;
	}

	@Override
	public void retrieve(double sum) throws MyExeptions {
		if(sum > amount) {
			throw new MyExeptions();
		}
		this.amount = sum;
	}

	public String toString() {
		return "Account: code=" + accountCode + ", amount=" + amount;
	}

	public String getAccountNumber() {
		return accountCode;
	}

}
