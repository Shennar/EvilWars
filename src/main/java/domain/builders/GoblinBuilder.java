package domain.builders;

import domain.Goblin;

public class GoblinBuilder extends MonsterBuilder {

    @Override
    public Goblin build() {
        return new Goblin();
    }
}
