package src.bl;

import java.util.Random;

public class PigHoleCLS {
    private int[] fieldArray = new int[6];
    Player player1 = new Player(20);
    Player player2 = new Player(20);

    public int rollDice() {
        return new Random().nextInt(6) + 1;
    }

    public boolean playerMove(Player player, int diceResult) {
        if (fieldArray[diceResult - 1] == diceResult) {
            fieldArray[diceResult - 1] = 0;
            return false;
        }
        fieldArray[diceResult - 1] += 1;
        return true;
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
}