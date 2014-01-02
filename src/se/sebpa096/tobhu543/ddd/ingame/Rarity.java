package se.sebpa096.tobhu543.ddd.ingame;

public class Rarity {
    private int chance = 0;
    private Class object = null;

    public Rarity(Class object, int chance) {
        this.chance = chance;
        this.object = object;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public Class getObject() {
        return object;
    }

    public void setObject(Class object) {
        this.object = object;
    }
}
