package se.sebpa096.tobhu543.ddd.ingame.entities.projectiles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.ItemResources;

/**
 * The projectile used by the item EEnergyRod and EEyeOfTheStorm.
 */
public class EnergyOrb extends Projectile
{


    public static final float ENERGYORB_STANDARD_ACC = 1;
    public static final int ENERGYORB_STANDARD_DAMAGE = 5;

    private boolean hadTarget = false;


    public EnergyOrb(float x, float y, float velocityX, float velocityY, Unit source){
	setX(x);
	setY(y);
	setVelocityX(velocityX);
	setVelocityY(velocityY);
	setSource(source);
	this.setFaction(source.getFaction());
	this.setSprite((Image) GlobalResources.getResource(GlobalResources.ITEM_RESOURCES, ItemResources.ENERGY_ROD_PROJECTILE));
    }


    protected Entity findTarget(){
	for (int i = 0; i < Game.GAME_STATE.getLevel().getActiveEntities().size(); i++) {
	    Entity e = Game.GAME_STATE.getLevel().getActiveEntities().get(i);
	    if(source.isHostileTo(e)){
		return e;
	    }
	}
	return null;
    }

    @Override void hit(final Entity e) {
	if(isHostileTo(e)){
	    e.getHit(ENERGYORB_STANDARD_DAMAGE, null);
	    setCurrentRoom(null);
	}
    }

    @Override public void gameUpdate(final GameContainer gameContainer, final int delta) {
	super.gameUpdate(gameContainer, delta);
	renderAngle = (float)Math.toDegrees(Math.atan2(velocityY, velocityX));
    }

    @Override void move(int delta) {
	Entity target = findTarget();
	if(target != null){
	    float diffX = -(getUniversalX() - target.getUniversalX());
	    float diffY = -(getUniversalY() - target.getUniversalY());
	    float hypo = (float)Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
	    float normX = diffX/hypo;
	    float normY = diffY/hypo;
	    velocityX += normX * ENERGYORB_STANDARD_ACC;
	    velocityY += normY * ENERGYORB_STANDARD_ACC;
	    hadTarget = true;
	}else if(hadTarget){
	    velocityX -= delta * velocityX / 1000;
	    velocityY -= delta * velocityY / 1000;
	}
	x += velocityX * delta / Game.MILLISEC_PER_SEC;
	y += velocityY * delta / Game.MILLISEC_PER_SEC;
	//To change body of implemented methods use File | Settings | File Templates.
    }
}
