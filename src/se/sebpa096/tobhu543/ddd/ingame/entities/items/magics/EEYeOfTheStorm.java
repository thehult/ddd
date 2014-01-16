package se.sebpa096.tobhu543.ddd.ingame.entities.items.magics;

import org.newdawn.slick.geom.Vector2f;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.projectiles.EnergyOrb;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 03/01/14 Time: 22:32 To change this template use File | Settings | File
 * Templates.
 */
@SuppressWarnings("JavaDoc")
public class EEYeOfTheStorm extends EquippedItem
{
    public static final int EOTS_STANDARD_COOLDOWN = 5000;
    public static final int EOTS_STANDARD_NO_PROJECTILES = 10;
    public static final float EOTS_STANDARD_START_VEL = 100;
    public static final float EOTS_STANDARD_SCALE = 1.0f;

    private static final float EOTS_STEP_SIZE = 360.0f / EOTS_STANDARD_NO_PROJECTILES;

    public EEYeOfTheStorm(){
	cooldownMax = EOTS_STANDARD_COOLDOWN;
        this.setRange(6 * Entity.TILE_WIDTH_IN_PX);
        droppedTwin = new DEyeOfTheStorm(this);
    }

    @Override protected void use(final Unit user, final float normX, final float normY) {
	Vector2f pointerVec = new Vector2f(EOTS_STANDARD_START_VEL, 0);
	for(int i = 0; i < EOTS_STANDARD_NO_PROJECTILES; i++){
	    EnergyOrb curOrb = new EnergyOrb(user.getX(), user.getY(), pointerVec.getX(), pointerVec.getY(), user);
	    curOrb.setCurrentRoom(user.getCurrentRoom());
	    pointerVec.add(EOTS_STEP_SIZE);
	    pointerVec.scale(EOTS_STANDARD_SCALE);
	}
    }
}
