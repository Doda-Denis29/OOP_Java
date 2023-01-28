package ro.uvt.dp.bank;
import ro.uvt.dp.observer.Observable;
import ro.uvt.dp.ui.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBank extends Observable implements ActionListener {
    private static JLabel user;
    private static JLabel passw;
    public static JLabel labelValidInvalid;
    public static JLabel labelUsernameNotvalid;
    private static UI bankLoginUI;
    public static JTextField user_txt;
    public static JPasswordField passw_txt;
    public static JButton UserButton;
    private static JButton CreateUserButton;
    private static JPanel panel;
    private static GuiBank guiBankInstance = null;

    public static GuiBank getInstance() {
        if(guiBankInstance == null){
            synchronized (GuiBank.class){
                if(guiBankInstance == null){
                    guiBankInstance = new GuiBank();
                }
            }
        }
        return guiBankInstance;
    }

    protected GuiBank () {
        super();
        panel = new JPanel();
        bankLoginUI = new UI(panel,"icon/bank-icon.jpg", 500, 500);
        user = new JLabel("Bank Name");
        user.setBounds(80, 20, 80, 25);
        user.setHorizontalAlignment(SwingConstants.CENTER);
        passw = new JLabel("PIN Code");
        passw.setBounds(98, 50, 80, 25);
        user_txt = new JTextField(20);
        user_txt.setBounds(160, 20, 165, 25);
        passw_txt = new JPasswordField();
        passw_txt.setBounds(160, 50, 165, 25);
        UserButton = new JButton("Login");
        UserButton.setBounds(200, 80, 80, 25);
        CreateUserButton = new JButton("Add a new bank");
        CreateUserButton.setBounds(160,110,170,25);
        panel.add(user);
        panel.add(passw);
        panel.add(user_txt);
        panel.add(passw_txt);
        panel.add(UserButton);
        panel.add(CreateUserButton);
        UserButton.addActionListener(this);
        CreateUserButton.addActionListener(this);
        labelValidInvalid = new JLabel("");
        labelValidInvalid.setBounds(228, 130, 300, 25);
        labelUsernameNotvalid = new JLabel("");
        labelUsernameNotvalid.setBounds(158, 130, 300, 25);
        panel.add(labelValidInvalid);
        panel.add(labelUsernameNotvalid);
        bankLoginUI.openClose(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String bankName = user_txt.getText();
        String pinCode = passw_txt.getText();
        BankHashMap bankHashMap = BankHashMap.getInstance();

        if(e.getSource() == UserButton) {
            if(bankName.equals("") || pinCode.equals("")) {
                labelValidInvalid.setText("");
                labelUsernameNotvalid.setText("User name/Password not typed");
            }
            else if (bankHashMap.validBankUser(bankName, pinCode)) {
                labelUsernameNotvalid.setText("");
                labelValidInvalid.setText("Valid");
                bankLoginUI.openClose(false);
                BankAdminGui bankAdminGui = new BankAdminGui(bankName);
                this.notifyObservers();
            }
            else {
                labelUsernameNotvalid.setText("");
                labelValidInvalid.setText("Invalid");
            }
        }

        if(e.getSource() == CreateUserButton) {
            bankLoginUI.openClose(false);
            CreateBankGui createBankGui = new CreateBankGui();
        }
    }
}
