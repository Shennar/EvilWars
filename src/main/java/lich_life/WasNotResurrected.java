package lich_life;

import monsters.Lich;

public class WasNotResurrected extends LichState{

    public WasNotResurrected(final Lich lich){
        super(lich);
    }

    @Override
    public void isResurrected(final Lich lich){
        lich.setNewState(new WasResurrected(lich));
    }

    @Override
    public void voiceOfEvilLord(final String speakerName){
        System.out.println(speakerName + " says: I give you a chance to serve me again!");
    }
}