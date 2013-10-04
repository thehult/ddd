package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.TileResources;

public class RoomFactory {
    public static Room makeDefaultRoom(int gridX, int gridY) {
        Room build = new Room(gridX, gridY);
        Tile[][] tiles = new Tile[Room.ROOM_WIDTH_IN_TILES][Room.ROOM_HEIGHT_IN_TILES];
        for(int x=0;x<Room.ROOM_WIDTH_IN_TILES;x++) {
            for(int y=0;y<Room.ROOM_HEIGHT_IN_TILES;y++) {
                tiles[x][y] = new Tile();
            }
        }
        build.setTiles(tiles);
        build.setWallSprite((Image)GlobalResources.getResource(GlobalResources.TILE_RESOURCES, TileResources.BRICK_WALL_1));
        return build;
    }
}
