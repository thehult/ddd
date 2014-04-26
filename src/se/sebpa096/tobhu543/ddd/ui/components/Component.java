package se.sebpa096.tobhu543.ddd.ui.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.ui.UI;

/**
 * How an UI class should look like.
 */
@SuppressWarnings({ "UnusedParameters" })
public abstract class Component {
    private float x = 0;
    private float y = 0;
    private float width = 0;
    private float height = 0;
    private float renderX = 0;
    private float renderY = 0;
    private UI parentUI = null;

    public UI getParentUI() {
        return parentUI;
    }

    //Suppress since GameContainer might be of use later on (it contains the window parameters and such)

    public abstract void render(@SuppressWarnings("UnusedParameters") GameContainer gameContainer, Graphics graphics) ;

    public void setParentUI(UI parentUI) {
        this.parentUI = parentUI;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getRenderX() {
        return renderX;
    }

    public void setRenderX(float renderX) {
        this.renderX = renderX;
    }

    public float getRenderY() {
        return renderY;
    }

    public void setRenderY(float renderY) {
        this.renderY = renderY;
    }

    public abstract void updateRenderPos();
}
