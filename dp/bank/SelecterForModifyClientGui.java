package ro.uvt.dp.bank;

import ro.uvt.dp.ui.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelecterForModifyClientGui implements ActionListener {

    private UI selecterUi;
    private static JButton confirm, goBack;
    private static JTextField textField;
    private static JPanel panel;
    private static JLabel label, done;
    private String bankCode_;
    private Bank bank_;

    public SelecterForModifyClientGui(Bank bank, String bankCode, JTable table) {
        panel = new JPanel();
        this.bankCode_ = bankCode;
        this.bank_ = bank;
        selecterUi = new UI(panel, "icon3/piggyBank.png", 420, 420);
        confirm = new JButton("Confirm");
        goBack = new JButton("Go back");
        label = new JLabel("Name of the account");
        done = new JLabel("");
        textField = new JTextField(20);
        label.setBounds(25, 320, 125, 25);
        done.setBounds(100, 350, 110, 25);
        textField.setBounds(145, 320, 110, 25);
        confirm.setBounds(90, 350, 110, 25);
        goBack.setBounds(210, 350, 110, 25);
        confirm.addActionListener(this);
        goBack.addActionListener(this);
        panel.add(confirm);
        panel.add(goBack);
        panel.add(textField);
        JFrame frame = selecterUi.getFrame();
        frame.add(textField);
        frame.add(confirm);
        frame.add(goBack);
        frame.add(label);
        frame.add(done);
        frame.add(panel);
        frame.getContentPane().add(BorderLayout.NORTH, table.getTableHeader());
        frame.getContentPane().add(BorderLayout.CENTER, table);
        selecterUi.openClose(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goBack) {
            selecterUi.openClose(false);
            BankAdminGui bankAdminGui = new BankAdminGui(bankCode_);
        }
        if(e.getSource() == confirm) {
            String accountMdf = textField.getText();
            if(!accountMdf.equals("")){
                ModifyClientGui modifyClientGui = new ModifyClientGui(bank_, bankCode_, accountMdf);
            }
        }
    }
}
