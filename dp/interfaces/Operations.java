package ro.uvt.dp.interfaces;

import ro.uvt.dp.extras.MyExeptions;

public interface Operations {
	public double getTotalAmount();

	public double getInterest();

	public void depose(double amount) throws MyExeptions;

	public void retrieve(double amount) throws MyExeptions;
}
