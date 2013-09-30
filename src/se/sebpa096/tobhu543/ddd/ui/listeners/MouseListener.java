package se.sebpa096.tobhu543.ddd.ui.listeners;

import se.sebpa096.tobhu543.ddd.ui.components.Component;

public class MouseListener implements IMouseListener{
    public void mouseDownLeft(Component sender, float x, float y) {}
    public void mouseUpLeft(Component sender, float x, float y) {}
    public void mouseDownRight(Component sender, float x, float y) {}
    public void mouseUpRight(Component sender, float x, float y) {}
    public void mouseIn(Component sender, float x, float y) {}
    public void mouseOut(Component sender, float x, float y) {}
    public void mouseOver(Component sender, float x, float y) {}

    private boolean isMouseOver = false;
    private boolean isLeftDown = false;
    private boolean isRightDown = false;

    private Component sender;

    public MouseListener(Component sender) {
        this.sender = sender;
    }

    @Override
    public final void mouseEvent( float x, float y, boolean leftClick, boolean rightClick) {
        x = x - sender.getX();
        y = y - sender.getY();
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

    private final boolean validPosition(Component sender, float x, float y) {
        return x >= 0 && x < sender.getWidth() && y >= 0 && y < sender.getHeight();
    }
}
