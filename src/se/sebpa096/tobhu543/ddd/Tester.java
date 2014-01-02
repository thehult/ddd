package se.sebpa096.tobhu543.ddd;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import se.sebpa096.tobhu543.ddd.ingame.Room;
import se.sebpa096.tobhu543.ddd.ingame.camera.Camera;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.enums.Direction;

import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 30/12/13 Time: 21:06 To change this template use File | Settings | File
 * Templates.
 */
public class Tester
{
    public static float testScale = 0.1f;
    public static ArrayList<Shape> testShapes = new ArrayList<Shape>();
    public static ArrayList<Room> renderedRooms = new ArrayList<Room>();

    public static void render(GameContainer gameContainer, Graphics graphics) {

	for(Shape testShape: testShapes){
	    /*Camera camera = Game.GAME_STATE.getCamera();
	    float screenLeftX = gameContainer.getWidth() / 2.0f - camera.getX();
	    float screenTopY = gameContainer.getHeight() / 2.0f - camera.getY();
	    testShape.setX(testShape.getX() + screenLeftX);
	    testShape.setY(testShape.getY() + screenTopY);
	    graphics.draw(testShape);
	    testShape.setX(testShape.getX() - screenLeftX);
	    testShape.setY(testShape.getY() - screenTopY);*/
	    drawShape(testShape, gameContainer, graphics);
	}

	for(Entity e: Game.GAME_STATE.getLevel().getActiveEntities()){
	    Rectangle hitBox = new Rectangle(e.getX(), e.getY(), Tile.TILE_WIDTH_IN_PX, Tile.TILE_HEIGHT_IN_PX);
	    drawShape(hitBox, gameContainer, graphics);
	}

    }

    public static void drawShape(Shape shape, GameContainer gameContainer, Graphics graphics){
	 Camera camera = Game.GAME_STATE.getCamera();
	 float screenLeftX = gameContainer.getWidth() / 2.0f - camera.getX();
	 float screenTopY = gameContainer.getHeight() / 2.0f - camera.getY();
	 shape.setX(shape.getX() + screenLeftX);
	 shape.setY(shape.getY() + screenTopY);
	 graphics.draw(shape);
	 shape.setX(shape.getX() - screenLeftX);
	 shape.setY(shape.getY() - screenTopY);
    }

}
