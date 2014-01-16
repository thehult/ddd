package se.sebpa096.tobhu543.ddd.ingame.entities.projectiles;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 03/01/14 Time: 18:22 To change this template use File | Settings | File
 * Templates.
 */
@SuppressWarnings("JavaDoc")
public class Arrow extends LinearProjectile
{
    public final static int ARROW_STANDARD_DAMAGE = 15;
    public final static float ARROW_STANDARD_SIZE = TILE_HEIGHT_IN_PX;

    public Arrow(final float x, final float y, final float velocityX, final float velocityY, final Unit source) {
	super(x, y, velocityX, velocityY, source);
	this.setFaction(source.getFaction());
	this.setSprite((Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.BOW_PROJECTILE));
	this.width = ARROW_STANDARD_SIZE;
	this.height = ARROW_STANDARD_SIZE;
    }

    @Override void hit(final Entity e) {
	if(isHostileTo(e)){
	    e.getHit(ARROW_STANDARD_DAMAGE, null);
	    setCurrentRoom(null);
	}
    }
}
