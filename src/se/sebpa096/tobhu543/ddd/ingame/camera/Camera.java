package se.sebpa096.tobhu543.ddd.ingame.camera;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.Tester;
import se.sebpa096.tobhu543.ddd.ingame.Room;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.IEntityListener;

public class Camera implements IEntityListener {
    protected float x;
    protected float y;
    private Entity followEntity = null;
    private Room renderRoom = null;
    private GameContainer gameContainer;

    public Camera(GameContainer gameContainer) {
        this.y = 0;
        this.x = 0;
        this.gameContainer = gameContainer;
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
            if(Game.TEST) {
                this.setX(this.getX() - Room.ROOM_WIDTH_IN_PX * 0.5f / Tester.testScale);
                this.setY(this.getY() - Room.ROOM_HEIGHT_IN_PX * 0.5f / Tester.testScale);
            }
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
    }
}
