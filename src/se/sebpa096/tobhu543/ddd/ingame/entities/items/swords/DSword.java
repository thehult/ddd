package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.DroppedItem;
import se.sebpa096.tobhu543.ddd.resources.ButtonImageResources;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.TileResources;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-25 Time: 19:09 To change this template use File | Settings | File
 * Templates.
 */
public class DSword extends DroppedItem
{
    public DSword(){
	super(new ESword());
	sprite = (Image) GlobalResources.getResource(GlobalResources.BUTTON_RESOURCES, ButtonImageResources.DEFAULT_STANDARD);
    }
}