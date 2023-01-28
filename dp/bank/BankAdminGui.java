package ro.uvt.dp.bank;

import ro.uvt.dp.ui.UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BankAdminGui implements ActionListener {
    private static UI bankAdminGUI;
    private static JFrame frameBankAdminGUI;
    private static JButton addClient, removeClient, modifyCLient;
    private static JPanel panel;
    private static DefaultTableModel model;
    private static JTable table;
    private static JScrollPane scroll;
    private ArrayList<String> IconList, IconList2;
    private Bank bank;

    public String getIcon(String bankName) {
        String nameIcon;
        if(bankName.contains(" ")) {
            bankName = bankName.substring(0, bankName.indexOf(" ")).toLowerCase();
        }
        IconList = new ArrayList<>();
        IconList2 = new ArrayList<>();
        IconList.add("icon/alpha.png");
        IconList.add("icon/bcr.png");
        IconList.add("icon/brd.jpg");
        IconList.add("icon/cec.png");
        IconList.add("icon/firstbank.png");
        IconList.add("icon/ing.png");
        IconList.add("icon/raiffeisen.png");
        IconList.add("icon/transilvania.png");
        IconList.add("icon/unicredit.png");
        IconList2.add("icon2/def1.png");
        IconList2.add("icon2/def2.png");
        IconList2.add("icon2/def3.png");
        IconList2.add("icon2/def4.png");

        for (int i = 0; i < IconList.size(); i++) {
            nameIcon = IconList.get(i).toLowerCase();
            if(nameIcon.contains(bankName)) {
                return IconList.get(i);
            }
        }
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        nameIcon = IconList2.get(randomNumber);
        return nameIcon;
    }

    public BankAdminGui(String bankName) {
        BankHashMap bankHashMap = BankHashMap.getInstance();
        panel = new JPanel();
        bankAdminGUI = new UI(bankName, panel, getIcon(bankName), 500, 500);
        addClient = new JButton("Add client");
        removeClient = new JButton("Remove client");
        modifyCLient = new JButton("Modify client");
        addClient.setBounds(120, 380, 110, 25);
        removeClient.setBounds(170, 420, 140, 25);
        modifyCLient.setBounds(250, 380, 110, 25);
        addClient.addActionListener(this);
        removeClient.addActionListener(this);
        modifyCLient.addActionListener(this);
        panel.add(addClient);
        panel.add(removeClient);
        panel.add(modifyCLient);
        model = new DefaultTableModel();
        String[] columnNames = {"Client name", "Address", "Type of account", "Account number", "Sum"};
        model.setColumnIdentifiers(columnNames);
        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frameBankAdminGUI = new JFrame();
        frameBankAdminGUI = bankAdminGUI.getFrame();
        Container contentPane = frameBankAdminGUI.getContentPane();
        contentPane.setLayout(new BorderLayout());
        frameBankAdminGUI.add(scroll);
        bank = bankHashMap.getBank(bankName);
        if(!bank.equals("")) {
            ArrayList<Client> ourClients = bank.putAllClients();
            for(int i = 0; i < ourClients.size(); i++) {
                Client c = ourClients.get(i);
                model.addRow(new Object[]{c.getName(), c.getAddress(), c.getType(), c.getAccountNumber(), c.getSum()});
            }

        }
        frameBankAdminGUI.add(addClient);
        frameBankAdminGUI.add(removeClient);
        frameBankAdminGUI.add(modifyCLient);
        frameBankAdminGUI.add(BorderLayout.CENTER, table);
        frameBankAdminGUI.add(BorderLayout.NORTH, table.getTableHeader());
        bankAdminGUI.openClose(true);
    }

    public JButton getAddClient() {
        return addClient;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addClient) {
            bankAdminGUI.openClose(false);
            AddClientGui clientGui = new AddClientGui(bank, bank.getBankCode());
        }
        if(e.getSource() == removeClient) {
            bankAdminGUI.openClose(false);
            RemoveClientGui removeClientGui = new RemoveClientGui(table, bank.getBankCode(), bank);
        }
        if (e.getSource() == modifyCLient) {
            bankAdminGUI.openClose(false);
            SelecterForModifyClientGui selecter = new SelecterForModifyClientGui(bank, bank.getBankCode(), table);
        }
    }
}
