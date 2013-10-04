package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 20:52 To change this template use File | Settings | File
 * Templates.
 */
public class Entity
{
    protected Image sprite;


    public static float TILE_WIDTH_IN_PX = 72.0f;
    public static float TILE_HEIGHT_IN_PX = 72.0f;
    public static float PX_HEIGHT_PER_Z = TILE_HEIGHT_IN_PX / 3.0f; //TODO change this!
    public static float TILE_RENDER_OFFSET_Y = -2.0f * PX_HEIGHT_PER_Z;

    protected float x;
    protected float y;
    protected float z;

    public void update(GameContainer gameContainer, int delta) {

    }

    public void render(GameContainer gameContainer, Graphics graphics){
	    sprite.draw(x, y);
    }

    public Entity(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Entity(float inX, float inY, float inZ){
        x = inX;
        y = inY;
        z = inZ;
    }

    public Entity(float inX, float inY, float inZ, Image inSprite){
        this(inX, inY, inZ);
        sprite = inSprite;
    }


}
