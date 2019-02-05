package lich_life;

public class MementoMori {

    private int savedHealthPoints;

    public MementoMori(final int currentHealthPoints) {
        savedHealthPoints = currentHealthPoints;
    }

    public int getSavedHealthPoints() {
        return savedHealthPoints;
    }
}