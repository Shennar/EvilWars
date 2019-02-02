package lich;

import monsters.Lich;

public class WasNotResurrected extends LichState{

    public WasNotResurrected(Lich lich){
        super(lich);
    }

    @Override
    public void isResurrected(){
        lich.setNewState(new WasResurrected(lich));
    }

    @Override
    public void voiceOfEvilLord(){
        System.out.println("I give you a chance to serve me again!");
    }
}
