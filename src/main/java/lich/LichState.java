package lich;

import monsters.Lich;

public abstract class LichState {

    final Lich lich;

    public LichState(Lich lich) {
        this.lich = lich;
    }

    public abstract void isResurrected();

    public abstract void voiceOfEvilLord();
}
