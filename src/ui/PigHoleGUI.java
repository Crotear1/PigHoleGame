package src.ui;

import javax.swing.*;

public class PigHoleGUI {
    private JPanel mainPanel;
    private JButton button1;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Pig Hole");
        frame.setContentPane(new PigHoleGUI().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public PigHoleGUI() {

    }

    // set color


}
