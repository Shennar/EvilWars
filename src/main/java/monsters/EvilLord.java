package monsters;

import lich_life.MementoMori;
import lich_life.WasNotResurrected;
import lich_life.WasResurrected;
import monsters.builders.GoblinBuilder;
import monsters.builders.OrcBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EvilLord {

    private String lordName = "Lord";

    private List<Monster> army = new ArrayList<Monster>();

    private Lich lich;

    private MementoMori magicJar;

    public EvilLord(final String lordType) {
        this.lordName = lordType + " " + lordName;
        captureLich();
        saveLich(lich);
        createArmy();
    }

    private void createArmy() {
        final int armySize = 11;
        final int lichPosition = new Random().nextInt(armySize - 1);
        for (int i = 0; i < armySize; i++) {
            if (i == lichPosition) {
                army.add(lich);
                continue;
            }
            if (new Random().nextInt(101) <= 60) {
                army.add(GoblinBuilder.cathcGoblin()
                        .giveName("" + (i + 1) + " of the " + lordName)
                        .build());
            } else {
                army.add(OrcBuilder.cathcOrc()
                        .giveName("" + (i + 1) + " of the " + lordName)
                        .build());
            }
        }
    }

    public List<Monster> getArmy() {
        return army;
    }

    public void onLichDeath() {
        if (lich.getState() instanceof WasNotResurrected) {
            lich.getState().voiceOfEvilLord(lordName);
            resurrectLich();
            lich.setNewState(new WasResurrected(lich));
            System.out.println(lich.getMonsterName() + " has: " + lich.getCurrentHealthPoints());
        } else {
            lich.getState().voiceOfEvilLord(lordName);
        }
    }

    public void resurrectLich() {
        lich.getState().isResurrected(lich);
        lich.resurrect(magicJar);
    }

    public void saveLich(final Lich lich) {
        magicJar = lich.save();
    }

    private void captureLich() {
        lich = new Lich(this);
    }

    public String getLordName() {
        return lordName;
    }
}