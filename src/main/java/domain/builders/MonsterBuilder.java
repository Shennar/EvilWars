package domain.builders;

import domain.Armours;
import domain.Monster;
import domain.Weapons;

import java.util.Random;

public abstract class MonsterBuilder {

    private int healthPoints;
    private int hitPoints;
    private String monsterName;
    private Armours armourType;
    private Weapons weaponType;
    private int currentHealthPoints;
    private int totalDamage;


    abstract <T extends Monster> T build();

    public MonsterBuilder totalDamage() {
        this.totalDamage = this.hitPoints + this.weaponType.getDamage();
        return this;
    }

    public MonsterBuilder totalHealthPoints() {
        this.currentHealthPoints = this.healthPoints + this.armourType.getDefence();
        return this;
    }

    public MonsterBuilder checkHealth(final int basicHealthPoints) {
        this.healthPoints = makeRandomChoice((int) Math.round(basicHealthPoints * .9),
                (int) Math.round(basicHealthPoints * 1.1));
        return this;
    }

    public MonsterBuilder checkHit(final int basicDamage) {
        this.hitPoints = makeRandomChoice((int) Math.round(basicDamage * .9),
                (int) Math.round(basicDamage * 1.1));
        return this;
    }

    public MonsterBuilder giveWeapons() {
        final int randomChoice = makeRandomChoice(5);
        for (final Weapons weap : Weapons.values()) {
            if (weap.ordinal() == randomChoice) {
                this.weaponType = weap;
            }
        }
        return this;
    }

    public MonsterBuilder giveArmour() {
        final int randomChoice = makeRandomChoice(5);
        for (final Armours armour : Armours.values()) {
            if (armour.ordinal() == randomChoice) {
                this.armourType = armour;
            }
        }
        return this;
    }

    public MonsterBuilder giveName(final String name) {
        this.monsterName = name;
        return this;
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
