package ro.uvt.dp.bank;

import ro.uvt.dp.ui.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateBankGui implements ActionListener {
    public static UI createBankUI;
    public static JTextField bankUser_txt;
    public static JButton ConfirmAndCreate;
    public static JButton GoBack;
    private static JLabel user;
    private static JLabel bankPin;
    public static JLabel bankPinGenerated;
    public static JLabel labelCreated;
    public static JLabel labelUsernameNotvalid;
    private static JPanel panel;

    public CreateBankGui() {
        panel = new JPanel();
        createBankUI = new UI(panel ,"icon/create-bank.png", 500, 500);
        user = new JLabel("Bank Name");
        user.setBounds(80, 20, 80, 25);
        user.setHorizontalAlignment(SwingConstants.CENTER);
        bankPin = new JLabel("PIN Code");
        bankPin.setBounds(98, 50, 80, 25);
        bankPinGenerated = new JLabel("");
        bankPinGenerated.setBounds(160, 50, 165, 25);
        bankUser_txt = new JTextField(20);
        bankUser_txt.setBounds(160, 20, 165, 25);
        ConfirmAndCreate = new JButton("Create & add bank");
        ConfirmAndCreate.setBounds(160, 80, 170, 25);
        GoBack = new JButton("Go back to login page");
        GoBack.setBounds(160,110,170,25);
        panel.add(user);
        panel.add(bankPin);
        panel.add(bankUser_txt);
        panel.add(ConfirmAndCreate);
        panel.add(GoBack);
        ConfirmAndCreate.addActionListener(this);
        GoBack.addActionListener(this);
        labelCreated = new JLabel("");
        labelCreated.setBounds(210, 130, 300, 25);
        labelUsernameNotvalid = new JLabel("");
        labelUsernameNotvalid.setBounds(158, 130, 300, 25);
        panel.add(labelCreated);
        panel.add(labelUsernameNotvalid);
        panel.add(bankPinGenerated);
        createBankUI.openClose(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String bankName = bankUser_txt.getText();
        if(e.getSource() == ConfirmAndCreate) {
            if(!bankName.contains("bank") && bankName.equals("bank")) {
                bankPinGenerated.setText("");
                labelUsernameNotvalid.setText("Invalid name/Bank name must contain bank");
            }
            else if (!bankName.equals("")) {
                Bank newBank = new Bank(bankName);
                bankPinGenerated.setText(newBank.getBankPIN());
                BankHashMap bankHashMap = BankHashMap.getInstance();
                bankHashMap.addBankData(newBank);
                labelUsernameNotvalid.setText("");
                labelCreated.setText("Bank created");
            }
            else {
                bankPinGenerated.setText("");
                labelCreated.setText("");
                labelUsernameNotvalid.setText("Empty bank name");
            }
        }

        if(e.getSource() == GoBack) {
            createBankUI.openClose(false);
            GuiBank guibank = new GuiBank();
        }
    }
}
