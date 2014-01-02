package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.DFireSword;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.DSword;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.TileResources;

public class RoomFactory {
    public static Room makeDefaultRoom(int gridX, int gridY, Level level) {
        Room build = new Room(gridX, gridY, level);
        Tile[][] tiles = new Tile[Room.ROOM_WIDTH_IN_TILES][Room.ROOM_HEIGHT_IN_TILES];
        for(int x=0;x<Room.ROOM_WIDTH_IN_TILES;x++) {
            for(int y=0;y<Room.ROOM_HEIGHT_IN_TILES;y++) {
                tiles[x][y] = new Tile();
            }
        }
        build.setTiles(tiles);
        build.setWallSpriteTop((Image)GlobalResources.getResource(GlobalResources.TILE_RESOURCES, TileResources.BRICK_WALL_1_TOP));
        build.setWallSpriteBot((Image)GlobalResources.getResource(GlobalResources.TILE_RESOURCES, TileResources.BRICK_WALL_1_BOT));
        build.setWallSpriteLeft((Image)GlobalResources.getResource(GlobalResources.TILE_RESOURCES, TileResources.BRICK_WALL_1_LEFT));
        build.setWallSpriteRight((Image)GlobalResources.getResource(GlobalResources.TILE_RESOURCES, TileResources.BRICK_WALL_1_RIGHT));
        return build;
    }

    public static Room makeSwordRoom(int gridX, int gridY, Level level){
        Room build = makeDefaultRoom(gridX, gridY, level);

        DSword sword = new DSword();
        sword.setX(300);
        sword.setY(300);
        sword.putOnMap(build);

        DFireSword fireSword = new DFireSword();
        fireSword.setX(100);
        fireSword.setY(300);
        fireSword.putOnMap(build);

        return build;
    }

}
