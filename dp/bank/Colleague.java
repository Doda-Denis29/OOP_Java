package ro.uvt.dp.bank;

import ro.uvt.dp.interfaces.Mediator;

public abstract class Colleague {
    private Mediator mediator;
    private int bankCode;

    public Colleague(Mediator newMediator){
        mediator = newMediator;
    }

    public void getBankOfficer(){
        mediator.getBankOfficer(this.bankCode);
    }

    public void getBankClient(Client client){
        mediator.getBankClient(client, this.bankCode);
    }

    public void setColleagueCode(int colleagueCode){
        bankCode = colleagueCode;
    }
}
