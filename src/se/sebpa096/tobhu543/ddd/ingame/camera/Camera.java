package se.sebpa096.tobhu543.ddd.ingame.camera;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.Tester;
import se.sebpa096.tobhu543.ddd.ingame.Room;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.IEntityListener;

/**
 * The basic Camera class, which has code and variables to help out with rendering of different types.
 */
public class Camera implements IEntityListener {
    public final static float SHAKE_RESET_SPEED = 0.2f;

    protected float x;
    protected float y;
    protected float shakeOffset = 0;
    private Entity followEntity = null;
    private Room renderRoom = null;

    //Might want to use it later
    @SuppressWarnings("UnusedParameters") public Camera(GameContainer gameContainer) {
        this.y = 0;
        this.x = 0;
    }

    public void shake(float power){
	if(shakeOffset < 0) shakeOffset -= power;
	else shakeOffset += power;
    }

    public float getX() {
        return x + shakeOffset;
    }

    public void setX(float x) {
        this.x = x;
        //this.x = x - shakeOffset;
    }

    public float getY() {
        return y + shakeOffset;
    }

    public void setY(float y) {
	this.y = y;
        //this.y = y - shakeOffset;
    }

    //Method not finished yet, therefore suppress!
    @SuppressWarnings({ "UnusedDeclaration", "CallToSimpleSetterFromWithinClass" }) public void lockRoom(Room room) {
        this.setX(Room.ROOM_WIDTH_IN_PX / 2);
        this.setY(Room.ROOM_HEIGHT_IN_PX / 2);
	renderRoom = room;
        if(followEntity != null) {
            this.followEntity.removeEntityListener(this);
            this.followEntity = null;
        }
    }

    public void setFollowEntity(Entity entity) {
        this.followEntity = entity;
        followEntity.addEntityListener(this);
    }

    @SuppressWarnings("UnusedDeclaration") public Entity getFollowEntity() {
        return followEntity;
    }

    @Override
    public void entityChanged() {
        if(followEntity != null) {

	    //Suppress: we want to use setX/Y since there may be alterations to x/y within the setters. Not at the moment... but later on!

	    //noinspection CallToSimpleSetterFromWithinClass
	    this.setX(followEntity.getCenterX());
	    //noinspection CallToSimpleSetterFromWithinClass
	    this.setY(followEntity.getCenterY());
            /*if(Game.TEST) {
                this.setX(this.getX() - Room.ROOM_WIDTH_IN_PX * 0.5f / Tester.testScale);
                this.setY(this.getY() - Room.ROOM_HEIGHT_IN_PX * 0.5f / Tester.testScale);
            }*/
        }
    }

    @Override
    public void entityChangedRoom(Room room) {
        renderRoom = room;
    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        if(Game.TEST)
            Tester.renderedRooms.clear();
        renderRoom.render(gameContainer, graphics, this);

	//TODO test: se över detta. borde vara i update?
	/*if(shakeOffset > SHAKE_RESET_SPEED)
	    shakeOffset = -(shakeOffset - SHAKE_RESET_SPEED);
	else if(shakeOffset < -SHAKE_RESET_SPEED)
	    shakeOffset = -(shakeOffset + SHAKE_RESET_SPEED);
	else
	    shakeOffset = 0;*/
	shakeOffset = -shakeOffset * (1-SHAKE_RESET_SPEED);
	if(Math.abs(shakeOffset) < SHAKE_RESET_SPEED)
	    shakeOffset = 0;
    }
}
