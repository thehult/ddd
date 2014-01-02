package se.sebpa096.tobhu543.ddd.ingame.entities.items.magics;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.DroppedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.bows.EBow;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;

public class DBookOfSin extends DroppedItem {
    public DBookOfSin(){
        super(new EBookOfSin());
        sprite = (Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.BOOK_OF_SIN_DROPPED);
    }

    public DBookOfSin(EquippedItem twin) {
        super(twin);
        sprite = (Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.BOOK_OF_SIN_DROPPED);
    }
}
