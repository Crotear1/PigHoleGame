package src.bl;

import java.util.Random;

public class PigHoleCLS {
    private int[] fieldArray = new int[6];
    Player player1 = new Player(20);
    Player player2 = new Player(20);

    public PigHoleCLS() {
    }

    public int rollDice() {
        return new Random().nextInt(6) + 1;
    }

    public boolean playerMove() {
        int diceResult = rollDice();
        if (fieldArray[diceResult - 1] == diceResult) {
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
        double throwDiceChance = (fullFields / 6) * 100;
        if (throwDiceChance > 50) {
            return true;
        }
        return false;
    }
}