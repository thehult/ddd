package se.sebpa096.tobhu543.ddd.ingame;

import org.lwjgl.util.Point;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.StairsGoal;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.ESword;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemyLeBoss;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemyOrc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The static LevelFactory creates different type of levels. The two types of levels used in-game are RealLevel and BossLevel.
 */
public final class LevelFactory
{
    private LevelFactory() {}

    @SuppressWarnings("UnusedDeclaration") public static Level makeTestLevel(){
        Level level = new Level();

        EnemyOrc eorc = new EnemyOrc();
        eorc.getEquippedItems()[0] = new ESword();
        eorc.setX(50.0f);
        eorc.setY(100.0f);

        Room room = RoomFactory.makeSwordRoom(0, 0, level);

	Room lRoom = RoomFactory.makeDefaultRoom(-1, 0, level);
        room.linkLeftRoom(lRoom);
        eorc.setCurrentRoom(lRoom);
        /*lRoom.addEntity(eorc);
        lRoom.addRoomListener(eorc);*/

	Room tRoom = RoomFactory.makeDefaultRoom(0, -1, level);
        room.linkTopRoom(tRoom);

	Room rRoom = RoomFactory.makeDefaultRoom(1, 0, level);
        room.linkRightRoom(rRoom);

	Room bRoom = RoomFactory.makeDefaultRoom(0, 1, level);
        room.linkBottomRoom(bRoom);

        level.setStartRoom(room);

	//level.add TODO adda alla rum som levellisteners
        return level;
    }

	//I looked for a way to split it up when inspector told me it was too long. Can't seem to find any good way though, that makes it more than a couple of rows shorter.
    @SuppressWarnings("OverlyLongMethod") public static Level makeRealLevel(int desSize, float enemyDensity) {
        Level level = new Level();
        HashMap<Point,Room> coordinates = new HashMap<Point, Room>();
        Room startRoom = RoomFactory.makeStartRoom(0, 0, level);
        level.setStartRoom(startRoom);
        coordinates.put(new Point(0, 0), startRoom);
        ArrayList<Room> roomQueue = new ArrayList<Room>();
        roomQueue.add(startRoom);
        double desiredSize = desSize + 1.0;
	Room lastRoom = null;
        while(!roomQueue.isEmpty()) {
            Room room = roomQueue.remove(0);
            lastRoom = room;
	    double currentSize = Math.hypot(room.getX(), room.getY());
	    if(!room.hasLeftRoom()) {
                if(Math.random() < (desiredSize - currentSize) / desiredSize) {
                    if(coordinates.containsKey(new Point(room.getX() - 1, room.getY()))) {
                        room.linkLeftRoom(coordinates.get(new Point(room.getX() - 1, room.getY())));
                    } else {
                        Room lRoom = RoomFactory.makeThreatRoom(room.getX() - 1, room.getY(), level, enemyDensity);
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

                        Room lRoom = RoomFactory.makeThreatRoom(room.getX(), room.getY() - 1, level, enemyDensity);
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
                        Room lRoom = RoomFactory.makeThreatRoom(room.getX() + 1, room.getY(), level, enemyDensity);
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
                        Room lRoom = RoomFactory.makeThreatRoom(room.getX(), room.getY() + 1, level, enemyDensity);
                        room.linkBottomRoom(lRoom);
                        roomQueue.add(lRoom);
                        coordinates.put(new Point(room.getX(), room.getY() + 1), lRoom);
                    }
                }
            }
        }
        StairsGoal stairs = new StairsGoal();
        stairs.setX(Entity.TILE_WIDTH_IN_PX * (Room.ROOM_WIDTH_IN_TILES/2.0f));
        stairs.setY(Entity.TILE_HEIGHT_IN_PX * (Room.ROOM_HEIGHT_IN_TILES/2.0f - 1));
        stairs.setCurrentRoom(lastRoom);
        return level;
    }

    public static Level makeBossLevel() {
        Level level = new Level();
        Room startRoom = RoomFactory.makeStartRoom(0, 0, level);
        level.setStartRoom(startRoom);

        Room aRoom = RoomFactory.makeDefaultRoom(0, -1, level);
        startRoom.linkTopRoom(aRoom);

        Room bRoom = RoomFactory.makeDefaultRoom(0, -2, level);
        aRoom.linkTopRoom(bRoom);

        Room cRoom = RoomFactory.makeDefaultRoom(0, -3, level);
        bRoom.linkTopRoom(cRoom);

        Room dRoom = RoomFactory.makeDefaultRoom(0, -4, level);
        cRoom.linkTopRoom(dRoom);

        Room eRoom = RoomFactory.makeDefaultRoom(0, -5, level);
        dRoom.linkTopRoom(eRoom);

        StairsGoal stairs = new StairsGoal();
        stairs.setX(Entity.TILE_WIDTH_IN_PX * (Room.ROOM_WIDTH_IN_TILES/2.0f));
        stairs.setY(Entity.TILE_HEIGHT_IN_PX * (Room.ROOM_HEIGHT_IN_TILES/2.0f - 1));
        stairs.setCurrentRoom(eRoom);

        EnemyLeBoss eorc = new EnemyLeBoss();
        eorc.setX(Room.ROOM_WIDTH_IN_PX / 2.0f);
        eorc.setY(Room.ROOM_HEIGHT_IN_PX / 2.0f);
        eorc.setCurrentRoom(dRoom);

        return level;
    }


}
