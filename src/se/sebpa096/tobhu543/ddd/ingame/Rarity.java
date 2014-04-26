package se.sebpa096.tobhu543.ddd.ingame;

//Raw types... don't know how to fix it.

/**
 * A Rarity used by RarityHandler. Basically the drops from creatures.
 */
@SuppressWarnings({ "rawtypes"})
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

    @SuppressWarnings("UnusedDeclaration") public void setChance(int chance) {
        this.chance = chance;
    }

    public Class getObject() {
        return object;
    }

    @SuppressWarnings("UnusedDeclaration") public void setObject(Class object) {
        this.object = object;
    }
}
