package src.bl;

import static src.bl.PigHoleCLS.fieldArray;

public class Player {
    private int pigs;
    private int turn;

    public Player(int pigs) {
        this.pigs = pigs;
    }

    public int getPigs() {
        return pigs;
    }

    public void setPigs(int pigs) {
        this.pigs = pigs;
    }

    public void addPigs(int pigs) {
        this.pigs += pigs;
    }

    public void removePig() {
        this.pigs--;
    }

    //0 = erster Turn
    public boolean getTurn() {
        if (turn == 0) {
            return true;
        } else if (turn == 1) {
            return false;
        }
        return false;
    }

    public void setTurn(int turn) {
        this.turn = turn;
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
