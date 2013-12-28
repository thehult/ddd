package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.Room;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 20:52 To change this template use File | Settings | File
 * Templates.
 */
public class Entity
{
    protected Image sprite;


    public static float TILE_WIDTH_IN_PX = 72.0f;
    public static float TILE_HEIGHT_IN_PX = 72.0f;
    public static float PX_HEIGHT_PER_Z = TILE_HEIGHT_IN_PX / 3.0f; //TODO change this!
    public static float TILE_RENDER_OFFSET_Y = -2.0f * PX_HEIGHT_PER_Z;

    protected float x;
    protected float y;
    protected float z;

    private Room currentRoom;

    private ArrayList<IEntityListener> entityListeners = new ArrayList<IEntityListener>();


    public void update(GameContainer gameContainer, int delta) {
        for(IEntityListener listener : entityListeners)
            listener.entityChanged();
    }

    public void render(GameContainer gameContainer, Graphics graphics, float screenX, float screenY){
	    sprite.draw(screenX + x, screenY + y );
    }

    public Entity(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Entity(float inX, float inY, float inZ){
        x = inX;
        y = inY;
        z = inZ;
    }

    public Entity(float inX, float inY, float inZ, Image inSprite){
        this(inX, inY, inZ);
        sprite = inSprite;
    }

    public void addEntityListener(IEntityListener listener) {
        entityListeners.add(listener);
    }

    public void removeEntityListener(IEntityListener listener) {
        entityListeners.remove(listener);
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getCenterX() {
       return this.x + TILE_WIDTH_IN_PX / 2.0f;
    }

    public void setCenterX(float cx) {
        this.x = cx - TILE_WIDTH_IN_PX / 2.0f;
    }

    public float getCenterY() {
        return this.y + TILE_HEIGHT_IN_PX / 2.0f;
    }

    public void setCenterY(float cy) {
        this.y = cy - TILE_HEIGHT_IN_PX / 2.0f;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        if(this.getCurrentRoom() != null)
            this.getCurrentRoom().removeEntity(this);
        this.currentRoom = currentRoom;
        for(IEntityListener entity : entityListeners)
            entity.entityChangedRoom(currentRoom);
        this.getCurrentRoom().addEntity(this);
    }
}
