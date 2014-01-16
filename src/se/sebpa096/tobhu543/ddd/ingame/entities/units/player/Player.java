package se.sebpa096.tobhu543.ddd.ingame.entities.units.player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.IUpdateListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.enums.Faction;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

@SuppressWarnings("JavaDoc")
public class  Player extends Unit implements IUpdateListener {

    public static final int PLAYER_HP_REGENERATION = 5;
    public static final int PLAYER_HP_REG_COOLDOWN = 2000;

    public static final float PLAYER_STANDARD_MAX_VELOCITY = 600.0f;
    @SuppressWarnings("UnusedDeclaration") public static final int PLAYER_STANDARD_MAX_HEALTH = 100;
    @SuppressWarnings("UnusedDeclaration") public static final int PLAYER_STANDARD_MAX_ITEMS = 6;

    private int regCooldown = PLAYER_HP_REG_COOLDOWN;
    public Player() {
        this.setSprite((Image)GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.PLAYER_DOWN));
        this.setMaxVelocity(PLAYER_STANDARD_MAX_VELOCITY);
        setHealth(100);
        this.setMaxNoItems(6);
	this.setFaction(Faction.PLAYER);

    }

    @Override public void die() {
	super.die();
        Game.setStarted(false);
        Game.GAME_STATE.gameOver();
    }

    @Override
    public void getHit(int incoming, Entity attacker) {
        super.getHit(incoming, attacker);
        System.out.println("Player hit for " + incoming + " hp");
        if(attacker != null) {
            System.out.println("   by: " + attacker.getClass().toString());
        } else
            System.out.println("   by: null");
    }



    @Override
    public void gameUpdate(GameContainer gameContainer, int delta) {
        Input input = gameContainer.getInput();
        float dX = 0.0f, dY = 0.0f;
        if(input.isKeyDown(Input.KEY_LEFT))
            dX = -1.0f;
        if(input.isKeyDown(Input.KEY_RIGHT))
            dX = 1.0f;
        if(input.isKeyDown(Input.KEY_UP))
            dY = -1.0f;
        if(input.isKeyDown(Input.KEY_DOWN))
            dY = 1.0f;
	if(input.isKeyPressed(Input.KEY_Z))
	    cycleCurrentItem(-1);
	if(input.isKeyPressed(Input.KEY_X))
	    cycleCurrentItem(1);
	if(input.isKeyPressed(Input.KEY_SPACE))
	    useItem();
	if(input.isKeyPressed(Input.KEY_C))
	    dropItem(getCurrentItemNo());

        this.setMovingDir(dX, dY);
        regCooldown -= delta;
        if(regCooldown <= 0) {
            regCooldown = PLAYER_HP_REG_COOLDOWN;
            if(this.getHealth() < this.getMaxHealth()) {
                setHealth(this.getHealth() + PLAYER_HP_REGENERATION);
                if(this.getHealth() > this.getMaxHealth()) {
                    setHealth(this.getMaxHealth());
                }
            }
        }


        super.gameUpdate(gameContainer, delta);
    }
}
