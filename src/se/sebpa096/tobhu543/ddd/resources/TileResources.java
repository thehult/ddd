package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TileResources extends ResourceManager<Image> {
    public static final String CBBLE_FLOOR_1 = "cbblefloor1";
    public static final String BRICK_WALL_1 = "brickwall1";

    public TileResources() {
        super();
        try {
            resources.put(CBBLE_FLOOR_1, new Image("res/tiles/floor/cbblefloor1.gif"));
            resources.put(BRICK_WALL_1, new Image("res/tiles/wall/brickwall1.gif"));
        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
