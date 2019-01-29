package domain;

public class Orc extends Monster {

    public Orc(final String name, final int healthPoints, final int hitPoints,
               final Weapons weaponType, final Armours armourType,
               final int totalHealthPoints, final int totalDamage){
        this.setMonsterName(name);
        this.setHealthPoints(healthPoints);
        this.setHitPoints(hitPoints);
        this.setWeaponType(weaponType);
        this.setArmourType(armourType);
        this.setCurrentHealthPoints(totalHealthPoints);
        this.setTotalDamage(totalDamage);
    }

    @Override
    public int hitEnemy(){
        return 0;
    }
}
