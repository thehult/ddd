package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.Level;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 19:09 To change this template use File | Settings | File
 * Templates.
 */
public class Room extends Entity //extend entity maybe?
{

    public static int ROOMTILE_WIDTH_IN_TILES = 8; //TODO change to right value
    public static int ROOMTILE_HEIGHT_IN_TILES = 8;

    public static float ROOMTILE_WIDTH_IN_PX = ROOMTILE_WIDTH_IN_TILES * Level.TILE_WIDTH_IN_PX;
    public static float ROOMTILE_HEIGHT_IN_PX = ROOMTILE_HEIGHT_IN_TILES * Level.TILE_HEIGHT_IN_PX;

    private int roomGridX;
    private int roomGridY;

    public Room(int inRoomGridX, int inRoomGridY){
        super(inRoomGridX * ROOMTILE_WIDTH_IN_PX, inRoomGridY * ROOMTILE_HEIGHT_IN_PX, 0);
        roomGridX = inRoomGridX;
        roomGridY = inRoomGridY;

    }

    public Room(int inRoomGridX, int inRoomGridY, Image inSprite){
        super(inRoomGridX * ROOMTILE_WIDTH_IN_PX, inRoomGridY * ROOMTILE_HEIGHT_IN_PX, 0, inSprite);
        roomGridX = inRoomGridX;
        roomGridY = inRoomGridY;
    }

    @Override public void update(final GameContainer gameContainer, final int delta) {

    }
}
