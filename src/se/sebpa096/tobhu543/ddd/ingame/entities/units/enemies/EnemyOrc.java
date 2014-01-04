package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

public class EnemyOrc extends Enemy {

    public EnemyOrc() {
        super();
        this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.ORC_DOWN));
        this.setMaxVelocity(100.0f);
        this.setRandomHealthMin(30);
        this.setRandomHealthMax(60);
    }
}
