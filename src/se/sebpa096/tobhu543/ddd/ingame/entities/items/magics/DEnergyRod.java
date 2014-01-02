package se.sebpa096.tobhu543.ddd.ingame.entities.items.magics;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.DroppedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.bows.EBow;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;

public class DEnergyRod extends DroppedItem {
    public DEnergyRod(){
        super(new EEnergyRod());
        sprite = (Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.ENERGY_ROD_DROPPED);
    }

    public DEnergyRod(EquippedItem twin) {
        super(twin);
        sprite = (Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.ENERGY_ROD_DROPPED);
    }
}
