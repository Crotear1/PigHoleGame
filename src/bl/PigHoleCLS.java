package src.bl;

import javax.swing.*;
import java.util.Random;

public class PigHoleCLS {
    public static int[] fieldArray = new int[6];

    public int rollDice() {
        return new Random().nextInt(6) + 1;
    }

    public boolean rollDiceCheckComputer() {
        int fullFields = 0;
        for (int i = 0; i < 6; i++) {
            if (fieldArray[i] == i + 1) {
                fullFields++;
            }
        }
        double throwDiceChance = ((double) fullFields / 6) * 100;
        return throwDiceChance < 50;
    }

    public int getPigAnz(int dice) {
        return fieldArray[dice - 1];
    }

    public boolean getWin(Player player, Player bot) {
        if (player.getPigs() <= 0) {
            JOptionPane.showMessageDialog(null, "Sie haben gewonnen!");
            return true;
        } else if (bot.getPigs() <= 0) {
            JOptionPane.showMessageDialog(null, "Bot hat gewonnen!");
            return true;
        }
        return false;
    }

    public boolean playerMove(int diceResult) {
        if (fieldArray[diceResult - 1] == diceResult) {
            fieldArray[diceResult - 1] = 0;
            return false;
        }
        fieldArray[diceResult - 1] += 1;
        return true;
    }
}