package lich_life;

import monsters.Lich;

public abstract class LichState {

    final Lich lich;

    public LichState(Lich lich) {
        this.lich = lich;
    }

    public abstract void isResurrected(final Lich lich);

    public abstract void voiceOfEvilLord(final String speakerName);
}