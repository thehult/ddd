package se.sebpa096.tobhu543.ddd.ingame.entities.units.player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.IUpdateListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EUnarmed;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.enums.Faction;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;
import se.sebpa096.tobhu543.ddd.states.GameState;

public class  Player extends Unit implements IUpdateListener {

    public static int PLAYER_HEALTH_REGENERATION = 5;
    public static int PLAYER_HEALTH_REGENERATION_COOLDOWN = 2000;

    private int regCooldown = PLAYER_HEALTH_REGENERATION_COOLDOWN;
    public Player() {
        this.setSprite((Image)GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.PLAYER_DOWN));
        this.setMaxVelocity(600.0f);
        this.setHealth(100);
        this.setMaxNoItems(6);
	this.setFaction(Faction.PLAYER);

    }

    @Override public void die() {
	System.out.println("GAAAAME OVVVEEEERRRRRAR");
	//TODO: fixa lose om spelarn dör
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
            regCooldown = PLAYER_HEALTH_REGENERATION_COOLDOWN;
            if(this.getHealth() < this.getMaxHealth()) {
                this.setHealth(this.getHealth() + PLAYER_HEALTH_REGENERATION);
                if(this.getHealth() > this.getMaxHealth()) {
                    this.setHealth(this.getMaxHealth());
                }
            }
        }


        super.gameUpdate(gameContainer, delta);
    }
}
