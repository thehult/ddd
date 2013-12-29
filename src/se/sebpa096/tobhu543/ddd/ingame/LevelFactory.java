package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.ESword;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.EnemyOrc;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 19:38 To change this template use File | Settings | File
 * Templates.
 */
public class LevelFactory
{
    public static Level makeTestLevel(){
        Level level = new Level();

        EnemyOrc eorc = new EnemyOrc();
        eorc.getEquippedItems()[0] = new ESword();
        eorc.setX(50.0f);
        eorc.setY(100.0f);

        Room room = RoomFactory.makeSwordRoom(0, 0);
	level.addLevelListener(room);

	Room lRoom = RoomFactory.makeDefaultRoom(-1, 0);
        room.linkLeftRoom(lRoom);
        eorc.setCurrentRoom(lRoom);
        /*lRoom.addEntity(eorc);
        lRoom.addRoomListener(eorc);*/
	level.addLevelListener(lRoom);

	Room tRoom = RoomFactory.makeDefaultRoom(0, -1);
        room.linkTopRoom(tRoom);
	level.addLevelListener(tRoom);

	Room rRoom = RoomFactory.makeDefaultRoom(1, 0);
        room.linkRightRoom(rRoom);
	level.addLevelListener(rRoom);

	Room bRoom = RoomFactory.makeDefaultRoom(0, 1);
        room.linkBottomRoom(bRoom);
	level.addLevelListener(bRoom);

        level.setStartRoom(room);

	//level.add TODO adda alla rum som levellisteners
        return level;
    }

}
