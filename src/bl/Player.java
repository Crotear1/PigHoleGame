package src.bl;

public class Player {
    private int pigs;

    public Player(int pigs) {
        this.pigs = pigs;
    }

    public int getPigs() {
        return pigs;
    }

    public void setPigs(int pigs) {
        this.pigs = pigs;
    }


    // wenn null dann remove pig anzahl, wenn 1 oder mehr füge diese hinzu
    public void changePigs(int pigs) {
        if (pigs == 0) {
            this.pigs--;
        }
        else {
            this.pigs += pigs;
        }
    }
}
