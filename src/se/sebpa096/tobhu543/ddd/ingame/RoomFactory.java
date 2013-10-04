package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.TileResources;

public class RoomFactory {
    public static Room makeDefaultRoom(int gridX, int gridY) {
        Room build = new Room(gridX, gridY);
        build.setTiles(new Tile[][]{
                {new Tile(), new Tile(), new Tile(), new Tile(),new Tile(), new Tile(),new Tile(), new Tile()},
                {new Tile(), new Tile(), new Tile(), new Tile(),new Tile(), new Tile(),new Tile(), new Tile()},
                {new Tile(), new Tile(), new Tile(), new Tile(),new Tile(), new Tile(),new Tile(), new Tile()},
                {new Tile(), new Tile(), new Tile(), new Tile(),new Tile(), new Tile(),new Tile(), new Tile()},
                {new Tile(), new Tile(), new Tile(), new Tile(),new Tile(), new Tile(),new Tile(), new Tile()},
                {new Tile(), new Tile(), new Tile(), new Tile(),new Tile(), new Tile(),new Tile(), new Tile()},
                {new Tile(), new Tile(), new Tile(), new Tile(),new Tile(), new Tile(),new Tile(), new Tile()},
                {new Tile(), new Tile(), new Tile(), new Tile(),new Tile(), new Tile(),new Tile(), new Tile()}
        });
        build.setWallSprite((Image)GlobalResources.getResource(GlobalResources.TILE_RESOURCES, TileResources.BRICK_WALL_1));
        return build;
    }
}
