package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.DroppedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;

/**
 * The item Fire Sword dropped.
 */
public class DFireSword extends DroppedItem
{
    public DFireSword(){
	super(new EFireSword());
	setSprite((Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.FIRE_SWORD_DROPPED));
    }

    public DFireSword(EquippedItem twin) {
        super(twin);
	setSprite((Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.FIRE_SWORD_DROPPED));
    }
}
