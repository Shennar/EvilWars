package actions;

import domain.EvilLord;
import domain.Monster;

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
        while (firstLordArmy.isEmpty() && secondLordArmy.isEmpty()) {
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
                        firstLordArmy.remove(firstWarriorPosition);
                    }
                } else {
                    secondLordArmy.remove(secondWarriorPosition);
                }
            }
        }
        if (firstLordArmy.isEmpty()) {
            winnerName = secondLord.getName();
        } else winnerName = firstLord.getName();
    }

    private void clash(final Monster attacker, final Monster defender) {
        int healthPointsLeft = defender.getCurrentHealthPoints() - attacker.hitEnemy();
        defender.setCurrentHealthPoints(healthPointsLeft);
    }

    public String getWinnerName() {
        return winnerName;
    }
}
