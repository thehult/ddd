package se.sebpa096.tobhu543.ddd.ingame;

import se.sebpa096.tobhu543.ddd.ingame.entities.items.bows.EBow;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.magics.EBookOfSin;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.magics.EEnergyRod;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.EFireSword;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.ESword;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.UnitChest;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.*;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

import java.util.HashMap;

public class UnitFactory {
    private static RarityHandler rarities = new RarityHandler();
    private static HashMap<Class<? extends Enemy>, RarityHandler> itemRarities = new HashMap<Class<? extends Enemy>, RarityHandler>();

    public static void init() {
        rarities.add(EnemyOrc.class, 30);
        RarityHandler orcHandler = new RarityHandler();
        orcHandler.add(ESword.class, 70);
        orcHandler.add(EFireSword.class, 8);
        orcHandler.add(EBow.class, 22);
        itemRarities.put(EnemyOrc.class, orcHandler);

        rarities.add(EnemySkeleton.class, 10);
        RarityHandler skeletonHandler = new RarityHandler();
        skeletonHandler.add(ESword.class, 80);
        skeletonHandler.add(EBow.class, 20);
        itemRarities.put(EnemySkeleton.class, skeletonHandler);

        rarities.add(EnemyWizard.class, 10);
        RarityHandler wizardHandler = new RarityHandler();
        wizardHandler.add(EEnergyRod.class, 10);
        itemRarities.put(EnemyWizard.class, wizardHandler);

        rarities.add(EnemyNecromancer.class, 2);
        RarityHandler necroHandler = new RarityHandler();
        necroHandler.add(EBookOfSin.class, 10);
        itemRarities.put(EnemyNecromancer.class, necroHandler);

        rarities.add(UnitChest.class, 8);
        RarityHandler chestHandler = new RarityHandler();
        chestHandler.add(ESword.class, 70);
        chestHandler.add(EFireSword.class, 8);
        chestHandler.add(EBow.class, 22);
        chestHandler.add(EBookOfSin.class, 2);
        itemRarities.put(UnitChest.class, chestHandler);
    }
    public static Unit makeRandomUnit() {
        try {
            Unit unit = (Unit)rarities.getRandomRarity().newInstance();
            unit.setMaxHealth((int)(Math.random() * unit.getRandomHealthMax() + unit.getRandomHealthMin()));
            unit.setHealth(unit.getMaxHealth());
            unit.getEquippedItems()[0] = (EquippedItem)itemRarities.get(unit.getClass()).getRandomRarity().newInstance();
            return unit;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static Unit makeUnit(Class<? extends Unit> unitClass) {
        try {
            Unit unit = unitClass.newInstance();
            unit.setMaxHealth((int)(Math.random() * unit.getRandomHealthMax() + unit.getRandomHealthMin()));
            unit.setHealth(unit.getMaxHealth());
            unit.getEquippedItems()[0] = (EquippedItem)itemRarities.get(unitClass).getRandomRarity().newInstance();
            return unit;
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
