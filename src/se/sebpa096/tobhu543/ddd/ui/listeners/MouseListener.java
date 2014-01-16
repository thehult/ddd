package se.sebpa096.tobhu543.ddd.ui.listeners;

import se.sebpa096.tobhu543.ddd.ui.components.Component;

//Suppress unused parameters, they can all be necessary in the future
//Suppress parameters hides... can't find which parameter that gets hidden

@SuppressWarnings({ "UnusedParameters", "JavaDoc", "ParameterHidesMemberVariable" })
public abstract class MouseListener implements IMouseListener{

    //The EmptyMethod suppress is because we do not use these callbacks yet.

    public abstract void mouseDownLeft(Component sender, float x, float y);
    public abstract void mouseUpLeft(Component sender, float x, float y, boolean stillOver);
    @SuppressWarnings("EmptyMethod") public abstract void mouseDownRight(Component sender, float x, float y);
    @SuppressWarnings("EmptyMethod") public abstract void mouseUpRight(Component sender, float x, float y, boolean stillOver);
    public abstract void mouseIn(Component sender, float x, float y);
    public abstract void mouseOut(Component sender, float x, float y);
    @SuppressWarnings("EmptyMethod") public abstract void mouseOver(Component sender, float x, float y);

    private boolean isMouseOver = false;
    private boolean isLeftDown = false;
    private boolean isRightDown = false;

    private Component sender;

    protected MouseListener(Component sender) {
        this.sender = sender;
    }

    @Override
    public final void mouseEvent( float x, float y, boolean leftClick, boolean rightClick) {
	x -= sender.getX();
	y -= sender.getY();
        if(isLeftDown && !leftClick) {
            isLeftDown = false;
            this.mouseUpLeft(sender, x, y, isValidPosition(sender, x, y));
        }
        if(isRightDown && !rightClick) {
            isRightDown = false;
            this.mouseUpRight(sender, x, y, isValidPosition(sender, x, y));
        }
        if(isValidPosition(sender, x, y)) {
            if(leftClick && !this.isLeftDown) {
                this.isLeftDown = true;
                this.mouseDownLeft(sender, x, y);
            }
            else if(rightClick && !this.isRightDown) {
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

    private boolean isValidPosition(Component sender, float x, float y) {
        return x >= 0 && x < sender.getWidth() && y >= 0 && y < sender.getHeight();
    }
}
