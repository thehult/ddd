package se.sebpa096.tobhu543.ddd.ingame.entities.projectiles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.MobileEntity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 03/01/14 Time: 17:53 To change this template use File | Settings | File
 * Templates.
 */
public abstract class Projectile extends MobileEntity
{
    protected float velocityX;
    protected float velocityY;
    protected Unit source;

    protected Projectile(){}; //MUST supply source to create Projectile

    public Projectile(Unit source){
	this.source = source;
    }

    @Override public void gameUpdate(final GameContainer gameContainer, final int delta) {
	super.gameUpdate(gameContainer, delta);    //To change body of overridden methods use File | Settings | File Templates.
	move(delta);
	handleCollision();
    }

    public void handleCollision(){
	//Collision with entities
	for (int i = 0; i < Game.GAME_STATE.getLevel().getActiveEntities().size(); i++) {
	    Entity e = Game.GAME_STATE.getLevel().getActiveEntities().get(i);
	    if(collidesWith(e)){
		hit(e);
	    }
	}
	//TODO: hit with wall!
    }

    abstract void hit(Entity e);
    abstract void move(int delta);

}
