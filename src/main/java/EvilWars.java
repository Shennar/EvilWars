import actions.Battle;
import domain.EvilLord;

public class EvilWars {
    public static void main(String[] args) {
        EvilLord darkLord = new EvilLord("Dark");
        EvilLord blackLord = new EvilLord("Black");
        Battle battle = new Battle(darkLord, blackLord);
        battle.startBattle();
        System.out.println(battle.getWinnerName() + " wins the battle!");
        System.out.println("He will rule the Universe!");
    }
}