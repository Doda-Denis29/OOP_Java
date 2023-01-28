package ro.uvt.dp.interfaces;

import ro.uvt.dp.bank.Client;
import ro.uvt.dp.bank.Colleague;

public interface Mediator {
    void getBankOfficer(int bankCode);

    void getBankClient(Client client, int bankCode);

    void addColleague(Colleague colleague);
}
