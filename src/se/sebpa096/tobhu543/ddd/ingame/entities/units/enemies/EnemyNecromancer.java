package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

public class EnemyNecromancer extends Enemy {

    public EnemyNecromancer() {
        super();
        this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.NECROMANCER_DOWN));
        this.setMaxVelocity(110.0f);
        this.setRandomHealthMin(20);
        this.setRandomHealthMax(40);
    }
}
