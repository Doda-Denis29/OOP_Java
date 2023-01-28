package ro.uvt.dp.bank;

import ro.uvt.dp.account.Account;
import ro.uvt.dp.extras.MyExeptions;
import ro.uvt.dp.ui.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddClientGui implements ActionListener {

    private static JLabel name, type, address;
    private static UI AddClientGui;
    public static JTextField name_txt;
    public static JTextField type_txt;
    public static JTextField address_txt;
    public static JButton confirm;
    private static JButton goBack;
    private static JPanel panel;

    private Bank bank_;
    private String bankName_;

    public AddClientGui(Bank bank, String bankName) {
        panel = new JPanel();
        this.bankName_ = bankName;
        this.bank_ = bank;
        AddClientGui = new UI(panel, "icon3/piggyBank.png", 420, 420);
        name = new JLabel("Name: ");
        address = new JLabel("Address: ");
        type = new JLabel("Type: ");
        confirm = new JButton("Confirm");
        goBack = new JButton("Go back");
        name_txt = new JTextField(50);
        address_txt = new JTextField(50);
        type_txt = new JTextField(10);
        name.setBounds(80, 20, 80, 25);
        address.setBounds(80, 55, 80, 25);
        type.setBounds(80, 80, 80, 25);
        name_txt.setBounds(170, 20, 165, 25);
        address_txt.setBounds(170, 55, 165, 25);
        type_txt.setBounds(170, 85, 165, 25);
        confirm.setBounds(90, 350, 110, 25);
        goBack.setBounds(210, 350, 110, 25);
        confirm.addActionListener(this);
        goBack.addActionListener(this);
        panel.add(confirm);
        panel.add(goBack);
        JFrame frame = AddClientGui.getFrame();
        frame.add(confirm);
        frame.add(goBack);
        frame.add(name);
        frame.add(address);
        frame.add(type);
        frame.add(name_txt);
        frame.add(address_txt);
        frame.add(type_txt);
        frame.add(panel);
        AddClientGui.openClose(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goBack) {
            AddClientGui.openClose(false);
            BankAdminGui bankAdminGui = new BankAdminGui(bankName_);
        }
        if(e.getSource() == confirm) {
            String nameTxt = name_txt.getText();
            String addressTxt = address_txt.getText();
            String typeTxt = type_txt.getText();
            if(!nameTxt.equals("") && !addressTxt.equals("") && !typeTxt.equals("")){
                Random rand = new Random();
                int num = rand.nextInt(1000000000);
                String accountNumber = num + typeTxt;
                if(typeTxt.equals("EUR")) {
                    try {
                        Client client = new Client.ClientBuilder(nameTxt, addressTxt, Account.TYPE.EUR, accountNumber, 0).birthDate("19 Jan 2002").build();
                        bank_.addClient(client);
                    } catch (MyExeptions ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if (typeTxt.equals("RON")) {
                    try {
                        Client client = new Client.ClientBuilder(nameTxt, addressTxt, Account.TYPE.RON, accountNumber, 0).birthDate("19 Jan 2002").build();
                        bank_.addClient(client);
                    } catch (MyExeptions ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    System.out.println("Invalid");
                }
            }
        }
    }
}
