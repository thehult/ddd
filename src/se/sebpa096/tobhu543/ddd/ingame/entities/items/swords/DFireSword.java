package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.DroppedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.resources.ButtonImageResources;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;
import se.sebpa096.tobhu543.ddd.resources.TileResources;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-28 Time: 21:49 To change this template use File | Settings | File
 * Templates.
 */
public class DFireSword extends DroppedItem
{
    public DFireSword(){
	super(new EFireSword());
	sprite = (Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.FIRE_SWORD_DROPPED);
    }

    public DFireSword(EquippedItem twin) {
        super(twin);
        sprite = (Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.FIRE_SWORD_DROPPED);
    }
}
