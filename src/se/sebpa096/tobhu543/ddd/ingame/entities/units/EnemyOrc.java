package se.sebpa096.tobhu543.ddd.ingame.entities.units;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

public class EnemyOrc extends Enemy{
    public EnemyOrc() {
        super();
        this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.ORC_DOWN));
        this.setMaxVelocity(150.0f);
        this.setHealth(20);
    }
}
