package ro.uvt.dp.interfaces;

import ro.uvt.dp.extras.MyExeptions;
import ro.uvt.dp.account.Account;

public interface Transfer {
	public void transfer(Account c, double s) throws MyExeptions;
}
