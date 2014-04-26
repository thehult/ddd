package se.sebpa096.tobhu543.ddd.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import se.sebpa096.tobhu543.ddd.states.State;
import se.sebpa096.tobhu543.ddd.ui.components.Component;
import se.sebpa096.tobhu543.ddd.ui.listeners.IMouseListener;

import java.util.ArrayList;
import java.util.List;


//No. "UI" is not too short.

/**
 * This is the main UI class. This provides an interactive UI for a state. Components can be added to this.
 */
@SuppressWarnings({ "UnusedParameters", "ClassNamingConvention" })
public class UI {

    public static final int STD_COMPONENT_MARGIN = 10;
    public static final int STD_COMPONENT_HEIGHT = 50;
    public static final int STD_COMPONENT_WIDTH = 250;

    private float x;
    private float y;
    private float width;
    private float height;
    @SuppressWarnings("UnusedDeclaration") private State parentState;

    private List<IMouseListener> mouseListeners = new ArrayList<IMouseListener>();
    private List<Component> components = new ArrayList<Component>();

    public UI(State parentState, GameContainer gameContainer) {
        this(parentState, gameContainer, 0, 0, gameContainer.getWidth(), gameContainer.getHeight());
    }

    //Suppress since GameContainer might be of use later on (it contains the window parameters and such)
    public UI(State parentState, @SuppressWarnings("UnusedParameters") GameContainer gameContainer,  float x, float y, float width, float height) {
        this.parentState = parentState;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //Suppress, delta is standard to send to an update, might be of use
    public void update(GameContainer gameContainer, @SuppressWarnings("UnusedParameters") int delta) {
        float tx = gameContainer.getInput().getMouseX();
        float ty = gameContainer.getInput().getMouseY();
        boolean leftClick = gameContainer.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON);
        boolean rightClick = gameContainer.getInput().isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON);
        for(IMouseListener object : mouseListeners)
            object.mouseEvent(tx - this.x, ty - this.y, leftClick, rightClick);
    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        for(Component component : components)
            component.render(gameContainer, graphics);
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

    @SuppressWarnings("UnusedDeclaration") public void removeComponent(Component object) {
        object.setParentUI(null);
        components.remove(object);
    }

    public float getX() {
        return x;
    }

    @SuppressWarnings("UnusedDeclaration") public void setX(float x) {
        this.x = x;
        for(Component component : components)
            component.updateRenderPos();
    }

    public float getY() {
        return y;
    }

    @SuppressWarnings("UnusedDeclaration") public void setY(float y) {
        this.y = y;
        for(Component component : components)
            component.updateRenderPos();
    }

    @SuppressWarnings("UnusedDeclaration") public float getWidth() {
        return width;
    }

    @SuppressWarnings("UnusedDeclaration") public void setWidth(float width) {
        this.width = width;
    }

    @SuppressWarnings("UnusedDeclaration") public float getHeight() {
        return height;
    }

    @SuppressWarnings("UnusedDeclaration") public void setHeight(float height) {
        this.height = height;
    }
}
