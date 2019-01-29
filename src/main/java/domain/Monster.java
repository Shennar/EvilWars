package domain;

public abstract class Monster {

    private int healthPoints;
    private int hitPoints;
    private String monsterName;
    private Armours armourType;
    private Weapons weaponType;
    private int currentHealthPoints;
    private int totalDamage;

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

    public int hitEnemy(){
        return 0;
    };

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " " + monsterName + " " +
                "(HP=" + healthPoints + ")" +
                " wearing " + armourType +
                "and has a " + weaponType;
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
}
