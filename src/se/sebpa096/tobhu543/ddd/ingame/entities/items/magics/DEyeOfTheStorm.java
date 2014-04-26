package se.sebpa096.tobhu543.ddd.ingame.entities.items.magics;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.DroppedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;

/**
 * The item Eye of the Storm dropped.
 */
public class DEyeOfTheStorm extends DroppedItem
{
    @SuppressWarnings("UnusedDeclaration") public DEyeOfTheStorm(){
        super(new EBookOfSin());
        sprite = (Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.ENERGY_ROD_PROJECTILE);
    }

    public DEyeOfTheStorm(EquippedItem twin) {
        super(twin);
        sprite = (Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.ENERGY_ROD_PROJECTILE);
    }
}
