package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

/**
 * An enemy.
 */
public class EnemyWizard extends Enemy {

    public static final float WIZARD_STANDARD_VELOCITY = 110.0f;
    public static final int WIZARD_STANDARD_MIN_HEALTH = 30;
    public static final int WIZARD_STANDARD_MAX_HEALTH = 60;

    public EnemyWizard() {
	this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.WIZARD_DOWN));
        this.setMaxVelocity(WIZARD_STANDARD_VELOCITY);
        this.setRandomHealthMin(WIZARD_STANDARD_MIN_HEALTH);
        this.setRandomHealthMax(WIZARD_STANDARD_MAX_HEALTH);
    }
}
