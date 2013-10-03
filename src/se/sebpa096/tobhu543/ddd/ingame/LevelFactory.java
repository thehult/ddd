package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.Room;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 19:38 To change this template use File | Settings | File
 * Templates.
 */
public class LevelFactory
{
    public static Level makeTestLevel(){
	Level level = new Level();
	Room room = new Room(1, 1, (Image)GlobalResources.getResource("buttonImage", "defaultStandard"));
	level.addRoom(room);
	return level;
    }
}
