package se.sebpa096.tobhu543.ddd.ingame.entities.projectiles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 03/01/14 Time: 18:34 To change this template use File | Settings | File
 * Templates.
 */
public abstract class LinearProjectile extends Projectile
{
    LinearProjectile(float x, float y, float velocityX, float velocityY, Unit source){
	this.x = x;
	this.y = y;
	this.velocityX = velocityX;
	this.velocityY = velocityY;
	this.source = source;
	this.renderAngle = (float)Math.toDegrees(Math.atan2(velocityY,velocityX));
    }

    @Override void move(int delta) {
	x = x + velocityX * (float)delta / 1000f;
	y = y + velocityY * (float)delta / 1000f;
    }


}
