package se.sebpa096.tobhu543.ddd;


import org.newdawn.slick.*;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.states.GameState;
import se.sebpa096.tobhu543.ddd.states.MenuState;
import se.sebpa096.tobhu543.ddd.states.OptionsState;
import se.sebpa096.tobhu543.ddd.states.State;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glEnable;

public class Game extends BasicGame {
    public static final String GAME_NAME = "Dungeon Derring-Do's";
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    public static boolean TEST = false;

    public static void main(String[] args) {
        try {
            AppGameContainer appGC;
            appGC = new AppGameContainer(new Game(GAME_NAME));
            appGC.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, false);
            appGC.start();
        } catch (SlickException e) {
            Logger.getLogger(Game.class.getName()).log(SEVERE, null, e);
        }
    }

    // CLASS IMPLEMENTATION BELOW

    private State state;
    public static boolean STARTED = false;
    public static final MenuState MENU_STATE = new MenuState();
    public static final GameState GAME_STATE = new GameState();
    public static final OptionsState OPTIONS_STATE = new OptionsState();

    private Game(String gameName) {
        super(gameName);

    }

    private void initMenuStates(GameContainer gameContainer){
        MENU_STATE.init(gameContainer, this);
        OPTIONS_STATE.init(gameContainer, this);
    }

    public void setState(State state){
	    this.state = state;
    }

    public void setAndInitState(State state, GameContainer gameContainer){
        state.init(gameContainer, this); //TODO maybe fix a better solution. private pointer to gameContainer?
        setState(state);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        GlobalResources.init();
        initMenuStates(gameContainer);
        setState(MENU_STATE);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        state.update(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        state.render(gameContainer, graphics);
    }
}
