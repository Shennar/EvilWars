package monsters;

public class Orc extends Monster {

    public Orc(final String name) {
        this.setMonsterName("Orc " + name);
        this.setHealthPoints(this.checkHealth(40));
        this.setHitPoints(this.checkHit(10));
        this.setWeaponType(this.giveWeapons());
        this.setArmourType(this.giveArmour());
        this.setCurrentHealthPoints(this.countTotalHealthPoints());
        this.setTotalDamage(this.countTotalDamage());
    }

    @Override
    public void getDamage(final int damageCaused) {
        setCurrentHealthPoints(getCurrentHealthPoints() - damageCaused);
    }
}
