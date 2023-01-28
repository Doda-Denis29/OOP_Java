package ro.uvt.dp.bank;

import ro.uvt.dp.interfaces.Mediator;

import java.util.ArrayList;

public class BankMediator implements Mediator {

    private ArrayList<Colleague> colleagueArrayList;
    private ArrayList<Client> clients;
    private int colleagueCodes = 0;

    public BankMediator(){
        colleagueArrayList = new ArrayList<Colleague>();
    }

    @Override
    public void addColleague(Colleague colleague) {
        colleagueArrayList.add(colleague);
        colleagueCodes++;
        colleague.setColleagueCode(colleagueCodes);
    }

    public void getBankOfficer(int bankCode) {
        boolean calledBankOfficer = false;
    }

    public void getBankClient(Client client, int bankCode) {

    }
}
