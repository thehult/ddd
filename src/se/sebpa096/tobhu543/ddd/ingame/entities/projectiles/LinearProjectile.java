package se.sebpa096.tobhu543.ddd.ingame.entities.projectiles;

import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

/**
 * An abstract class to describe a projectile flying in a line.
 */
public abstract class LinearProjectile extends Projectile
{
    LinearProjectile(float x, float y, float velocityX, float velocityY, Unit source){
	setX(x);
	setY(y);
	setVelocityX(velocityX);
	setVelocityY(velocityY);
	setSource(source);
	setRenderAngle((float)Math.toDegrees(Math.atan2(velocityY,velocityX)));
    }

    @Override void move(int delta) {
	x += velocityX * delta / Game.MILLISEC_PER_SEC;
	y += velocityY * delta / Game.MILLISEC_PER_SEC;
    }


}
