package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.camera.Camera;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.enums.Direction;

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
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private Room topRoom = null;
    private Room rightRoom = null;
    private Room bottomRoom = null;
    private Room leftRoom = null;
    private Image wallSpriteTop = null;
    private Image wallSpriteBot = null;
    private Image wallSpriteLeft = null;
    private Image wallSpriteRight = null;

    private int renderableLeftX = -1;  //1 är väggarna runt om
    private int renderableRightX = ROOM_WIDTH_IN_TILES + 1;
    private int renderableTopY = -1;
    private int renderableBottomY = ROOM_HEIGHT_IN_TILES + 1;

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

    public void render(GameContainer gameContainer, Graphics graphics, Camera camera) {
        if(hasTopRoom())
            topRoom.render(gameContainer, graphics, camera, Direction.UP);
        if(hasLeftRoom())
            leftRoom.render(gameContainer, graphics, camera, Direction.LEFT);
        if(hasRightRoom())
            rightRoom.render(gameContainer, graphics, camera, Direction.RIGHT);
        render(gameContainer, graphics, camera, Direction.NONE);
        if(hasBottomRoom())
            bottomRoom.render(gameContainer, graphics, camera, Direction.DOWN);
    }

    public void render(GameContainer gameContainer, Graphics graphics, Camera camera, Direction direction) {

        float screenLeftX = gameContainer.getWidth() / 2.0f - camera.getX();
        float screenTopY = gameContainer.getHeight() / 2.0f - camera.getY();
        if(direction == Direction.UP)
            screenTopY -= (Room.ROOM_HEIGHT_IN_PX + Tile.TILE_HEIGHT_IN_PX);
        if(direction == Direction.DOWN)
            screenTopY += (Room.ROOM_HEIGHT_IN_PX + Tile.TILE_HEIGHT_IN_PX);
        if(direction == Direction.LEFT)
            screenLeftX -= (Room.ROOM_WIDTH_IN_PX + Tile.TILE_WIDTH_IN_PX);
        if(direction == Direction.RIGHT)
            screenLeftX += (Room.ROOM_WIDTH_IN_PX + Tile.TILE_WIDTH_IN_PX);

        System.out.println("");
        for(int x = 0; x < ROOM_WIDTH_IN_TILES; x++) {
            if(hasTopRoom()) {
                if(x == ROOM_WIDTH_IN_TILES / 2 - 1) {
                    graphics.drawImage(wallSpriteLeft, screenLeftX + (x - 1) * Tile.TILE_WIDTH_IN_PX, screenTopY - Tile.TILE_HEIGHT_IN_PX);
                    graphics.drawImage(tiles[x][0].getSprite(), screenLeftX + x * Tile.TILE_WIDTH_IN_PX, screenTopY - Tile.TILE_HEIGHT_IN_PX);

                }
                else if(x == ROOM_WIDTH_IN_TILES / 2) {
                    graphics.drawImage(tiles[x][0].getSprite(), screenLeftX + x * Tile.TILE_WIDTH_IN_PX, screenTopY - Tile.TILE_HEIGHT_IN_PX);
                    graphics.drawImage(wallSpriteRight, screenLeftX + (x + 1) * Tile.TILE_WIDTH_IN_PX, screenTopY - Tile.TILE_HEIGHT_IN_PX);
                }
                else
                    graphics.drawImage(wallSpriteTop, screenLeftX + x * Tile.TILE_WIDTH_IN_PX, screenTopY - Tile.TILE_HEIGHT_IN_PX);
            } else
                graphics.drawImage(wallSpriteTop, screenLeftX + x * Tile.TILE_WIDTH_IN_PX, screenTopY - Tile.TILE_HEIGHT_IN_PX);
        }
        for(int y = 0; y < ROOM_HEIGHT_IN_TILES; y++) {
            graphics.drawImage(wallSpriteLeft, screenLeftX - Tile.TILE_WIDTH_IN_PX, screenTopY + y * Tile.TILE_HEIGHT_IN_PX);
            if(hasRightRoom()) {
                if(y == ROOM_HEIGHT_IN_TILES / 2 - 1) {
                    graphics.drawImage(wallSpriteTop, screenLeftX + ROOM_WIDTH_IN_PX, screenTopY + (y - 1) * Tile.TILE_HEIGHT_IN_PX);
                    graphics.drawImage(tiles[ROOM_WIDTH_IN_TILES - 1][y].getSprite(), screenLeftX + ROOM_WIDTH_IN_PX, screenTopY + y * Tile.TILE_HEIGHT_IN_PX);
                }
                else if(y == ROOM_HEIGHT_IN_TILES / 2) {
                    graphics.drawImage(tiles[ROOM_WIDTH_IN_TILES - 1][y].getSprite(),screenLeftX + ROOM_WIDTH_IN_PX, screenTopY + y * Tile.TILE_HEIGHT_IN_PX);
                    graphics.drawImage(wallSpriteBot, screenLeftX + ROOM_WIDTH_IN_PX, screenTopY + (y + 1) * Tile.TILE_HEIGHT_IN_PX);
                }
                else
                    graphics.drawImage(wallSpriteRight, screenLeftX + ROOM_WIDTH_IN_PX, screenTopY + y * Tile.TILE_HEIGHT_IN_PX);
            }
            else
                graphics.drawImage(wallSpriteRight, screenLeftX + ROOM_WIDTH_IN_PX, screenTopY + y * Tile.TILE_HEIGHT_IN_PX);
            for(int x = 0; x < ROOM_WIDTH_IN_TILES; x++)
                graphics.drawImage(tiles[x][y].getSprite(), screenLeftX + x * Tile.TILE_WIDTH_IN_PX, screenTopY + y * Tile.TILE_HEIGHT_IN_PX);
        }

        //HÄR RENDREAR ALLT INOM RUMMET!
        for(Entity entity : entities) {
            entity.render(gameContainer, graphics, screenLeftX, screenTopY);
        }

        for(int x = 0; x < ROOM_WIDTH_IN_TILES; x++) {
            graphics.drawImage(wallSpriteBot, screenLeftX + x * Tile.TILE_WIDTH_IN_PX, screenTopY + ROOM_HEIGHT_IN_PX);
        }

    }

    private void setRenderableBounds() {
        renderableLeftX = -1;
        renderableRightX = ROOM_WIDTH_IN_TILES + 1;
        renderableTopY = -1;
        renderableBottomY = ROOM_HEIGHT_IN_TILES + 1;
        if(hasLeftRoom())
            renderableLeftX -= (ROOM_WIDTH_IN_TILES + 1);
        if(hasRightRoom())
            renderableRightX += (ROOM_WIDTH_IN_TILES + 1);
        if(hasTopRoom())
            renderableTopY -= (ROOM_HEIGHT_IN_TILES + 1);
        if(hasBottomRoom())
            renderableBottomY += (ROOM_HEIGHT_IN_TILES + 1);
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

    public void linkLeftRoom(Room room) {
        this.setLeftRoom(room);
        room.setRightRoom(this);
    }

    public void linkRightRoom(Room room) {
        this.setRightRoom(room);
        room.setLeftRoom(this);
    }

    public void linkTopRoom(Room room) {
        this.setTopRoom(room);
        room.setBottomRoom(this);
    }

    public void linkBottomRoom(Room room) {
        this.setBottomRoom(room);
        room.setTopRoom(this);
    }

    public Image getWallSpriteTop() {
        return wallSpriteTop;
    }

    public Image getWallSpriteBot() {
        return wallSpriteBot;
    }

    public Image getWallSpriteLeft() {
        return wallSpriteLeft;
    }

    public Image getWallSpriteRight() {
        return wallSpriteRight;
    }

    public void setWallSpriteTop(Image wallSprite) {
        this.wallSpriteTop = wallSprite;
    }

    public void setWallSpriteBot(Image wallSprite) {
        this.wallSpriteBot = wallSprite;
    }

    public void setWallSpriteLeft(Image wallSprite) {
        this.wallSpriteLeft = wallSprite;
    }

    public void setWallSpriteRight(Image wallSprite) {
        this.wallSpriteRight = wallSprite;
    }

    public boolean hasLeftRoom() {
        return leftRoom != null;
    }

    public boolean hasTopRoom() {
        return leftRoom != null;
    }

    public boolean hasRightRoom() {
        return leftRoom != null;
    }

    public boolean hasBottomRoom() {
        return leftRoom != null;
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }
}
