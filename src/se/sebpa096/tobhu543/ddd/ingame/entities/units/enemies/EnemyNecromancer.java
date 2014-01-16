package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

@SuppressWarnings("JavaDoc")
public class EnemyNecromancer extends Enemy {

    public static final float NECRO_STANDARD_VELOCITY = 110.0f;
    public static final int NECRO_STANDARD_MIN_HEALTH = 40;
    public static final int NECRO_STANDARD_MAX_HEALTH = 80;

    public EnemyNecromancer() {
	this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.NECROMANCER_DOWN));
        this.setMaxVelocity(NECRO_STANDARD_VELOCITY);
        this.setRandomHealthMin(NECRO_STANDARD_MIN_HEALTH);
        this.setRandomHealthMax(NECRO_STANDARD_MAX_HEALTH);
    }
}
