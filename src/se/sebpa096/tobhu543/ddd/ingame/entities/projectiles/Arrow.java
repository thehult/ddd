package se.sebpa096.tobhu543.ddd.ingame.entities.projectiles;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;

/**
 * The projectile used by the item EBow.
 */
public class Arrow extends LinearProjectile
{
    public final static int ARROW_STANDARD_DAMAGE = 15;
    public final static float ARROW_STANDARD_SIZE = TILE_HEIGHT_IN_PX;

    public Arrow(final float x, final float y, final float velocityX, final float velocityY, final Unit source) {
	super(x, y, velocityX, velocityY, source);
	this.setFaction(source.getFaction());
	this.setSprite((Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.BOW_PROJECTILE));
	setWidth(ARROW_STANDARD_SIZE);
	setHeight(ARROW_STANDARD_SIZE);
    }

    @Override void hit(final Entity e) {
	if(isHostileTo(e)){
	    e.getHit(ARROW_STANDARD_DAMAGE, null);
	    setCurrentRoom(null);
	}
    }
}
