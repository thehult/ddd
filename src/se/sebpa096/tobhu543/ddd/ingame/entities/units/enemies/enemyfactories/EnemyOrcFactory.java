package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.enemyfactories;

import se.sebpa096.tobhu543.ddd.ingame.RarityHandler;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.bows.EBow;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.EFireSword;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.ESword;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.Enemy;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemyOrc;

public class EnemyOrcFactory implements EnemyFactory {
    @java.lang.Override
    public Enemy createEnemy() {
        EnemyOrc e = new EnemyOrc();
        RarityHandler orcHandler = new RarityHandler();
        orcHandler.add(ESword.class, 70);
        orcHandler.add(EFireSword.class, 8);
        orcHandler.add(EBow.class, 22);

        e.setRandomHealth();
        e.getEquippedItems()[0] = (EquippedItem)orcHandler.getRandomRarity().newInstance();
        return e;
    }
}
