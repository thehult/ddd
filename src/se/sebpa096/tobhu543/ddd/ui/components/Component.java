package se.sebpa096.tobhu543.ddd.ui.components;

import se.sebpa096.tobhu543.ddd.ui.UI;

public class Component {
    private int x = 0;
    private int y = 0;
    private int width = 0;
    private int height = 0;
    private UI parentUI = null;

    public Component() {
    }

    public UI getParentUI() {
        return parentUI;
    }

    public void setParentUI(UI parentUI) {
        this.parentUI = parentUI;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
