package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.DroppedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;
/**
 * The item Sword dropped.
 */
public class DSword extends DroppedItem
{
    public DSword(){
        super(new ESword());
	setSprite((Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.SWORD_DROPPED));
    }

    public DSword(EquippedItem twin) {
        super(twin);
	setSprite((Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.SWORD_DROPPED));
    }
}
