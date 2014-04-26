package se.sebpa096.tobhu543.ddd.ingame;

import java.util.ArrayList;
import java.util.List;

//Raw types... still don't know what it wants me to do different.

/**
 * This class handles rarities, which are the dropchances of Items in Enemies.
 */
@SuppressWarnings({ "rawtypes"})
public class RarityHandler
{
    private final List<Rarity> rarities = new ArrayList<Rarity>();
    private int totalChance = 0;

    public void add(Class object, int chance) {
        add(new Rarity(object, chance));
    }

    public void add(Rarity rarity) {
        totalChance += rarity.getChance();
        rarities.add(rarity);
    }

    public Class getRandomRarity() {
        int random = (int)(Math.random() * totalChance);
        int currentLow = 0;

        for(int i=0;i< rarities.size();i++) {
            if(random >= currentLow && random < rarities.get(i).getChance() + currentLow) {
                return rarities.get(i).getObject();
            }
            currentLow += rarities.get(i).getChance();
        }
        return rarities.get(rarities.size() - 1).getObject();
    }
}
