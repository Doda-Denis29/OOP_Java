package ro.uvt.dp.account;

import ro.uvt.dp.extras.MyExeptions;

public class AccountEUR extends Account {

	public AccountEUR(String accountNumber, double sum) throws MyExeptions {
		super(accountNumber, sum);
	}

	public double getInterest() {
		return 0.01;

	}

	public double closeAccountEUR(String AccountNumber) throws MyExeptions {
		this.accountCode = AccountNumber;
		amount = getTotalAmount();
		retrieve(getTotalAmount());
		return amount;
	}

	@Override
	public String toString() {
		return "Account EUR [" + super.toString() + "]";
	}
}
