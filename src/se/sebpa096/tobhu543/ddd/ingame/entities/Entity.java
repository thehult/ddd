package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.IRoomListener;
import se.sebpa096.tobhu543.ddd.ingame.Room;
import se.sebpa096.tobhu543.ddd.ingame.enums.Faction;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 20:52 To change this template use File | Settings | File
 * Templates.
 */
public class Entity implements IRoomListener
{
    protected Image sprite;


    public static float TILE_WIDTH_IN_PX = 72.0f;
    public static float TILE_HEIGHT_IN_PX = 72.0f;
    public static float PX_HEIGHT_PER_Z = TILE_HEIGHT_IN_PX / 3.0f; //TODO change this!
    public static float TILE_RENDER_OFFSET_Y = -2.0f * PX_HEIGHT_PER_Z;


    protected float x;
    protected float y;
    protected float z;

    protected float renderAngle = 0;

    protected float width = TILE_WIDTH_IN_PX;
    protected float height = TILE_HEIGHT_IN_PX;

    private Room currentRoom;

    private ArrayList<IEntityListener> entityListeners = new ArrayList<IEntityListener>();
    private Faction faction = Faction.NEUTRAL;

    public void gameUpdate(GameContainer gameContainer, int delta) {
        for(IEntityListener listener : entityListeners)
            listener.entityChanged();
    }

    public void render(GameContainer gameContainer, Graphics graphics, float screenX, float screenY){
	sprite.setRotation(renderAngle);
	sprite.draw(screenX + x, screenY + y );
    }

    public boolean collidesWith(Shape other){
	Shape thisBox = getHitBox();
	return thisBox.intersects(other)
		|| thisBox.contains(other)
		|| other.contains(thisBox);
    }

    public boolean collidesWith(Entity other){
	return collidesWith(other.getHitBox());
    }

    public Shape getHitBox(){
	return new Rectangle(getUniversalX(), getUniversalY(), width, height);
    }

    public boolean isHostileTo(Entity other){
	//TODO: fixa detta!
	return faction != other.getFaction() && ( faction != Faction.NEUTRAL && other.getFaction() != Faction.NEUTRAL );
    }

    public void getHit(int incoming, Entity attacker){
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

    protected float toUniversalX(float localX){
	float offset;
	if(currentRoom == null) offset = 0;
	else offset = currentRoom.getX() * (Room.ROOM_WIDTH_IN_PX + TILE_WIDTH_IN_PX);
	return localX + offset;
    }

    protected float toUniversalY(float localY){
	float offset;
	if(currentRoom == null) offset = 0;
	else offset = currentRoom.getY() * (Room.ROOM_HEIGHT_IN_PX + TILE_HEIGHT_IN_PX);
	return localY + offset;
    }

    public float getUniversalCenterX(){
	return toUniversalX(getCenterX());
    }

    public float getUniversalCenterY(){
	return toUniversalY(getCenterY());
    }

    public float getUniversalX(){
	return toUniversalX(getX());
    }

    public float getUniversalY(){
	return toUniversalY(getY());
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

    public void setCurrentRoom(Room newRoom) {
        if(this.getCurrentRoom() != null){
            this.getCurrentRoom().removeEntity(this);
	    this.getCurrentRoom().removeRoomListener(this);
	}

	if(getCurrentRoom() == null && newRoom != null) newRoom.getLevel().addActiveEntity(this);
	if(getCurrentRoom() != null && newRoom == null) getCurrentRoom().getLevel().removeActiveEntity(this);

	this.currentRoom = newRoom;

	if(newRoom != null){
	    newRoom.addEntity(this);
	    newRoom.addRoomListener(this);
	}



        for(IEntityListener entity : entityListeners)
            entity.entityChangedRoom(newRoom);
    }

    public Faction getFaction() {
	return faction;
    }

    public void setFaction(final Faction faction) {
	this.faction = faction;
    }
}
