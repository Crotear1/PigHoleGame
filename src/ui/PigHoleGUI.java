package src.ui;

import src.bl.PigHoleCLS;
import src.bl.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

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
    private JButton zugBeendenButton;
    private JLabel wuerfel;
    private JLabel zugLabel;

    List<Player> players = new ArrayList<>();
    private int playerTurn = 0;
    private PigHoleCLS pigCLS;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pig Hole");
        frame.setContentPane(new PigHoleGUI().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public PigHoleGUI() {
        pigCLS = new PigHoleCLS();
        players.add(new Player(20));
        players.add(new Player(20));
        setDefaultImages();
        setWuerfelImage(6);

        gameStart();

        wuerfelnButton.addActionListener(e -> {
            int diceResult = pigCLS.rollDice();
            boolean check = checkIfFieldFree(diceResult, playerTurn);
            pigCLS.getWin(players.get(0), players.get(1));
            System.out.println("Rolling player");

            if (!check) {
                zugBeendenButton.doClick();
            }
        });

        zugBeendenButton.addActionListener(e -> {
            try {
                zugLabel.setText("Gegner ist an der Reihe.");
                wuerfelnButton.setEnabled(false);
                playerTurn = 1;
                boolean again;
                boolean check;
                do {
                    sleep(1000);
                    check = checkIfFieldFree(pigCLS.rollDice(), playerTurn);
                    again = pigCLS.rollDiceCheckComputer();
                } while(again && check);
                playerTurn = 0;
                wuerfelnButton.setEnabled(true);
                zugLabel.setText("Sie sind an der Reihe.");
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void gameStart() {
        int i = 0;
        boolean check;
        wuerfelnButton.setEnabled(false);
        int diceRes = pigCLS.rollDice();
        checkIfFieldFree(diceRes, 0);
        diceRes = pigCLS.rollDice();
        checkIfFieldFree(diceRes, 1);
        do {
            check = checkIfFieldFree(pigCLS.rollDice(), 0);
            i++;
        } while (check && i < 2);
        i = 0;
        do {
            check = checkIfFieldFree(pigCLS.rollDice(), 1);
            i++;
        } while (check && i < 2);

        wuerfelnButton.setEnabled(true);
        zugLabel.setText("Sie sind an der Reihe.");
    }

    public boolean checkIfFieldFree(int diceResult, int playerIndex) {
        setWuerfelImage(diceResult);

        if (diceResult == 6) {
            players.get(playerIndex).removePig();
            return true;
        } else {
            boolean removePig = pigCLS.playerMove(diceResult);

            if(removePig) {
                int anz = pigCLS.getPigAnz(diceResult);
                players.get(playerIndex).removePig();
                switch (diceResult) {
                    case 1 -> setPig1ToColor();
                    case 2 -> setPig2ToColor(anz);
                    case 3 -> setPig3ToColor(anz);
                    case 4 -> setPig4ToColor(anz);
                    default -> setPig5ToColor(anz);
                }
                playerPigs.setText("Pigs: " + players.get(0).getPigs());
                computerPigs.setText("Pigs: " + players.get(1).getPigs());
                return true;
            }
            else {
                players.get(playerIndex).addPigs(diceResult);
                this.playerTurn = playerIndex == 0 ? 1 : 0;
                switch (diceResult) {
                    case 1 -> setPig1ToDefault();
                    case 2 -> setPig2ToDefault();
                    case 3 -> setPig3ToDefault();
                    case 4 -> setPig4ToDefault();
                    default -> setPig5ToDefault();
                }
                playerPigs.setText("Pigs: " + players.get(0).getPigs());
                computerPigs.setText("Pigs: " + players.get(1).getPigs());
                return false;
            }
        }
    }

    // SetDefaultPicture
    public void setPig1ToDefault() {
        ImageIcon defaultImage = getPictureBlackWhite();
        pig1_1.setIcon(defaultImage);
    }

    public void setPig2ToDefault() {
        ImageIcon defaultImage = getPictureBlackWhite();
        pig2_1.setIcon(defaultImage);
        pig2_2.setIcon(defaultImage);
    }

    public void setPig3ToDefault() {
        ImageIcon defaultImage = getPictureBlackWhite();
        pig3_1.setIcon(defaultImage);
        pig3_2.setIcon(defaultImage);
        pig3_3.setIcon(defaultImage);
    }

    public void setPig4ToDefault() {
        ImageIcon defaultImage = getPictureBlackWhite();
        pig4_1.setIcon(defaultImage);
        pig4_2.setIcon(defaultImage);
        pig4_3.setIcon(defaultImage);
        pig4_4.setIcon(defaultImage);
    }

    public void setPig5ToDefault() {
        ImageIcon defaultImage = getPictureBlackWhite();
        pig5_1.setIcon(defaultImage);
        pig5_2.setIcon(defaultImage);
        pig5_3.setIcon(defaultImage);
        pig5_4.setIcon(defaultImage);
        pig5_5.setIcon(defaultImage);
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

    // SetColorPicture
    public void setPig1ToColor() {
        ImageIcon colorImage = getPictureColor();
        pig1_1.setIcon(colorImage);
    }

    public void setPig2ToColor(int pigCount) {
        ImageIcon colorImage = getPictureColor();
        if (pigCount == 1) {
            pig2_1.setIcon(colorImage);
        } else {
            pig2_2.setIcon(colorImage);
        }
    }

    public void setPig3ToColor(int pigCount) {
        ImageIcon colorImage = getPictureColor();
        switch (pigCount) {
            case 1 -> pig3_1.setIcon(colorImage);
            case 2 -> pig3_2.setIcon(colorImage);
            default -> pig3_3.setIcon(colorImage);
        }
    }

    public void setPig4ToColor(int pigCount) {
        ImageIcon colorImage = getPictureColor();
        switch (pigCount) {
            case 1 -> pig4_1.setIcon(colorImage);
            case 2 -> pig4_2.setIcon(colorImage);
            case 3 -> pig4_3.setIcon(colorImage);
            default -> pig4_4.setIcon(colorImage);
        }
    }

    public void setPig5ToColor(int pigCount) {
        ImageIcon colorImage = getPictureColor();
        switch (pigCount) {
            case 1 -> pig5_1.setIcon(colorImage);
            case 2 -> pig5_2.setIcon(colorImage);
            case 3 -> pig5_3.setIcon(colorImage);
            case 4 -> pig5_4.setIcon(colorImage);
            default -> pig5_5.setIcon(colorImage);
        }
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

    public void setWuerfelImage(int number) {
        ImageIcon imageIcon;
        switch (number) {
            case 1:
                imageIcon = new ImageIcon("src/ui/img/würfel1.png");
                setWuerfel(imageIcon);
                break;
            case 2:
                imageIcon = new ImageIcon("src/ui/img/würfel2.png");
                setWuerfel(imageIcon);
                break;
            case 3:
                imageIcon = new ImageIcon("src/ui/img/würfel3.png");
                setWuerfel(imageIcon);
                break;
            case 4:
                imageIcon = new ImageIcon("src/ui/img/würfel4.png");
                setWuerfel(imageIcon);
                break;
            case 5:
                imageIcon = new ImageIcon("src/ui/img/würfel5.png");
                setWuerfel(imageIcon);
                break;
            default:
                imageIcon = new ImageIcon("src/ui/img/würfel6.png");
                setWuerfel(imageIcon);
        }
    }

    public void setWuerfel(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
        wuerfel.setIcon(new ImageIcon(image));
    }

}
