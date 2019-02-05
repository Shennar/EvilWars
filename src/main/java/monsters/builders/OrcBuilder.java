package monsters.builders;

import monsters.Orc;

public class OrcBuilder {

    private String monsterName;

    public static OrcBuilder cathcOrc() {
        return new OrcBuilder();
    }

    public OrcBuilder giveName(final String name) {
        this.monsterName = name;
        return this;
    }

    public Orc build() {
        return new Orc(monsterName);
    }
}
