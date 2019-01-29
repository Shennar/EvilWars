package domain.builders;

import domain.Lich;

public class LichBuilder extends MonsterBuilder {

    @Override
    public Lich build() {
        return new Lich();
    }
}
