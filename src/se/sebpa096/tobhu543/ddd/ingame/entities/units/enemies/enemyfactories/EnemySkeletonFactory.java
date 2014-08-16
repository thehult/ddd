package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.enemyfactories;

import se.sebpa096.tobhu543.ddd.ingame.RarityHandler;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.bows.EBow;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.EFireSword;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.ESword;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.Enemy;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemyOrc;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemySkeleton;

public class EnemySkeletonFactory implements EnemyFactory {
    @java.lang.Override
    public Enemy createEnemy() {
        EnemySkeleton e = new EnemySkeleton();
        RarityHandler itemHandler = new RarityHandler();
        itemHandler.add(ESword.class, 80);
        itemHandler.add(EBow.class, 20);

        e.setRandomHealth();
        e.getEquippedItems()[0] = (EquippedItem)itemHandler.getRandomRarity().newInstance();
        return e;
    }
}
