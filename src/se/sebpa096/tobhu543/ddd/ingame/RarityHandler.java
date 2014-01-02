package se.sebpa096.tobhu543.ddd.ingame;

import java.util.ArrayList;

public class RarityHandler extends ArrayList<Rarity> {
    private int totalChance = 0;

    public boolean add(Class object, int chance) {
        return add(new Rarity(object, chance));
    }

    @Override
    public boolean add(Rarity rarity) {
        totalChance += rarity.getChance();
        return super.add(rarity);
    }

    public Class getRandomRarity() {
        int random = (int)(Math.random() * totalChance);
        int currentLow = 0;

        for(int i=0;i<this.size();i++) {
            if(random >= currentLow && random < this.get(i).getChance() + currentLow) {
                return this.get(i).getObject();
            }
            currentLow += this.get(i).getChance();
        }
        return this.get(this.size() - 1).getObject();
    }
}
