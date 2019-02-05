package monsters;

import lich_life.LichState;
import lich_life.MementoMori;
import lich_life.WasNotResurrected;

public class Lich extends Monster {

    private LichState state;
    private EvilLord lord;

    public Lich(final EvilLord lord) {
        this.setMonsterName(lord.getLordName() + "'s Lich");
        this.setHealthPoints(80);
        this.setHitPoints(0);
        this.setWeaponType(Weapons.FIREBALL);
        this.setArmourType(Armours.NONE);
        this.setCurrentHealthPoints(80);
        this.setTotalDamage(Weapons.FIREBALL.getDamage());
        this.lord = lord;
        state = new WasNotResurrected(this);
    }

    @Override
    public void getDamage(final int damageCaused) {
        setCurrentHealthPoints(getCurrentHealthPoints() - damageCaused);
        if (getCurrentHealthPoints() <= 0) {
            notifyLord();
        }
    }

    public void setNewState(final LichState state) {
        this.state = state;
    }

    public void notifyLord() {
        lord.onLichDeath();
    }

    public LichState getState() {
        return state;
    }

    public void resurrect(final MementoMori magicJar) {
        setCurrentHealthPoints(magicJar.getSavedHealthPoints());
    }

    public MementoMori save() {
        return new MementoMori(getCurrentHealthPoints());
    }

    @Override
    public int hitEnemy() {
        return getTotalDamage();
    }
}
