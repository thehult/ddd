package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

/**
 * An enemy.
 */
public class EnemyOrc extends Enemy {

    public static final float ORC_STANDARD_VELOCITY = 100.0f;
    public static final int ORC_STANDARD_MIN_HEALTH = 30;
    public static final int ORC_STANDARD_MAX_HEALTH = 60;

    public EnemyOrc() {
	    this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.ORC_DOWN));
        this.setMaxVelocity(ORC_STANDARD_VELOCITY);
        this.setRandomHealthMin(ORC_STANDARD_MIN_HEALTH);
        this.setRandomHealthMax(ORC_STANDARD_MAX_HEALTH);
    }
}
