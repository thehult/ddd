package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 19:09 To change this template use File | Settings | File
 * Templates.
 */
public class Room
{

    public static int ROOM_WIDTH_IN_TILES = 8; //TODO change to right value
    public static int ROOM_HEIGHT_IN_TILES = 8;

    public static float ROOM_WIDTH_IN_PX = ROOM_WIDTH_IN_TILES * Entity.TILE_WIDTH_IN_PX;
    public static float ROOM_HEIGHT_IN_PX = ROOM_HEIGHT_IN_TILES * Entity.TILE_HEIGHT_IN_PX;

    private int x;
    private int y;

    private Tile[][] tiles = new Tile[ROOM_WIDTH_IN_TILES][ROOM_HEIGHT_IN_TILES];
    private ArrayList<Entity> entityListeners = new ArrayList<Entity>();
    private Room topRoom = null;
    private Room rightRoom = null;
    private Room bottomRoom = null;
    private Room leftRoom = null;
    private Image wallSprite = null;

    public Room(int inRoomGridX, int inRoomGridY){
        x = inRoomGridX;
        y = inRoomGridY;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void update(GameContainer gameContainer, int delta) {
        for(Entity e : entityListeners)
            e.update(gameContainer, delta);
    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Room getTopRoom() {
        return topRoom;
    }

    public void setTopRoom(Room topRoom) {
        this.topRoom = topRoom;
    }

    public Room getRightRoom() {
        return rightRoom;
    }

    public void setRightRoom(Room rightRoom) {
        this.rightRoom = rightRoom;
    }

    public Room getBottomRoom() {
        return bottomRoom;
    }

    public void setBottomRoom(Room bottomRoom) {
        this.bottomRoom = bottomRoom;
    }

    public Room getLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(Room leftRoom) {
        this.leftRoom = leftRoom;
    }

    public Image getWallSprite() {
        return wallSprite;
    }

    public void setWallSprite(Image wallSprite) {
        this.wallSprite = wallSprite;
    }
}
