package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

public class EnemyWizard extends Enemy {

    public EnemyWizard() {
        super();
        this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.WIZARD_DOWN));
        this.setMaxVelocity(110.0f);
        this.setRandomHealthMin(30);
        this.setRandomHealthMax(60);
    }
}
