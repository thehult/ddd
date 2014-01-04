package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;



//import javafx.scene.shape.Rectangle;
//import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.Tester;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
//import javafx.geometry.Rectangle2D;
import org.newdawn.slick.geom.Vector2f;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.enums.Faction;

//import java.awt.Shape;
//import java.awt.geom.Rectangle2D;
//import java.awt.geom.AffineTransform;
//import java.awt.geom.GeneralPath;



/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-25 Time: 19:06 To change this template use File | Settings | File
 * Templates.
 */
public class ESword extends EquippedItem
{
    public static int SWORD_STANDARD_COOLDOWN = 750;
    public  static  int SWORD_STANDARD_LENGTH = 86;
    public static int SWORD_STANDARD_ANGLE_REACH = 120;
    public static int SWORD_STANDARD_DAMAGE = 10;

    public static float SHAKE_POWER = 3; // used for camera shake

    protected static int SWORD_SWING_RESOLUTION = 5; //number of points along arc of hurtbox
    protected static int SWORD_POINT_STEP = SWORD_STANDARD_ANGLE_REACH / (SWORD_SWING_RESOLUTION - 1);

    public ESword(){
	super();
        droppedTwin = new DSword(this);
	cooldownMax = SWORD_STANDARD_COOLDOWN;
    }

    @Override protected void use(final Unit user,final float normX, final float normY) {
	float midAngle = (float)new Vector2f(normX, normY).getTheta();
	float[][] points = new float[SWORD_SWING_RESOLUTION + 1][2]; //plus one for center of player
	Vector2f playerPos = new Vector2f(user.getUniversalCenterX(), user.getUniversalCenterY());
	points[0][0] = playerPos.getX();
	points[0][1] = playerPos.getY();

	float tempAngle = midAngle - SWORD_STANDARD_ANGLE_REACH/2;
	Vector2f curPointer = new Vector2f( (float) (SWORD_STANDARD_LENGTH * Math.cos(Math.toRadians(tempAngle))),
					     (float) (SWORD_STANDARD_LENGTH * Math.sin(Math.toRadians(tempAngle))));
	for(int i = 0; i < SWORD_SWING_RESOLUTION; i++){
	    Vector2f temp = curPointer.copy();
	    temp.add(playerPos);
	    points[i+1][0] = temp.getX();
	    points[i+1][1] = temp.getY();
	    curPointer.add(SWORD_POINT_STEP);
	}

	Polygon hurtBox = new Polygon();
	for(float[] point: points){
	    hurtBox.addPoint(point[0], point[1]);
	}

	//System.out.println("Svärd har träffat: ----------------");
	for (int i = 0; i < Game.GAME_STATE.getLevel().getActiveEntities().size(); i++) {
	    Entity e = Game.GAME_STATE.getLevel().getActiveEntities().get(i);
	    if(e.collidesWith(hurtBox) && user.isHostileTo(e)){
		e.getHit(SWORD_STANDARD_DAMAGE, user);
		Game.GAME_STATE.getCamera().shake(SHAKE_POWER);
	    }
	}
	if(Game.TEST) Tester.testShapes.add(hurtBox);
	//System.out.println("-----------------------------------");
    }
}
