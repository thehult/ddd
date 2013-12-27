package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.ingame.camera.Camera;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 18:56 To change this template use File | Settings | File
 * Templates.
 */
public class Level implements IUpdateListener
{
    private Room startRoom;
    private ArrayList<Room> levelListeners = new ArrayList<Room>();

    public Level(){
    }

    public void render(GameContainer gameContainer, Graphics graphics, Camera camera){
        startRoom.render(gameContainer, graphics, camera);
    }


    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

    @Override
    public void gameUpdate(GameContainer gameContainer, int delta) {
        for(Room r: levelListeners){
            r.update(gameContainer, delta);
        }
    }

}
