package domain;

public enum Armours {
    NONE(0),
    LETHER(4),
    SHORTMAIL(7),
    LONGMAIL(10),
    FULLPLATE(15);

    private final int defence;

    Armours(int armour) {
        this.defence = armour;
    }

    public int getDefence() {
        return this.defence;
    }
}
