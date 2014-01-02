package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

public class EnemySkeleton extends Enemy {

    public EnemySkeleton() {
        super();
        this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.SKELETON_DOWN));
        this.setMaxVelocity(75.0f);
        this.setRandomHealthMin(20);
        this.setRandomHealthMax(60);
    }
}
