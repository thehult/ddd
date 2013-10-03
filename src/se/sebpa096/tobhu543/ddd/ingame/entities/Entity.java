package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 20:52 To change this template use File | Settings | File
 * Templates.
 */
public abstract class Entity
{
    protected Image sprite;

    float x;
    float y;
    float z;

    float renderX;
    float renderY;

    public abstract void update(GameContainer gameContainer, int delta);
    public void render(GameContainer gameContainer, Graphics graphics){
	sprite.draw(x, y);
    }

    public Entity(){
	x = 0;
	y = 0;
	z = 0;
	renderX = 0;
	renderY = 0;
    }

    public Entity(float inX, float inY, float inZ){
	x = inX;
	y = inY;
	z = inZ;
	renderX = x; //use some sort of camera offset
	renderY = y;
    }

    public Entity(float inX, float inY, float inZ, Image inSprite){
	this(inX, inY, inZ);
	sprite = inSprite;
    }


}
