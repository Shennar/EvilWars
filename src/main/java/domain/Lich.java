package domain;

import actions.MementoMori;

public class Lich extends Monster {

    public Lich(){
        this.setHealthPoints(80);
        this.setHitPoints(0);
    }

    private boolean isResurrected = false;
    private MementoMori magicJar;

    private void onDeath(){

    }

    public boolean isResurrected() {
        return isResurrected;
    }

    public void setResurrected(boolean resurrected) {
        isResurrected = resurrected;
    }

    @Override
    public int hitEnemy() {
        return 0;
    }
}
