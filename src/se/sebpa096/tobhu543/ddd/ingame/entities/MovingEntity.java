package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.Room;

@SuppressWarnings("JavaDoc")
public class MovingEntity extends Entity {
    private float maxVelocity = 0.0f;
    private float velocityX = 0.0f;
    private float velocityY = 0.0f;
    private float movingDirX = 0.0f;
    private float movingDirY = 0.0f;

    public void gameUpdate(GameContainer gameContainer, int delta) {
        this.setX(this.getX() + this.velocityX * delta / Game.MILLISEC_PER_SEC);
        int blockGridX = (int)((this.getX() + TILE_WIDTH_IN_PX)/ Entity.TILE_WIDTH_IN_PX);
        int blockGridY = (int)((this.getY() + TILE_HEIGHT_IN_PX)/ Entity.TILE_HEIGHT_IN_PX);

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
        if(this.getCurrentRoom().isBlockingTile(blockGridX, blockGridY)|| this.getCurrentRoom().isBlockingTile(blockGridX,
													       blockGridY + 1)|| this.getCurrentRoom().isBlockingTile(
		blockGridX + 1, blockGridY) || this.getCurrentRoom().isBlockingTile(blockGridX + 1, blockGridY + 1)) {
            this.setX(this.getX() - this.velocityX * delta / Game.MILLISEC_PER_SEC);
        }
        this.setY(this.getY() + this.velocityY * delta / Game.MILLISEC_PER_SEC);
        blockGridX = (int)((this.getX() + TILE_WIDTH_IN_PX)/ Entity.TILE_WIDTH_IN_PX);
        blockGridY = (int)((this.getY() + TILE_HEIGHT_IN_PX)/ Entity.TILE_HEIGHT_IN_PX);

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
        if(this.getCurrentRoom().isBlockingTile(blockGridX, blockGridY)|| this.getCurrentRoom().isBlockingTile(blockGridX,
													       blockGridY + 1)|| this.getCurrentRoom().isBlockingTile(
		blockGridX + 1, blockGridY) || this.getCurrentRoom().isBlockingTile(blockGridX + 1, blockGridY + 1)) {
            this.setY(this.getY() - this.velocityY * delta / Game.MILLISEC_PER_SEC);
        }
        super.gameUpdate(gameContainer, delta);
    }

    public void setMovingDir(float dX, float dY) {
        double hypot = Math.hypot(dX, dY);
        if(hypot == 0.0)
            stopEntity();
        else {
            movingDirX = (float) (dX / hypot);
            movingDirY = (float) (dY / hypot);
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

    @SuppressWarnings("UnusedDeclaration") public float getMaxVelocity() {
        return maxVelocity;
    }

    public float getMovingDirX() {
        return movingDirX;
    }

    public float getMovingDirY() {
        return movingDirY;
    }


    public float getVelocityX() {
        return velocityX;
    }

    @SuppressWarnings("UnusedDeclaration") public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    @SuppressWarnings("UnusedDeclaration") public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }
}
