package se.sebpa096.tobhu543.ddd.ingame.entities.units;

import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;

@SuppressWarnings("JavaDoc")
public interface IUnitListener {

    //Suppress since not used yet

    public void unitHealthChanged(int health);
    public void unitChangedCurrentItem(int item);
    public void unitChangedItems(EquippedItem[] equippedItems);
    @SuppressWarnings({ "EmptyMethod", "UnusedDeclaration" }) public void unitDied(@SuppressWarnings("UnusedParameters") Unit unit);
    @SuppressWarnings({ "EmptyMethod", "UnusedDeclaration" }) public void unitKilled(@SuppressWarnings("UnusedParameters") Unit unit);
}
