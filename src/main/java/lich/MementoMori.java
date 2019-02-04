package lich;

public class MementoMori {

    private int currentHealthPoints;
    private LichState state;

    public MementoMori(int currentHealthPoints, LichState state){
        this.currentHealthPoints = currentHealthPoints;
        this.state = state;
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }
}
