package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.ingame.Room;

public class MovingEntity extends Entity {
    private float maxVelocity = 0.0f;
    private float velocityX = 0.0f;
    private float velocityY = 0.0f;
    private float movingDirX = 0.0f;
    private float movingDirY = 0.0f;

    public void update(GameContainer gameContainer, int delta) {
        this.setX(this.getX() + this.getVelocityX() * (float)delta / 1000.0f);
        this.setY(this.getY() + this.getVelocityY() * (float)delta / 1000.0f);
        int blockGridX = (int)((this.getX() + TILE_WIDTH_IN_PX)/Tile.TILE_WIDTH_IN_PX);
        int blockGridY = (int)((this.getY() + TILE_HEIGHT_IN_PX)/Tile.TILE_HEIGHT_IN_PX);
        if(blockGridX < 0)
            this.setCurrentRoom(this.getCurrentRoom().getLeftRoom());
        if(blockGridX > Room.ROOM_WIDTH_IN_TILES + 1)
            this.setCurrentRoom(this.getCurrentRoom().getRightRoom());
        if(blockGridY < 0)
            this.setCurrentRoom(this.getCurrentRoom().getTopRoom());
        if(blockGridX > Room.ROOM_HEIGHT_IN_TILES + 1)
            this.setCurrentRoom(this.getCurrentRoom().getBottomRoom());
        blockGridX = (blockGridX + Room.ROOM_WIDTH_IN_TILES + 2) % (Room.ROOM_WIDTH_IN_TILES + 2);
        blockGridY = (blockGridY + Room.ROOM_HEIGHT_IN_TILES + 2) % (Room.ROOM_HEIGHT_IN_TILES + 2);
        //System.out.println("x: " + blockGridX);
        //System.out.println("y: " + blockGridY);
        if(this.getCurrentRoom().getBlockingTile(blockGridX, blockGridY)|| this.getCurrentRoom().getBlockingTile(blockGridX, blockGridY + 1)|| this.getCurrentRoom().getBlockingTile(blockGridX + 1, blockGridY) || this.getCurrentRoom().getBlockingTile(blockGridX + 1, blockGridY + 1)) {
            float dX = Math.abs(this.getX() - (blockGridX) * TILE_WIDTH_IN_PX);
            float dY = Math.abs(this.getY() - (blockGridY) * TILE_HEIGHT_IN_PX);

            this.setX(this.getX() - movingDirX * dX);
            this.setY(this.getY() - movingDirX * dY);

        }
        super.update(gameContainer, delta);
    }

    public void setMovingDir(float dX, float dY) {
        double hypot = Math.hypot(dX, dY);
        if(hypot == 0.0)
            stopEntity();
        else {
            movingDirX = dX / (float)hypot;
            movingDirY = dY / (float)hypot;
            velocityX = maxVelocity * movingDirX;
            velocityY = maxVelocity * movingDirY;
        }
    }

    public void stopEntity() {
        velocityY = 0.0f;
        velocityX = 0.0f;
    }

    public void setMaxVelocity(float maxVelocity) {
        this.maxVelocity = maxVelocity;
    }

    public float getMaxVelocity() {
        return maxVelocity;
    }

    public float getMovingDirX() {
        return movingDirX;
    }

    public float getMovingDirY() {
        return movingDirX;
    }


    public float getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }
}
