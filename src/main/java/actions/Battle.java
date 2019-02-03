package actions;

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
        List<Monster> firstLordArmy = firstLord.getArmy();
        List<Monster> secondLordArmy = secondLord.getArmy();

        Iterator<Monster> firstArmyIterator;
        Iterator<Monster> secondArmyIterator;
        Monster firstWarrior;
        Monster secondWarrior;
        int firstWarriorPosition;
        int secondWarriorPosition;
        int battleRound = 1;
        while (!firstLordArmy.isEmpty() && !secondLordArmy.isEmpty()) {
            System.out.println("The round of battle: " + battleRound);
            System.out.println("The army of the " + firstLord.getName() + ":");
            System.out.println(firstLordArmy);
            System.out.println("The army of the " + secondLord.getName() + ":");
            System.out.println(secondLordArmy);
            System.out.println("Fight!!!");
            firstArmyIterator = firstLordArmy.iterator();
            secondArmyIterator = secondLordArmy.iterator();
            while (firstArmyIterator.hasNext() && secondArmyIterator.hasNext()) {
                firstWarrior = firstArmyIterator.next();
                firstWarriorPosition = firstLordArmy.indexOf(firstWarrior);
                secondWarrior = secondArmyIterator.next();
                secondWarriorPosition = secondLordArmy.indexOf(secondWarrior);
                clash(firstWarrior, secondWarrior);
                if (secondWarrior.getCurrentHealthPoints() > 0) {
                    clash(secondWarrior, firstWarrior);
                    if (firstWarrior.getCurrentHealthPoints() <= 0) {
                        firstLordArmy.add(firstWarriorPosition, null);
                    }
                } else {
                    secondLordArmy.add(secondWarriorPosition, null);
                }
            }
            battleRound++;
            cleanArmy(firstLordArmy);
            cleanArmy(secondLordArmy);
        }
        if (firstLordArmy.isEmpty()) {
            winnerName = secondLord.getName();
        } else winnerName = firstLord.getName();
    }

    private void clash(final Monster attacker, final Monster defender) {
        defender.getDamage(attacker.hitEnemy());
        System.out.println(attacker.getMonsterName() + " hits: " + attacker.hitEnemy());
        System.out.println(defender.getMonsterName()+ " has: " + defender.getCurrentHealthPoints());
    }

    public String getWinnerName() {
        return winnerName;
    }

    private void cleanArmy(List<Monster> army) {
        for (final Monster monster : army) {
            if (monster == null) {
                army.remove(monster);
            }
        }
    }
}
