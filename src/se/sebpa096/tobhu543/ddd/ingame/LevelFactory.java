package se.sebpa096.tobhu543.ddd.ingame;

import org.lwjgl.util.Point;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.ESword;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.EnemyOrc;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

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

	Room lRoom = RoomFactory.makeDefaultRoom(-1, 0);
        room.linkLeftRoom(lRoom);
        eorc.setCurrentRoom(lRoom);
        /*lRoom.addEntity(eorc);
        lRoom.addRoomListener(eorc);*/

	Room tRoom = RoomFactory.makeDefaultRoom(0, -1);
        room.linkTopRoom(tRoom);

	Room rRoom = RoomFactory.makeDefaultRoom(1, 0);
        room.linkRightRoom(rRoom);

	Room bRoom = RoomFactory.makeDefaultRoom(0, 1);
        room.linkBottomRoom(bRoom);

        level.setStartRoom(room);

	//level.add TODO adda alla rum som levellisteners
        return level;
    }


    public static Level makeRealLevel(int desSize) {
        Level level = new Level();
        HashMap<Point,Room> coordinates = new HashMap<Point, Room>();
        Room startRoom = RoomFactory.makeDefaultRoom(0, 0);
        level.setStartRoom(startRoom);
        coordinates.put(new Point(0, 0), startRoom);
        ArrayList<Room> roomQueue = new ArrayList<Room>();
        roomQueue.add(startRoom);
        double desiredSize = (double)desSize + 1.0;
        double currentSize = 0;
        while(!roomQueue.isEmpty()) {
            Room room = roomQueue.remove(0);
            currentSize = Math.hypot(room.getX(), room.getY());
            if(!room.hasLeftRoom()) {
                if(Math.random() < (desiredSize - currentSize) / desiredSize) {
                    if(coordinates.containsKey(new Point(room.getX() - 1, room.getY()))) {
                        room.linkLeftRoom(coordinates.get(new Point(room.getX() - 1, room.getY())));
                    } else {
                        Room lRoom = RoomFactory.makeDefaultRoom(room.getX() - 1, room.getY());
                        room.linkLeftRoom(lRoom);
                        roomQueue.add(lRoom);
                        coordinates.put(new Point(room.getX() - 1, room.getY()), lRoom);
                    }
                }
            }
            if(!room.hasTopRoom()) {
                if(Math.random() < (desiredSize - currentSize) / desiredSize) {
                    if(coordinates.containsKey(new Point(room.getX(), room.getY() - 1))) {
                        room.linkTopRoom(coordinates.get(new Point(room.getX(), room.getY() - 1)));
                    } else {

                        Room lRoom = RoomFactory.makeDefaultRoom(room.getX(), room.getY() - 1);
                        room.linkTopRoom(lRoom);
                        roomQueue.add(lRoom);
                        coordinates.put(new Point(room.getX(), room.getY() - 1), lRoom);
                    }
                }
            }
            if(!room.hasRightRoom()) {
                if(Math.random() < (desiredSize - currentSize) / desiredSize) {
                    if(coordinates.containsKey(new Point(room.getX() + 1, room.getY()))) {
                        room.linkRightRoom(coordinates.get(new Point(room.getX() + 1, room.getY())));
                    } else {
                        Room lRoom = RoomFactory.makeDefaultRoom(room.getX() + 1, room.getY());
                        room.linkRightRoom(lRoom);
                        roomQueue.add(lRoom);
                        coordinates.put(new Point(room.getX() + 1, room.getY()), lRoom);
                    }
                }
            }
            if(!room.hasBottomRoom()) {
                if(Math.random() < (desiredSize - currentSize) / desiredSize) {
                    if(coordinates.containsKey(new Point(room.getX(), room.getY() + 1))) {
                        room.linkBottomRoom(coordinates.get(new Point(room.getX(), room.getY() + 1)));
                    } else {
                        Room lRoom = RoomFactory.makeDefaultRoom(room.getX(), room.getY() + 1);
                        room.linkBottomRoom(lRoom);
                        roomQueue.add(lRoom);
                        coordinates.put(new Point(room.getX(), room.getY() + 1), lRoom);
                    }
                }
            }
        }
        return level;
    }


}
