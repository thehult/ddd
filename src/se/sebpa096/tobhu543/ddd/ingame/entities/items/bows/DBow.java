package se.sebpa096.tobhu543.ddd.ingame.entities.items.bows;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.DroppedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;

/**
 * The dropped bow.
 */
public class DBow extends DroppedItem {
    @SuppressWarnings("UnusedDeclaration") public DBow(){
        super(new EBow());
        sprite = (Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.BOW_DROPPED);
    }

    public DBow(EquippedItem twin) {
        super(twin);
        sprite = (Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.BOW_DROPPED);
    }
}
