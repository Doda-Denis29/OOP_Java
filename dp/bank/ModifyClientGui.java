package ro.uvt.dp.bank;

import ro.uvt.dp.account.Account;
import ro.uvt.dp.ui.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyClientGui implements ActionListener {

    private static JLabel name, type, address, accountNumber, sum;
    private static UI ModifyClientGui;
    public static JTextField name_txt;
    public static JTextField type_txt;
    public static JTextField address_txt;
    public static JTextField accountNumber_txt;
    public static JTextField sum_txt;
    public static JButton confirm;
    private static JButton goBack;
    private static JPanel panel;

    private Bank bank_;
    private String bankName_;
    private Client client;

    public ModifyClientGui(Bank bank, String bankName, String accountMdf) {
        panel = new JPanel();
        this.bank_ = bank;
        this.bankName_ = bankName;
        ModifyClientGui = new UI(panel, "icon3/piggyBank.png", 420, 420);
        client = bank_.getClient(accountMdf);
        name = new JLabel("Name: ");
        address = new JLabel("Address: ");
        type = new JLabel("Type: ");
        accountNumber = new JLabel("Account Number: ");
        sum = new JLabel("Sum: ");
        confirm = new JButton("Confirm");
        goBack = new JButton("Go back");
        name_txt = new JTextField(client.getName(),50);
        address_txt = new JTextField(client.getAddress(),50);
        if(client.getType().equals(Account.TYPE.EUR)){
            type_txt = new JTextField("EUR" ,10);
        }
        else {
            type_txt = new JTextField("RON" ,10);
        }
        accountNumber_txt = new JTextField(client.getAccountNumber(),80);
        sum_txt = new JTextField(Double.toString(client.getSum()),50);
        name.setBounds(80, 20, 80, 25);
        address.setBounds(80, 55, 80, 25);
        type.setBounds(80, 80, 80, 25);
        accountNumber.setBounds(80, 115, 80, 25);
        sum.setBounds(80, 150, 80, 25);
        name_txt.setBounds(170, 20, 165, 25);
        address_txt.setBounds(170, 55, 165, 25);
        type_txt.setBounds(170, 80, 165, 25);
        accountNumber_txt.setBounds(170, 115, 165, 25);
        sum_txt.setBounds(170, 150, 165, 25);
        confirm.setBounds(90, 350, 110, 25);
        goBack.setBounds(210, 350, 110, 25);
        confirm.addActionListener(this);
        goBack.addActionListener(this);
        panel.add(confirm);
        panel.add(goBack);
        JFrame frame = ModifyClientGui.getFrame();
        frame.add(confirm);
        frame.add(goBack);
        frame.add(name);
        frame.add(address);
        frame.add(type);
        frame.add(accountNumber);
        frame.add(sum);
        frame.add(name_txt);
        frame.add(address_txt);
        frame.add(type_txt);
        frame.add(accountNumber_txt);
        frame.add(sum_txt);
        frame.add(panel);
        ModifyClientGui.openClose(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goBack) {
            ModifyClientGui.openClose(false);
            BankAdminGui bankAdminGui = new BankAdminGui(bankName_);
        }
        if(e.getSource() == confirm) {
            String nameTxt = name_txt.getText();
            String addressTxt = address_txt.getText();
            String typeTxt = type_txt.getText();
            String accountNumberTxt = accountNumber_txt.getText();
            String sum = sum_txt.getText();
            client.setName(nameTxt);
            client.setAddress(addressTxt);
            if(typeTxt.equals("EUR")) {
                client.setType(Account.TYPE.EUR);
            }
            else if (typeTxt.equals("RON")){
                client.setType(Account.TYPE.RON);
            }
            client.setAccountNumber(accountNumberTxt);
            client.setSum(Double.parseDouble(sum));
        }
    }
}
