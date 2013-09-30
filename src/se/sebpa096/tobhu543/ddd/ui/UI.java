package se.sebpa096.tobhu543.ddd.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import se.sebpa096.tobhu543.ddd.states.State;
import se.sebpa096.tobhu543.ddd.ui.components.Component;
import se.sebpa096.tobhu543.ddd.ui.listeners.IMouseListener;

import java.util.ArrayList;
import java.util.List;

public class UI {
    private int x;
    private int y;
    private int width;
    private int height;
    private State parentState;

    private List<IMouseListener> mouseListeners = new ArrayList<IMouseListener>();
    private List<Component> components = new ArrayList<Component>();

    public UI(State parentState, GameContainer gameContainer) {
        this(parentState, gameContainer, 0, 0, gameContainer.getWidth(), gameContainer.getHeight());
    }

    public UI(State parentState, GameContainer gameContainer,  int x, int y, int width, int height) {
        this.parentState = parentState;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(GameContainer gameContainer, int delta) {
        int x = gameContainer.getInput().getMouseX();
        int y = gameContainer.getInput().getMouseY();
        boolean leftClick = gameContainer.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON);
        boolean rightClick = gameContainer.getInput().isMousePressed(Input.MOUSE_RIGHT_BUTTON);
        for(IMouseListener object : mouseListeners)
            object.mouseEvent(x - this.x, y - this.y, leftClick, rightClick);
    }

    private boolean withinBounds(int x, int y) {
        return x < this.x + this.width && x >= this.x && y < this.y + this.height && y >= this.y;
    }

    public void addMouseListener(IMouseListener object) {
        mouseListeners.add(object);
    }

    public void removeMouseListener(IMouseListener object) {
        mouseListeners.remove(object);
    }

    public void addComponent(Component object) {
        object.setParentUI(this);
        components.add(object);
    }

    public void removeComponent(Component object) {
        object.setParentUI(null);
        components.remove(object);
    }

}
