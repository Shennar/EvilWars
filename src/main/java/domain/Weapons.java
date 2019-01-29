package domain;

public enum Weapons {
    NONE(0),
    CLUB(2),
    SHORTSWORD(4),
    LONGSWORD(6),
    AXE(8),
    FIREBALL(12);

    private final int weaponDamage;

    Weapons(int damage) {
        this.weaponDamage = damage;
    }
    public int getDamage() {
        return this.weaponDamage;
    }
}
