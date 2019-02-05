package actions;

import monsters.DeadCorpse;
import monsters.EvilLord;
import monsters.Monster;

import java.util.Iterator;
import java.util.List;

public class Battle {
    private EvilLord firstLord;
    private EvilLord secondLord;
    private String winnerName;

    public Battle(final EvilLord firstLord, final EvilLord secondLord) {
        this.firstLord = firstLord;
        this.secondLord = secondLord;
    }

    public void startBattle() {
        final List<Monster> firstLordArmy = firstLord.getArmy();
        final List<Monster> secondLordArmy = secondLord.getArmy();
        Iterator<Monster> firstArmyIterator;
        Iterator<Monster> secondArmyIterator;
        Monster firstWarrior;
        Monster secondWarrior;
        int firstWarriorPosition;
        int secondWarriorPosition;
        int battleRound = 1;
        while (!firstLordArmy.isEmpty() && !secondLordArmy.isEmpty()) {
            System.out.println("+++++++++++++++++++++++++++++++++++");
            System.out.println("The round of battle: " + battleRound);
            System.out.println("+++++++++++++++++++++++++++++++++++");
            System.out.println("The army of the " + firstLord.getLordName() + ":");
            System.out.println(firstLordArmy);
            System.out.println("The army of the " + secondLord.getLordName() + ":");
            System.out.println(secondLordArmy);
            System.out.println("Fight!!!");
            firstArmyIterator = firstLordArmy.iterator();
            secondArmyIterator = secondLordArmy.iterator();
            while (firstArmyIterator.hasNext() && secondArmyIterator.hasNext()) {
                firstWarrior = firstArmyIterator.next();
                secondWarrior = secondArmyIterator.next();
                firstWarriorPosition = firstLordArmy.indexOf(firstWarrior);
                secondWarriorPosition = secondLordArmy.indexOf(secondWarrior);
                clash(firstWarrior, secondWarrior);
                if (secondWarrior.getCurrentHealthPoints() > 0) {
                    clash(secondWarrior, firstWarrior);
                    if (firstWarrior.getCurrentHealthPoints() <= 0) {
                        firstLordArmy.set(firstWarriorPosition, new DeadCorpse());
                    }
                } else {
                    secondLordArmy.set(secondWarriorPosition, new DeadCorpse());
                }
            }
            battleRound++;
            cleanArmy(firstLordArmy);
            cleanArmy(secondLordArmy);
        }
        winnerName = firstLordArmy.isEmpty() ? secondLord.getLordName() : firstLord.getLordName();
    }

    private void clash(final Monster attacker, final Monster defender) {
        System.out.println("Clash!!! " + attacker.getMonsterName() + " hits " + defender.getMonsterName());
        System.out.println(attacker.getMonsterName() + " hits: " + attacker.hitEnemy());
        System.out.println(defender.getMonsterName() + " has: " + defender.getCurrentHealthPoints());
        System.out.println("===============================================");
        defender.getDamage(attacker.hitEnemy());
    }

    public String getWinnerName() {
        return winnerName;
    }

    private void cleanArmy(final List<Monster> army) {
        for (int i = (army.size() - 1); i >= 0; i--) {
            if (army.get(i) instanceof DeadCorpse) {
                army.remove(army.get(i));
            }
        }
    }
}