package monsters;

import lich.MementoMori;
import lich.WasNotResurrected;
import monsters.builders.GoblinBuilder;
import monsters.builders.OrcBuilder;

import java.util.*;

public class EvilLord {

    private String name = "Lord";

    private List<Monster> army = new ArrayList<Monster>();

    private Lich lich;

    private MementoMori magicJar;


    public EvilLord(final String lordType) {
        this.name = lordType + " " + name;
        captureLich();
        saveLich();
        createArmy();
    }

    private void createArmy() {
        final int armySize = 11;
        final int lichPosition = new Random().nextInt(armySize - 1);
        for (int i = 0; i < armySize; i++) {
            if (i == lichPosition) {
                army.add(lich);
                break;
            }
            if (new Random().nextInt(101) <= 60) {
                army.add(GoblinBuilder.cathcGoblin()
                        .giveName("" + i)
                        .build());
            } else {
                army.add(OrcBuilder.cathcOrc()
                        .giveName("" + i)
                        .build());
            }
        }
    }

    public List<Monster> getArmy() {
        return army;
    }

    public void onLichDeath() {
        if (lich.getState() instanceof WasNotResurrected) {
            resurrectLich();
            lich.setNewState(new WasNotResurrected(this.lich));
        }
        lich.getState().voiceOfEvilLord();
    }

    public void resurrectLich() {
        lich.resurrect(this.magicJar);
    }

    public void saveLich() {
        magicJar = lich.save();
    }

    private void captureLich() {
        this.lich = new Lich(this);
    }

    public String getName() {
        return name;
    }
}
