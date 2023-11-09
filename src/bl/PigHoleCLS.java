package src.bl;

import java.util.Random;

public class PigHoleCLS {
    private int[] fieldArray = new int[6];

    public int rollDice() {
        return new Random().nextInt(6) + 1;
    }

    public boolean rollDiceCheck() {
        int fullDices = 0;
        for (int i = 0; i < 6; i++) {
            if (fieldArray[i] == i + 1) {
                fullDices++;
            }
        }
        double throwDiceChance = (fullDices / 6) * 100;
        if (throwDiceChance > 50) {
            return true;
        }
        return false;
    }
}