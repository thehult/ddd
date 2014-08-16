package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.enemyfactories;

import se.sebpa096.tobhu543.ddd.ingame.RarityHandler;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.bows.EBow;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.magics.EEYeOfTheStorm;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.magics.EEnergyRod;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.ESword;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.Enemy;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemySkeleton;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemyWizard;

public class EnemyWizardFactory implements EnemyFactory {
    @java.lang.Override
    public Enemy createEnemy() {
        EnemyWizard e = new EnemyWizard();
        RarityHandler itemHandler = new RarityHandler();
        itemHandler.add(EEnergyRod.class, 10);
        itemHandler.add(EEYeOfTheStorm.class, 1);

        e.setRandomHealth();
        e.getEquippedItems()[0] = (EquippedItem)itemHandler.getRandomRarity().newInstance();
        return e;
    }
}
