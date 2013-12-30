package se.sebpa096.tobhu543.ddd.ingame.entities.units;

import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;

public interface IUnitListener {
    public void unitHealthChanged(int health);
    public void unitChangedCurrentItem(int item);
    public void unitChangedItems(EquippedItem[] equippedItems);
    public void unitDied();
    public void unitKilled();
}
