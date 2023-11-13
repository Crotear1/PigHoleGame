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
        return throwDiceChance > 50;
    }

    public int getPigAnz(int dice) {
        return fieldArray[dice - 1];
    }

    public void getWin(Player player, Player bot) {
        if (player.getPigs() <= 0) {
            System.out.println("SPIELER HAT GEWONNEN!");
            JOptionPane.showMessageDialog(null, "Du hast gewonnen!");
            System.exit(0);
        } else if (bot.getPigs() <= 0) {
            System.out.println("BOT HAT GEWONNEN!");
        }
    }
}