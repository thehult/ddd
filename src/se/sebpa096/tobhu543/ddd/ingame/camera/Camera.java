package se.sebpa096.tobhu543.ddd.ingame.camera;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.ingame.Room;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.IEntityListener;

public class Camera implements IEntityListener {
    protected float x;
    protected float y;
    private Entity followEntity = null;
    private Room renderRoom = null;

    public Camera() {
        this.y = 0;
        this.x = 0;
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

    public void lockRoom(Room room) {
        this.setX(Room.ROOM_WIDTH_IN_PX / 2);
        this.setY(Room.ROOM_HEIGHT_IN_PX / 2);
        if(followEntity != null) {
            this.followEntity.removeEntityListener(this);
            this.followEntity = null;
        }
    }

    public void setFollowEntity(Entity entity) {
        this.followEntity = entity;
        followEntity.addEntityListener(this);
    }

    public Entity getFollowEntity() {
        return followEntity;
    }

    @Override
    public void entityChanged() {
        if(followEntity != null) {
            this.setX(followEntity.getCenterX());
            this.setY(followEntity.getCenterY());
        }
    }

    @Override
    public void entityChangedRoom(Room room) {
        renderRoom = room;
    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        renderRoom.render(gameContainer, graphics, this);
    }
}
