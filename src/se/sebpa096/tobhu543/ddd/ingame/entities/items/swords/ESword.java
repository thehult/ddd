package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;



//import javafx.scene.shape.Rectangle;
import org.lwjgl.util.vector.Vector2f;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Enemy;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.EnemyOrc;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-25 Time: 19:06 To change this template use File | Settings | File
 * Templates.
 */
public class ESword extends EquippedItem
{
    public  static  int SWORD_STANDARD_LENGTH = 100;
    public static int SWORD_STANDARD_COOLDOWN = 750;
    public ESword(){
	super();
	cooldownMax = SWORD_STANDARD_COOLDOWN;
    }

    @Override protected void use(final Unit user,final float normX, final float normY) {
	/*float angle = Vector2f.angle(new Vector2f(normX, normY), new Vector2f(1, 0));
	float leftAngle = angle - 60;
	float[] angles = new float[5];
	Vector2f[] vectors = new Vector2f[5];
	GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 5);
	polyline.moveTo(user.getCenterX(), user.getCenterY());
	for(int i = 0; i < 5; i++){
	    angles[i] = leftAngle + 30 * i;
	    vectors[i].x = (float)Math.cos((double)angles[i]) * SWORD_STANDARD_LENGTH;
	    vectors[i].y = (float)Math.sin((double)angles[i]) * SWORD_STANDARD_LENGTH;
	    polyline.lineTo(vectors[i].x, vectors[i].y);
	}
	polyline.lineTo(user.getCenterX(), user.getCenterY());
	Shape hurtBox = polyline.createTransformedShape(new AffineTransform());
	for(Entity e: Game.GAME_STATE.getLevel().getActiveEntities()){
	    Rectangle2D entityHitBox = new Rectangle2D.Float(e.getX(),e.getY(), Tile.TILE_WIDTH_IN_PX, Tile.TILE_HEIGHT_IN_PX);
	    if(polyline.intersects(entityHitBox)){
		System.out.println("TRÄFF PÅ EN");
		System.out.println(e.getClass());
		System.out.println("------           -------    ");
	    }
	}*/

	System.out.println("CHIIIING!");
    }


}
