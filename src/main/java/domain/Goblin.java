package domain;

public class Goblin extends Monster {

    public Goblin(){
        this.setHealthPoints(20);
        this.setHitPoints(5);
    }

    @Override
    public int hitEnemy(){
        return 0;
    }
}
