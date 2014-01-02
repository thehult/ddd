package se.sebpa096.tobhu543.ddd.ingame.entities.units;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.Enemy;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

public class UnitChest extends Enemy {

    public UnitChest() {
        super();
        this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.CHEST_DOWN));
        this.setMaxVelocity(0.0f);
        this.setRandomHealthMin(1);
        this.setRandomHealthMax(2);
    }
}
