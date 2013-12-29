package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.ingame.Room;

public class MovingEntity extends Entity {
    private float maxVelocity = 0.0f;
    private float velocityX = 0.0f;
    private float velocityY = 0.0f;
    private float movingDirX = 0.0f;
    private float movingDirY = 0.0f;
    public float blockX = 0.0f;
    public float blockY = 0.0f;

    public void gameUpdate(GameContainer gameContainer, int delta) {
       /* this.setX(this.getX() + this.getVelocityX() * (float)delta / 1000.0f);
        this.setY(this.getY() + this.getVelocityY() * (float)delta / 1000.0f);
        int blockGridX = (int)((this.getX() + TILE_WIDTH_IN_PX)/Tile.TILE_WIDTH_IN_PX);
        int blockGridY = (int)((this.getY() + TILE_HEIGHT_IN_PX)/Tile.TILE_HEIGHT_IN_PX);
        blockX = blockGridX;
        blockY = blockGridY;
        if(this.getX() < -TILE_WIDTH_IN_PX) {
            this.setCurrentRoom(this.getCurrentRoom().getLeftRoom());
            blockGridX = Room.ROOM_WIDTH_IN_TILES;
            this.setX(Room.ROOM_WIDTH_IN_PX);
        }
        if(this.getX() > Room.ROOM_WIDTH_IN_PX + TILE_WIDTH_IN_PX) {
            this.setCurrentRoom(this.getCurrentRoom().getRightRoom());
            blockGridX = 1;
            this.setX(0.0f);
        }
        if(this.getY() < -TILE_HEIGHT_IN_PX) {
            this.setCurrentRoom(this.getCurrentRoom().getTopRoom());
            blockGridY = Room.ROOM_HEIGHT_IN_TILES;
            this.setY(Room.ROOM_HEIGHT_IN_PX);
        }
        if(blockGridY > Room.ROOM_HEIGHT_IN_TILES + 1) {
            this.setCurrentRoom(this.getCurrentRoom().getBottomRoom());
            blockGridY = 1;
            this.setY(0.0f);
        }
        blockGridX = (blockGridX + Room.ROOM_WIDTH_IN_TILES + 2) % (Room.ROOM_WIDTH_IN_TILES + 2);
        blockGridY = (blockGridY + Room.ROOM_HEIGHT_IN_TILES + 2) % (Room.ROOM_HEIGHT_IN_TILES + 2);
        if(this.getCurrentRoom().getBlockingTile(blockGridX, blockGridY)|| this.getCurrentRoom().getBlockingTile(blockGridX, blockGridY + 1)|| this.getCurrentRoom().getBlockingTile(blockGridX + 1, blockGridY) || this.getCurrentRoom().getBlockingTile(blockGridX + 1, blockGridY + 1)) {
            this.setX(this.getX() - this.getVelocityX() * (float)delta / 1000.0f);
            this.setY(this.getY() - this.getVelocityY() * (float)delta / 1000.0f);
        }*/

        this.setX(this.getX() + this.getVelocityX() * (float)delta / 1000.0f);
        int blockGridX = (int)((this.getX() + TILE_WIDTH_IN_PX)/Tile.TILE_WIDTH_IN_PX);
        int blockGridY = (int)((this.getY() + TILE_HEIGHT_IN_PX)/Tile.TILE_HEIGHT_IN_PX);
        blockX = blockGridX;

        if(this.getX() < -TILE_WIDTH_IN_PX) {
            this.setCurrentRoom(this.getCurrentRoom().getLeftRoom());
            blockGridX = Room.ROOM_WIDTH_IN_TILES;
            this.setX(Room.ROOM_WIDTH_IN_PX);
        }
        if(this.getX() > Room.ROOM_WIDTH_IN_PX + TILE_WIDTH_IN_PX) {
            this.setCurrentRoom(this.getCurrentRoom().getRightRoom());
            blockGridX = 1;
            this.setX(0.0f);
        }

        blockGridX = (blockGridX + Room.ROOM_WIDTH_IN_TILES + 2) % (Room.ROOM_WIDTH_IN_TILES + 2);
        if(this.getCurrentRoom().getBlockingTile(blockGridX, blockGridY)|| this.getCurrentRoom().getBlockingTile(blockGridX, blockGridY + 1)|| this.getCurrentRoom().getBlockingTile(blockGridX + 1, blockGridY) || this.getCurrentRoom().getBlockingTile(blockGridX + 1, blockGridY + 1)) {
            this.setX(this.getX() - this.getVelocityX() * (float)delta / 1000.0f);
        }
        this.setY(this.getY() + this.getVelocityY() * (float)delta / 1000.0f);
        blockGridX = (int)((this.getX() + TILE_WIDTH_IN_PX)/Tile.TILE_WIDTH_IN_PX);
        blockGridY = (int)((this.getY() + TILE_HEIGHT_IN_PX)/Tile.TILE_HEIGHT_IN_PX);
        blockY = blockGridY;
        if(this.getY() < -TILE_HEIGHT_IN_PX) {
            this.setCurrentRoom(this.getCurrentRoom().getTopRoom());
            blockGridY = Room.ROOM_HEIGHT_IN_TILES;
            this.setY(Room.ROOM_HEIGHT_IN_PX);
        }
        if(blockGridY > Room.ROOM_HEIGHT_IN_TILES + 1) {
            this.setCurrentRoom(this.getCurrentRoom().getBottomRoom());
            blockGridY = 1;
            this.setY(0.0f);
        }
        blockGridX = (blockGridX + Room.ROOM_WIDTH_IN_TILES + 2) % (Room.ROOM_WIDTH_IN_TILES + 2);
        blockGridY = (blockGridY + Room.ROOM_HEIGHT_IN_TILES + 2) % (Room.ROOM_HEIGHT_IN_TILES + 2);
        if(this.getCurrentRoom().getBlockingTile(blockGridX, blockGridY)|| this.getCurrentRoom().getBlockingTile(blockGridX, blockGridY + 1)|| this.getCurrentRoom().getBlockingTile(blockGridX + 1, blockGridY) || this.getCurrentRoom().getBlockingTile(blockGridX + 1, blockGridY + 1)) {
            this.setY(this.getY() - this.getVelocityY() * (float)delta / 1000.0f);
        }
        super.gameUpdate(gameContainer, delta);
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
