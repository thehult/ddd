package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 19:38 To change this template use File | Settings | File
 * Templates.
 */
public class LevelFactory
{
    public static Level makeTestLevel(){
        Level level = new Level();
        Room room = RoomFactory.makeDefaultRoom(0, 0);
        room.setLeftRoom(RoomFactory.makeDefaultRoom(-1, 0));
        room.setTopRoom(RoomFactory.makeDefaultRoom(0, -1));
        room.setRightRoom(RoomFactory.makeDefaultRoom(1, 0));
        room.setBottomRoom(RoomFactory.makeDefaultRoom(0, 1));
        level.setStartRoom(room);
        return level;
    }

}
