package se.sebpa096.tobhu543.ddd.ui.listeners;

import se.sebpa096.tobhu543.ddd.ui.components.Component;

public class MouseEvent {
    public void mouseDownLeft(Component sender, int x, int y) {}
    public void mouseUpLeft(Component sender, int x, int y) {}
    public void mouseDownRight(Component sender, int x, int y) {}
    public void mouseUpRight(Component sender, int x, int y) {}
    public void mouseIn(Component sender, int x, int y) {}
    public void mouseOut(Component sender, int x, int y) {}
    public void mouseOver(Component sender, int x, int y) {}

    private boolean isMouseOver = false;
    private boolean isLeftDown = false;
    private boolean isRightDown = false;

    public final void mouseEvent(Component sender, int x, int y, boolean leftClick, boolean rightClick) {
        if(isLeftDown && !leftClick) {
            isLeftDown = false;
            this.mouseUpLeft(sender, x, y);
        }
        if(isRightDown && !rightClick) {
            isRightDown = false;
            this.mouseUpRight(sender, x, y);
        }
        if(validPosition(sender, x, y)) {
            if(leftClick) {
                this.isLeftDown = true;
                this.mouseDownLeft(sender, x, y);
            }
            else if(rightClick) {
                this.isRightDown = true;
                this.mouseDownRight(sender, x, y);
            }
            else {
                if(!isMouseOver) {
                    isMouseOver = true;
                    this.mouseIn(sender, x, y);
                }
                this.mouseOver(sender, x, y);
            }
        } else {
            if(isMouseOver) {
                isMouseOver = false;
                this.mouseOut(sender, x, y);
            }
        }
    }

    private final boolean validPosition(Component sender, int x, int y) {
        return x >= 0 && x < sender.getWidth() && y >= 0 && y < sender.getHeight();
    }
}
