package lich;

import monsters.Lich;

public class WasResurrected extends LichState {

    public WasResurrected(Lich lich){
        super(lich);
    }

    @Override
    public void isResurrected(){
        lich.setNewState(new WasResurrected(lich));
    }

    @Override
    public void voiceOfEvilLord(){
        System.out.println("Not need in such a servant!");
    }
}
