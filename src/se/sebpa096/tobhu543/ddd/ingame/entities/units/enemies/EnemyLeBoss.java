package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

public class EnemyLeBoss extends Enemy {
    public EnemyLeBoss() {
        super();
        this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.LE_BOSS_DOWN));
        this.setMaxVelocity(400.0f);
        this.setRandomHealthMin((Game.GAME_STATE.getLevelNumber() - 1) * 75);
        this.setRandomHealthMax((Game.GAME_STATE.getLevelNumber()) * 75);
    }
}
