package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.enemyfactories;

import se.sebpa096.tobhu543.ddd.ingame.RarityHandler;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.bows.EBow;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.magics.EBookOfSin;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.ESword;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.Enemy;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemyNecromancer;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemySkeleton;

public class EnemyNecromancerFactory implements EnemyFactory {
    @java.lang.Override
    public Enemy createEnemy() {
        EnemyNecromancer e = new EnemyNecromancer();
        RarityHandler itemHandler = new RarityHandler();
        itemHandler.add(EBookOfSin.class, 10);

        e.setRandomHealth();
        e.getEquippedItems()[0] = (EquippedItem)itemHandler.getRandomRarity().newInstance();
        return e;
    }
}
