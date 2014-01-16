package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

@SuppressWarnings("JavaDoc")
public class TileResources extends ResourceManager<Image> {
    public static final String CBBLE_FLOOR_1 = "cbblefloor1";
    public static final String BRICK_WALL_1_TOP = "brickwall1_top";
    public static final String BRICK_WALL_1_BOT = "brickwall1_bot";
    public static final String BRICK_WALL_1_LEFT = "brickwall1_left";
    public static final String BRICK_WALL_1_RIGHT = "brickwall1_right";
    public static final String STAIRS_START = "stairsStart";
    public static final String STAIRS_GOAL = "stairsGoal";

    public TileResources() {
	try {
            resources.put(CBBLE_FLOOR_1, new Image("res/tiles/floor/cbblefloor1.gif"));
            resources.put(BRICK_WALL_1_TOP, new Image("res/tiles/wall/brickwall1_top.gif"));
            resources.put(BRICK_WALL_1_BOT, new Image("res/tiles/wall/brickwall1_bot.gif"));
            resources.put(BRICK_WALL_1_LEFT, new Image("res/tiles/wall/brickwall1_left.gif"));
            resources.put(BRICK_WALL_1_RIGHT, new Image("res/tiles/wall/brickwall1_right.gif"));
            resources.put(STAIRS_START, new Image("res/tiles/stairs/staircase_start.png"));
            resources.put(STAIRS_GOAL, new Image("res/tiles/stairs/staircase_goal.png"));
        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
