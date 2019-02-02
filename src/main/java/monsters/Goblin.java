package monsters;

public class Goblin extends Monster {

    public Goblin(final String name) {
        this.setMonsterName("Goblin " + name);
        this.setHealthPoints(this.checkHealth(20));
        this.setHitPoints(this.checkHit(5));
        this.setWeaponType(this.giveWeapons());
        this.setArmourType(this.giveArmour());
        this.setCurrentHealthPoints(this.countTotalHealthPoints());
        this.setTotalDamage(this.countTotalDamage());
    }

    @Override
    public void getDamage(int damageCaused) {

    }
}
