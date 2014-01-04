package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.ingame.Room;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 03/01/14 Time: 22:13 To change this template use File | Settings | File
 * Templates.
 */
public class MobileEntity extends Entity
{
    public void gameUpdate(GameContainer gameContainer, int delta) {
        if(this.getX() < -TILE_WIDTH_IN_PX) {
            this.setCurrentRoom(this.getCurrentRoom().getLeftRoom());
            this.setX(Room.ROOM_WIDTH_IN_PX);
        }
        if(this.getX() > Room.ROOM_WIDTH_IN_PX + TILE_WIDTH_IN_PX) {
            this.setCurrentRoom(this.getCurrentRoom().getRightRoom());
            this.setX(0.0f);
        }

        if(this.getY() < -TILE_HEIGHT_IN_PX) {
            this.setCurrentRoom(this.getCurrentRoom().getTopRoom());
            this.setY(Room.ROOM_HEIGHT_IN_PX);
        }
        if(this.getY() > Room.ROOM_HEIGHT_IN_PX + TILE_HEIGHT_IN_PX + 1) {
            this.setCurrentRoom(this.getCurrentRoom().getBottomRoom());
            this.setY(0.0f);
        }
        super.gameUpdate(gameContainer, delta);
    }
}
