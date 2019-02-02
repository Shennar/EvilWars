package monsters;

import java.util.Random;

public abstract class Monster {

    private int healthPoints;
    private int hitPoints;
    private String monsterName;
    private Armours armourType;
    private Weapons weaponType;
    private int currentHealthPoints;
    private int totalDamage;

    public abstract void getDamage(final int damageCaused);

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public void setTotalDamage(int totalDamage) {
        this.totalDamage = totalDamage;
    }

    public int hitEnemy() {
        return totalDamage;
    }

    @Override
    public String toString() {
        return monsterName + " " +
                "(HP=" + healthPoints + ")" +
                " wearing " + armourType +
                "and has a " + weaponType + "\n";
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public Armours getArmourType() {
        return armourType;
    }

    public void setArmourType(Armours armourType) {
        this.armourType = armourType;
    }

    public Weapons getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(Weapons weaponType) {
        this.weaponType = weaponType;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int countTotalDamage() {
        return this.hitPoints + this.weaponType.getDamage();
    }

    public int countTotalHealthPoints() {
        return this.healthPoints + this.armourType.getDefence();
    }

    public int checkHealth(final int basicHealthPoints) {
        return makeRandomChoice((int) Math.round(basicHealthPoints * .9),
                (int) Math.round(basicHealthPoints * 1.1));
    }

    public int checkHit(final int basicDamage) {
        return makeRandomChoice((int) Math.round(basicDamage * .9),
                (int) Math.round(basicDamage * 1.1));
    }

    public Weapons giveWeapons() {
        final int randomChoice = makeRandomChoice(5);
        for (final Weapons weap : Weapons.values()) {
            if (weap.ordinal() == randomChoice) {
                return this.weaponType = weap;
            }
        }
        return Weapons.NONE;
    }



    public Armours giveArmour() {
        final int randomChoice = makeRandomChoice(5);
        for (final Armours armour : Armours.values()) {
            if (armour.ordinal() == randomChoice) {
                return this.armourType = armour;
            }
        }
        return Armours.NONE;
    }

    private int makeRandomChoice(final int max) {
        Random rand = new Random();
        return rand.nextInt(max + 1);
    }

    private int makeRandomChoice(final int min, final int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
