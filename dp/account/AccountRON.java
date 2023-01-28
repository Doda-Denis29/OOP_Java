package ro.uvt.dp.account;

import ro.uvt.dp.extras.MyExeptions;
import ro.uvt.dp.interfaces.Transfer;

public class AccountRON extends Account implements Transfer {

	public AccountRON(String accountNumber, double sum) throws MyExeptions {
		super(accountNumber, sum);
	}

	public double getInterest() {
		if (amount < 500)
			return 0.03;
		else
			return 0.08;
	}

	@Override
	public String toString() {
		return "Account RON [" + super.toString() + "]";
	}

	@Override
	public void transfer(Account c, double s) throws MyExeptions {
		c.retrieve(s);
		depose(s);
	}
}
