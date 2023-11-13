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

    public void addPigs(int pigs) {
        this.pigs += pigs;
    }

    public void removePig() {
        this.pigs--;
    }
}
