package src.ui;

import src.bl.PigHoleCLS;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PigHoleCLS PigCLS = new PigHoleCLS();
                int diceResult = PigCLS.rollDice();
            }
        });
    }
}
