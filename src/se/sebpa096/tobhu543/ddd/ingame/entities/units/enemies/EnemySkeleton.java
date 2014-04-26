package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

/**
 * An enemy.
 */
public class EnemySkeleton extends Enemy {

    public static final float SKELETON_STANDARD_VELOCITY = 75.0f;
    public static final int SKELETON_STANDARD_MIN_HEALTH = 20;
    public static final int SKELETON_STANDARD_MAX_HEALTH = 40;

    public EnemySkeleton() {
	this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.SKELETON_DOWN));
        this.setMaxVelocity(SKELETON_STANDARD_VELOCITY);
        this.setRandomHealthMin(SKELETON_STANDARD_MIN_HEALTH);
        this.setRandomHealthMax(SKELETON_STANDARD_MAX_HEALTH);
    }
}
