package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.Tester;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;
import se.sebpa096.tobhu543.ddd.ingame.enums.Faction;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-28 Time: 21:49 To change this template use File | Settings | File
 * Templates.
 */
public class EFireSword extends EquippedItem
{

    public  static  int FIRE_SWORD_STANDARD_LENGTH = 86;
    public static int FIRE_SWORD_STANDARD_ANGLE_REACH = 120;
    public static int FIRE_SWORD_STANDARD_DAMAGE = 15;

    public static float SHAKE_POWER = 3; // used for camera shake

    protected static int FIRE_SWORD_SWING_RESOLUTION = 5; //number of points along arc of hurtbox
    protected static int FIRE_SWORD_POINT_STEP = FIRE_SWORD_STANDARD_ANGLE_REACH / (FIRE_SWORD_SWING_RESOLUTION - 1);

    public static int FIRE_SWORD_STANDARD_COOLDOWN = 750;
    public EFireSword(){
	super();
        droppedTwin = new DFireSword(this);
	cooldownMax = FIRE_SWORD_STANDARD_COOLDOWN;
    }

    @Override
    protected void use(final Unit user, final float normX, final float normY) {
        float midAngle = (float)new Vector2f(normX, normY).getTheta();
        float[][] points = new float[FIRE_SWORD_SWING_RESOLUTION + 1][2]; //plus one for center of player
        Vector2f playerPos = new Vector2f(user.getUniversalCenterX(), user.getUniversalCenterY());
        points[0][0] = playerPos.getX();
        points[0][1] = playerPos.getY();

        float tempAngle = midAngle - FIRE_SWORD_STANDARD_ANGLE_REACH/2;
        Vector2f curPointer = new Vector2f( (float) (FIRE_SWORD_STANDARD_LENGTH * Math.cos(Math.toRadians(tempAngle))),
                (float) (FIRE_SWORD_STANDARD_LENGTH * Math.sin(Math.toRadians(tempAngle))));
        for(int i = 0; i < FIRE_SWORD_SWING_RESOLUTION; i++){
            Vector2f temp = curPointer.copy();
            temp.add(playerPos);
            points[i+1][0] = temp.getX();
            points[i+1][1] = temp.getY();
            curPointer.add(FIRE_SWORD_POINT_STEP);
        }

        Polygon hurtBox = new Polygon();
        for(float[] point: points){
            hurtBox.addPoint(point[0], point[1]);
        }

        //System.out.println("Svärd har träffat: ----------------");
        for (int i = 0; i < Game.GAME_STATE.getLevel().getActiveEntities().size(); i++) {
            Entity e = Game.GAME_STATE.getLevel().getActiveEntities().get(i);
            Rectangle entityHitBox = new Rectangle(e.getUniversalX(),e.getUniversalY(),
                    Tile.TILE_WIDTH_IN_PX, Tile.TILE_HEIGHT_IN_PX);
            boolean hit = hurtBox.intersects(entityHitBox)
                    || hurtBox.contains(entityHitBox)
                    || entityHitBox.contains(hurtBox);
            boolean hostile = (user.getFaction() == Faction.PLAYER && e.getFaction() == Faction.ENEMY )
                    || (user.getFaction() == Faction.ENEMY && e.getFaction() == Faction.PLAYER);
            if(hit && hostile){
                e.getHit(FIRE_SWORD_STANDARD_DAMAGE, user);
                Game.GAME_STATE.getCamera().shake(SHAKE_POWER);
            }
        }
        if(Game.TEST) Tester.testShapes.add(hurtBox);
        //System.out.println("-----------------------------------");
    }
}

