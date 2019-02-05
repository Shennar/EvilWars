package lich_life;

import monsters.Lich;

public class WasResurrected extends LichState {

    public WasResurrected(final Lich lich){
        super(lich);
    }

    @Override
    public void isResurrected(final Lich lich){
        lich.setNewState(new WasResurrected(lich));
    }

    @Override
    public void voiceOfEvilLord(final String speakerName){
        System.out.println(speakerName + " says: No need in such a servant!");
    }
}