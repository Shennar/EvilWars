package monsters.builders;

import monsters.Goblin;

public class GoblinBuilder {

    private String monsterName;

    public static GoblinBuilder cathcGoblin() {
        return new GoblinBuilder();
    }

    public GoblinBuilder giveName(final String name) {
        this.monsterName = name;
        return this;
    }

    public Goblin build() {
        return new Goblin(monsterName);
    }
}