package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.camera.Camera;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.enums.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * A Room is a part of a Level. The structure of multiple rooms are tree-based. This and our kind of 2.5D render makes the render methods of a Room kind of complex. We have tried to find a better solution
 */
@SuppressWarnings("JavaDoc")
public class Room implements ILevelListener
{

    public static final int ROOM_WIDTH_IN_TILES = 8; //TODO change to right value
    public static final int ROOM_HEIGHT_IN_TILES = 8;

    public static final float ROOM_WIDTH_IN_PX = ROOM_WIDTH_IN_TILES * Entity.TILE_WIDTH_IN_PX;
    public static final float ROOM_HEIGHT_IN_PX = ROOM_HEIGHT_IN_TILES * Entity.TILE_HEIGHT_IN_PX;

    private int x;
    private int y;

    private Tile[][] tiles = new Tile[ROOM_WIDTH_IN_TILES][ROOM_HEIGHT_IN_TILES];
    private boolean[][] blockingTiles = new boolean[ROOM_WIDTH_IN_TILES + 2][ROOM_HEIGHT_IN_TILES + 2];
    private List<IRoomListener> roomListeners = new ArrayList<IRoomListener>();

    private Level level;

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

    public Room(int inRoomGridX, int inRoomGridY, Level level){
        x = inRoomGridX;
        y = inRoomGridY;
	this.level = level;
        for(int i = 0; i < ROOM_WIDTH_IN_TILES + 2; i++) {
            blockingTiles[i][0] = true;
            blockingTiles[i][ROOM_HEIGHT_IN_TILES + 1] = true;
        }
        for(int i = 0; i < ROOM_HEIGHT_IN_TILES + 2; i++) {
            blockingTiles[0][i] = true;
            blockingTiles[ROOM_WIDTH_IN_TILES + 1][i] = true;
        }

    }

    @SuppressWarnings("UnusedDeclaration") public Tile[][] getTiles() {
        return tiles;
    }

    public void gameUpdate(GameContainer gameContainer, int delta) {
	for(int i = roomListeners.size() - 1; i >= 0; i--){
	    roomListeners.get(i).gameUpdate(gameContainer, delta);
	}
        for(int i = 0; i < entities.size() - 1; i++) {
            if(entities.get(i).getCenterY() > entities.get(i + 1).getCenterY()) {
                Entity tmp = entities.get(i);
                entities.set(i, entities.get(i + 1));
                entities.set(i + 1, tmp);
            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics, Camera camera) {

            if(hasTopRoom())
                topRoom.renderFirst(gameContainer, graphics, camera, Direction.UP);
            if(hasLeftRoom())
                leftRoom.renderFirst(gameContainer, graphics, camera, Direction.LEFT);
            renderFirst(gameContainer, graphics, camera, Direction.NONE);
            if(hasRightRoom())
                rightRoom.renderFirst(gameContainer, graphics, camera, Direction.RIGHT);
            if(hasBottomRoom())
                bottomRoom.renderFirst(gameContainer, graphics, camera, Direction.DOWN);

            if(hasTopRoom())
                topRoom.renderEntities(gameContainer, graphics, camera, Direction.UP);
            if(hasLeftRoom())
                leftRoom.renderEntities(gameContainer, graphics, camera, Direction.LEFT);
            renderEntities(gameContainer, graphics, camera, Direction.NONE);
            if(hasRightRoom())
                rightRoom.renderEntities(gameContainer, graphics, camera, Direction.RIGHT);
            if(hasBottomRoom())
                bottomRoom.renderEntities(gameContainer, graphics, camera, Direction.DOWN);

            if(hasTopRoom())
                topRoom.renderLast(gameContainer, graphics, camera, Direction.UP);
            if(hasLeftRoom())
                leftRoom.renderLast(gameContainer, graphics, camera, Direction.LEFT);
            renderLast(gameContainer, graphics, camera, Direction.NONE);
            if(hasRightRoom())
                rightRoom.renderLast(gameContainer, graphics, camera, Direction.RIGHT);
            if(hasBottomRoom())
                bottomRoom.renderLast(gameContainer, graphics, camera, Direction.DOWN);
    }

    //It is too complex for the inspector, it tells us there might be bugs here
    @SuppressWarnings("ConstantConditions") public void renderFirst(GameContainer gameContainer, Graphics graphics, Camera camera, Direction direction) {
        float screenLeftX = getScreenLeftX(gameContainer, camera, direction);
        float screenTopY = getScreenTopY(gameContainer, camera, direction);

	// BELOW: creating the floor of the  room connectors
        if(direction == Direction.DOWN) {
            graphics.drawImage(tiles[0][0].getSprite(), screenLeftX + (ROOM_WIDTH_IN_TILES / 2.0f) * Entity.TILE_WIDTH_IN_PX, screenTopY -
															      Entity.TILE_HEIGHT_IN_PX);
            graphics.drawImage(tiles[0][0].getSprite(), screenLeftX + (ROOM_WIDTH_IN_TILES / 2.0f - 1) *
								      Entity.TILE_WIDTH_IN_PX, screenTopY -
											       Entity.TILE_HEIGHT_IN_PX);
        }
        if(direction == Direction.UP) {
            graphics.drawImage(tiles[0][0].getSprite(), screenLeftX + (ROOM_WIDTH_IN_TILES / 2.0f) * Entity.TILE_WIDTH_IN_PX, screenTopY + ROOM_HEIGHT_IN_TILES *
																	   Entity.TILE_HEIGHT_IN_PX);
            graphics.drawImage(tiles[0][0].getSprite(), screenLeftX + (ROOM_WIDTH_IN_TILES / 2.0f - 1) *
								      Entity.TILE_WIDTH_IN_PX, screenTopY + ROOM_HEIGHT_IN_TILES *
													    Entity.TILE_HEIGHT_IN_PX);
        }
        if(direction == Direction.RIGHT) {
            graphics.drawImage(tiles[0][0].getSprite(), screenLeftX - Entity.TILE_WIDTH_IN_PX, screenTopY + (ROOM_HEIGHT_IN_TILES / 2.0f) *
													    Entity.TILE_HEIGHT_IN_PX);
            graphics.drawImage(tiles[0][0].getSprite(), screenLeftX - Entity.TILE_WIDTH_IN_PX, screenTopY + (ROOM_HEIGHT_IN_TILES / 2.0f - 1) *
													    Entity.TILE_HEIGHT_IN_PX);
        }
        if(direction == Direction.LEFT) {
            graphics.drawImage(tiles[0][0].getSprite(), screenLeftX + ROOM_WIDTH_IN_TILES * Entity.TILE_WIDTH_IN_PX, screenTopY + (ROOM_HEIGHT_IN_TILES / 2.0f) *
																  Entity.TILE_HEIGHT_IN_PX);
            graphics.drawImage(tiles[0][0].getSprite(), screenLeftX + ROOM_WIDTH_IN_TILES * Entity.TILE_WIDTH_IN_PX, screenTopY + (ROOM_HEIGHT_IN_TILES / 2.0f - 1) *
																  Entity.TILE_HEIGHT_IN_PX);
        }

	// Draw the main floor
        for(int ty = 0; ty < ROOM_HEIGHT_IN_TILES; ty++)
            for(int tx = 0; tx < ROOM_WIDTH_IN_TILES; tx++)
                graphics.drawImage(tiles[tx][ty].getSprite(), screenLeftX + tx * Entity.TILE_WIDTH_IN_PX, screenTopY + ty *
														    Entity.TILE_HEIGHT_IN_PX);
	// Draw a connector wall (needs to be done before the entities)
        if(hasRightRoom())
            graphics.drawImage(wallSpriteTop, screenLeftX + ROOM_WIDTH_IN_TILES * Entity.TILE_WIDTH_IN_PX, screenTopY + (ROOM_HEIGHT_IN_TILES / 2.0f - 2) *
															Entity.TILE_HEIGHT_IN_PX);

	// Draw the top half of the side walls.
        for(int ty = 0; ty <= ROOM_HEIGHT_IN_TILES / 2.0f; ty++) {
            if(!hasLeftRoom() || ty < ROOM_HEIGHT_IN_TILES / 2.0f - 1)
                graphics.drawImage(wallSpriteLeft, screenLeftX - Entity.TILE_WIDTH_IN_PX, screenTopY + ty *
												       Entity.TILE_HEIGHT_IN_PX);
            if(!hasRightRoom() || ty < ROOM_HEIGHT_IN_TILES / 2.0f - 1)
                graphics.drawImage(wallSpriteRight, screenLeftX + ROOM_WIDTH_IN_PX, screenTopY + ty * Entity.TILE_HEIGHT_IN_PX);
        }

	// Draw the top wall
        for(int tx = 0; tx < ROOM_WIDTH_IN_TILES; tx++) {
            if(!hasTopRoom() || !(tx >= ROOM_WIDTH_IN_TILES / 2.0f - 1 && tx <= ROOM_WIDTH_IN_TILES / 2.0f))
                graphics.drawImage(wallSpriteTop, screenLeftX + tx * Entity.TILE_WIDTH_IN_PX, screenTopY -
											     Entity.TILE_HEIGHT_IN_PX);
        }

	//Draw the top connector walls
        if(hasTopRoom()) {
            graphics.drawImage(wallSpriteLeft, screenLeftX + (ROOM_WIDTH_IN_TILES / 2.0f - 2) * Entity.TILE_WIDTH_IN_PX, screenTopY -
															 Entity.TILE_HEIGHT_IN_PX);
            graphics.drawImage(wallSpriteRight, screenLeftX + (ROOM_WIDTH_IN_TILES / 2.0f + 1) * Entity.TILE_WIDTH_IN_PX, screenTopY -
															  Entity.TILE_HEIGHT_IN_PX);
        }

    }

    public void renderLast(GameContainer gameContainer, Graphics graphics, Camera camera, Direction direction) {
        float screenLeftX = getScreenLeftX(gameContainer, camera, direction);
        float screenTopY = getScreenTopY(gameContainer, camera, direction);

	// Draw a connector wall (needs to be done after the entities)
        if(hasRightRoom()) {
            graphics.drawImage(wallSpriteBot, screenLeftX + ROOM_WIDTH_IN_TILES * Entity.TILE_WIDTH_IN_PX, screenTopY + (ROOM_HEIGHT_IN_TILES / 2.0f + 1) *
												Entity.TILE_HEIGHT_IN_PX);
        }
	// Draw the bottom half of the side walls.
        for(int ty = ROOM_HEIGHT_IN_TILES / 2 + 1; ty < ROOM_HEIGHT_IN_TILES;ty++) {
            graphics.drawImage(wallSpriteLeft, screenLeftX - Entity.TILE_WIDTH_IN_PX, screenTopY + ty * Entity.TILE_HEIGHT_IN_PX);
            graphics.drawImage(wallSpriteRight, screenLeftX + ROOM_WIDTH_IN_PX, screenTopY + ty * Entity.TILE_HEIGHT_IN_PX);
        }
	// Draw the walls of the bottom connector
        for(int tx = 0; tx < ROOM_WIDTH_IN_TILES; tx++) {
            if(hasBottomRoom() && (tx == ROOM_WIDTH_IN_TILES / 2 - 1 || tx == ROOM_WIDTH_IN_TILES / 2)) {
                if(direction != Direction.UP) {
                    graphics.drawImage(wallSpriteLeft, screenLeftX + (ROOM_WIDTH_IN_TILES / 2.0f - 2) * Entity.TILE_WIDTH_IN_PX, screenTopY + ROOM_HEIGHT_IN_TILES *
																	      Entity.TILE_HEIGHT_IN_PX);
                    graphics.drawImage(wallSpriteRight, screenLeftX + (ROOM_WIDTH_IN_TILES / 2.0f + 1) *
								      Entity.TILE_WIDTH_IN_PX, screenTopY + ROOM_HEIGHT_IN_TILES *
													    Entity.TILE_HEIGHT_IN_PX);
                }
            }
            else
                graphics.drawImage(wallSpriteTop, screenLeftX + tx * Entity.TILE_WIDTH_IN_PX, screenTopY + (ROOM_HEIGHT_IN_TILES - 1) *
													  Entity.TILE_HEIGHT_IN_PX);
        }
	// Draw just a part of the walls of the top connector, to cover the entities correctly
        if(hasTopRoom()) {
            graphics.drawImage(wallSpriteLeft.getSubImage(0,0, (int) Entity.TILE_WIDTH_IN_PX, (int)-Entity.TILE_RENDER_OFFSET_Y), screenLeftX + (ROOM_WIDTH_IN_TILES / 2.0f - 2) *
																		Entity.TILE_WIDTH_IN_PX, screenTopY -
																					 Entity.TILE_HEIGHT_IN_PX);
            graphics.drawImage(wallSpriteRight.getSubImage(0,0, (int) Entity.TILE_WIDTH_IN_PX, (int)-Entity.TILE_RENDER_OFFSET_Y), screenLeftX + (ROOM_WIDTH_IN_TILES / 2.0f + 1) *
																		 Entity.TILE_WIDTH_IN_PX, screenTopY -
																					  Entity.TILE_HEIGHT_IN_PX);
        }
    }

    public void renderEntities(GameContainer gameContainer, Graphics graphics, Camera camera, Direction direction) {
        float screenLeftX = getScreenLeftX(gameContainer, camera, direction);
        float screenTopY = getScreenTopY(gameContainer, camera, direction);

        for(Entity entity : entities) {
            entity.render(gameContainer, graphics, screenLeftX, screenTopY);
        }
    }

    private float getScreenLeftX(GameContainer gameContainer, Camera camera, Direction direction) {
	float screenLeftX = gameContainer.getWidth() / 2.0f - camera.getX();
	if(direction == Direction.LEFT)
	    screenLeftX -= (Room.ROOM_WIDTH_IN_PX + Entity.TILE_WIDTH_IN_PX);
	if(direction == Direction.RIGHT)
	    screenLeftX += (Room.ROOM_WIDTH_IN_PX + Entity.TILE_WIDTH_IN_PX);
	return screenLeftX;
    }

    private float getScreenTopY(GameContainer gameContainer, Camera camera, Direction direction) {
	float screenTopY = gameContainer.getHeight() / 2.0f - camera.getY();
	if(direction == Direction.UP)
	    screenTopY -= (Room.ROOM_HEIGHT_IN_PX + Entity.TILE_HEIGHT_IN_PX);
	if(direction == Direction.DOWN)
	    screenTopY += (Room.ROOM_HEIGHT_IN_PX + Entity.TILE_HEIGHT_IN_PX);
	return screenTopY;
    }

    @SuppressWarnings("UnusedDeclaration") private void setRenderableBounds() {
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

    public boolean isBlockingTile(int blockX, int blockY) {
        if(blockX >= blockingTiles.length || blockY >= blockingTiles[0].length)
            return false;
        return blockingTiles[blockX][blockY];
    }

    public int getX() {
        return x;
    }

    @SuppressWarnings("UnusedDeclaration") public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    @SuppressWarnings("UnusedDeclaration") public void setY(int y) {
        this.y = y;
    }

    public Room getTopRoom() {
        return topRoom;
    }

    public void setTopRoom(Room topRoom) {
        this.topRoom = topRoom;
        blockingTiles[ROOM_WIDTH_IN_TILES / 2 + 1][0] = (topRoom == null);
        blockingTiles[ROOM_WIDTH_IN_TILES / 2][0] = (topRoom == null);
    }

    public Room getRightRoom() {
        return rightRoom;
    }

    public void setRightRoom(Room rightRoom) {
        this.rightRoom = rightRoom;
        blockingTiles[ROOM_WIDTH_IN_TILES + 1][ROOM_HEIGHT_IN_TILES / 2 + 1] = (rightRoom == null);
        blockingTiles[ROOM_WIDTH_IN_TILES + 1][ROOM_HEIGHT_IN_TILES / 2] = (rightRoom == null);
    }

    public Room getBottomRoom() {
        return bottomRoom;
    }

    public void setBottomRoom(Room bottomRoom) {
        this.bottomRoom = bottomRoom;
        blockingTiles[ROOM_WIDTH_IN_TILES / 2 + 1][ROOM_HEIGHT_IN_TILES + 1] = (bottomRoom == null);
        blockingTiles[ROOM_WIDTH_IN_TILES / 2][ROOM_HEIGHT_IN_TILES + 1] = (bottomRoom == null);
    }

    public Room getLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(Room leftRoom) {
        this.leftRoom = leftRoom;
        blockingTiles[0][ROOM_HEIGHT_IN_TILES / 2 + 1] = (leftRoom == null);
        blockingTiles[0][ROOM_HEIGHT_IN_TILES / 2] = (leftRoom == null);
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

    @SuppressWarnings("UnusedDeclaration") public Image getWallSpriteTop() {
        return wallSpriteTop;
    }

    @SuppressWarnings("UnusedDeclaration") public Image getWallSpriteBot() {
        return wallSpriteBot;
    }

    @SuppressWarnings("UnusedDeclaration") public Image getWallSpriteLeft() {
        return wallSpriteLeft;
    }

    @SuppressWarnings("UnusedDeclaration") public Image getWallSpriteRight() {
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
        return topRoom != null;
    }

    public boolean hasRightRoom() {
        return rightRoom != null;
    }

    public boolean hasBottomRoom() {
        return bottomRoom != null;
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void removeEntity(Entity e) {
        if(entities.contains(e))
            entities.remove(e);
    }

    public void addRoomListener(IRoomListener e){
	    roomListeners.add(e);
    }

    public void removeRoomListener(IRoomListener e){
	    roomListeners.remove(e);
    }

    public Iterable<Entity> getEntities() {
	return entities;
    }

    public Level getLevel() {
	return level;
    }

    //It is not a bug that it takes a Room instead of Object
    @SuppressWarnings({ "UnusedDeclaration", "CovariantEquals", "MethodOverloadsMethodOfSuperclass" }) public boolean equals(Room obj) {
        return obj.x == this.x && obj.y == this.y;
    }

    public void setBlockingTile(int gridX, int gridY, boolean blocking) {
        blockingTiles[gridX][gridY] = blocking;
    }
}
