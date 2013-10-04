package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.ingame.entities.Room;
import se.sebpa096.tobhu543.ddd.ingame.entities.Wall;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 18:56 To change this template use File | Settings | File
 * Templates.
 */
public class Level
{
    public static int TILE_WIDTH_IN_PX = 72;
    public static int TILE_HEIGHT_IN_PX = 72;
    public static int PX_HEIGHT_PER_Z = 24; //TODO change this!

    private ArrayList<Room> rooms;
    private ArrayList<Wall> walls;


    public Level(){
        rooms = new ArrayList<Room>();
        walls = new ArrayList<Wall>();
    }

    public void addRoom(Room room/*, int gridX, int gridY*/){
	    rooms.add(room);
    }

    public void addWall(Wall wall){
	    walls.add(wall);
    }



    public void update(GameContainer gameContainer, int delta){
        for(Room r: rooms){
            r.update(gameContainer, delta);
        }
        for(Wall w: walls){
            w.update(gameContainer, delta);
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics){
        for(Room r: rooms){
            r.render(gameContainer, graphics);
        }
        for(Wall w: walls){
            w.render(gameContainer, graphics);
        }
    }
}
