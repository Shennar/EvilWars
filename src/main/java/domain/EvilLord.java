package domain;

import java.util.*;

public class EvilLord {

    private String name = "Lord";

    private List<Monster> army = new ArrayList<Monster>();

    private Lich lich;

    public EvilLord(final String lordType) {
        this.name = lordType + " " + name;
        captureLich(lich);
        createArmy();
    }

    private void createArmy() {
        final int armySize = 11;
        final int lichPosition = new Random().nextInt(11);
        for (int i = 0; i < armySize; i++) {
            if (i == lichPosition) {
                army.add(lich);
                break;
            }
            if (new Random().nextInt(101) <= 60) {
                army.add(new Goblin());
            } else {
                army.add(new Goblin());
            }
        }
    }

    public List<Monster> getArmy() {
        return army;
    }

    public void watchLich() {

    }

    public void resurrectLich() {

    }

    public void saveLich() {

    }

    private void captureLich(Lich lich) {
        this.lich = lich;
    }

    public String getName() {
        return name;
    }
}
