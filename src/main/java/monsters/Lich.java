package monsters;

import lich.LichState;
import lich.MementoMori;
import lich.WasResurrected;

public class Lich extends Monster {

    private LichState state;
    private EvilLord lord;

    public Lich(EvilLord lord) {
        this.setMonsterName(lord.getName() + "' Lich");
        this.setHealthPoints(80);
        this.setHitPoints(0);
        this.setWeaponType(Weapons.FIREBALL);
        this.setArmourType(Armours.NONE);
        this.setCurrentHealthPoints(80);
        this.setTotalDamage(Weapons.FIREBALL.getDamage());
        this.lord = lord;
    }

    @Override
    public void getDamage(int damageCaused) {

    }

    public void setNewState(LichState state) {
        this.state = state;
    }

    public void notifyLord() {
        lord.onLichDeath();
    }

    public LichState getState() {
        return state;
    }

    public void resurrect(MementoMori magicJar) {
        this.setCurrentHealthPoints(magicJar.getCurrentHealthPoints());
        this.setNewState(new WasResurrected(this));
    }

    public MementoMori save() {
        return new MementoMori(this.getCurrentHealthPoints(), this.state);
    }

    @Override
    public int hitEnemy() {
        return this.getTotalDamage();
    }
}
