package se.sebpa096.tobhu543.ddd.ingame.entities.projectiles;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.MobileEntity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

/**
 * The projectile class that all projectiles extends from. This extends from MobileEntity instead of MovingEntity, since MovingEntity had some movement that wasn't necessary for Projectiles.
 */
public abstract class Projectile extends MobileEntity
{
    public float getVelocityX() {
	return velocityX;
    }

    public void setVelocityX(final float velocityX) {
	this.velocityX = velocityX;
    }

    public float getVelocityY() {
	return velocityY;
    }

    public void setVelocityY(final float velocityY) {
	this.velocityY = velocityY;
    }

    public Unit getSource() {
	return source;
    }

    public void setSource(final Unit source) {
	this.source = source;
    }

    protected float velocityX;
    protected float velocityY;
    protected Unit source = null;

    protected Projectile(){} //MUST supply source to create Projectile

    @SuppressWarnings("UnusedDeclaration") protected Projectile(Unit source){
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
	    if(isCollidingWith(e)){
		hit(e);
	    }
	}
    }

    abstract void hit(Entity e);
    abstract void move(int delta);

}
