package se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

@SuppressWarnings("JavaDoc")
public class EnemyLeBoss extends Enemy {

    public static final float LE_BOSS_STANDARD_VELOCITY = 400.0f;
    public static final int LE_BOSS_STANDARD_HP_MULT = 75;

    public EnemyLeBoss() {
	this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.LE_BOSS_DOWN));
        this.setMaxVelocity(LE_BOSS_STANDARD_VELOCITY);
        this.setRandomHealthMin((Game.GAME_STATE.getLevelNumber() - 1) * LE_BOSS_STANDARD_HP_MULT);
        this.setRandomHealthMax((Game.GAME_STATE.getLevelNumber()) * LE_BOSS_STANDARD_HP_MULT);
    }
}
