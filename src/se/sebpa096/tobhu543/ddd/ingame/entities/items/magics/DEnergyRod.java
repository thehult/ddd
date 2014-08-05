package se.sebpa096.tobhu543.ddd.ingame.entities.items.magics;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.DroppedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;

/**
 * The item Energy Rod dropped.
 */
public class DEnergyRod extends DroppedItem {
    @SuppressWarnings("UnusedDeclaration") public DEnergyRod(){
        super(new EEnergyRod());
	setSprite((Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.ENERGY_ROD_DROPPED));
    }

    public DEnergyRod(EquippedItem twin) {
        super(twin);
	setSprite((Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.ENERGY_ROD_DROPPED));
    }
}
