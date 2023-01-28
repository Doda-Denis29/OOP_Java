package ro.uvt.dp.ui;

import javax.swing.*;

public class UI {
    private static JFrame frame;
    private static ImageIcon icon;

    public UI(String nameFrame, JPanel panel, String fileIcon, int width, int height) {
        frame = new JFrame("Hello admin of " + nameFrame);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        icon = new ImageIcon(fileIcon);
        frame.setIconImage(icon.getImage());
    }
    public UI(JPanel panel, String fileIcon, int width, int height) {
        frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        icon = new ImageIcon(fileIcon);
        frame.setIconImage(icon.getImage());
    }

    public JFrame getFrame() {
        return frame;
    }

    public void openClose(boolean closeOpen) {
        frame.setVisible(closeOpen);
    }
}
