package se.sebpa096.tobhu543.ddd.ingame.entities.projectiles;

import se.sebpa096.tobhu543.ddd.Game;
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
	x += velocityX * delta / Game.MILLISEC_PER_SEC;
	y += velocityY * delta / Game.MILLISEC_PER_SEC;
    }


}
