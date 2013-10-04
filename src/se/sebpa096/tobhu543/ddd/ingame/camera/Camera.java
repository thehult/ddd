package se.sebpa096.tobhu543.ddd.ingame.camera;

import se.sebpa096.tobhu543.ddd.Game;

public class Camera {
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float zoom;

    public Camera() {
        width = Game.WINDOW_WIDTH;
        height = Game.WINDOW_HEIGHT;
        zoom = 1.0f;
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

    public float getHeight() {
        return height;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }
}
