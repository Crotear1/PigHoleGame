package src.ui;

import src.bl.PigHoleCLS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PigHoleGUI {
    private JPanel mainPanel;
    private JButton wuerfelnButton;
    private JLabel pig1_1;
    private JLabel pig2_1;
    private JLabel pig2_2;
    private JLabel pig3_1;
    private JLabel pig3_2;
    private JLabel pig3_3;
    private JLabel pig4_1;
    private JLabel pig4_2;
    private JLabel pig4_3;
    private JLabel pig4_4;
    private JLabel pig5_1;
    private JLabel pig5_2;
    private JLabel pig5_3;
    private JLabel pig5_4;
    private JLabel pig5_5;
    private JLabel playerPigs;
    private JLabel computerPigs;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pig Hole");
        frame.setContentPane(new PigHoleGUI().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public PigHoleGUI() {
        setDefaultImages();
      
        wuerfelnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PigHoleCLS PigCLS = new PigHoleCLS();
                int diceResult = PigCLS.rollDice();
            }
        });
    }
    
    public void setDefaultImages() {
        ImageIcon defaultImage = getPictureBlackWhite();
        pig1_1.setIcon(defaultImage);
        pig2_1.setIcon(defaultImage);
        pig2_2.setIcon(defaultImage);
        pig3_1.setIcon(defaultImage);
        pig3_2.setIcon(defaultImage);
        pig3_3.setIcon(defaultImage);
        pig4_1.setIcon(defaultImage);
        pig4_2.setIcon(defaultImage);
        pig4_3.setIcon(defaultImage);
        pig4_4.setIcon(defaultImage);
        pig5_1.setIcon(defaultImage);
        pig5_2.setIcon(defaultImage);
        pig5_3.setIcon(defaultImage);
        pig5_4.setIcon(defaultImage);
        pig5_5.setIcon(defaultImage);
    }

    public ImageIcon getPictureBlackWhite(){
        ImageIcon imageIcon = new ImageIcon("src/ui/team-schweineaim.281653-modified.png");

        Image image = imageIcon.getImage();

        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg);

    }

    public ImageIcon getPictureColor() {
        ImageIcon imageIcon2 = new ImageIcon("src/ui/team-schweineaim.281653.png");

        Image image = imageIcon2.getImage();

        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg);
    }
}
