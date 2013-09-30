package se.sebpa096.tobhu543.ddd;


import org.newdawn.slick.*;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.states.GameState;
import se.sebpa096.tobhu543.ddd.states.MenuState;
import se.sebpa096.tobhu543.ddd.states.State;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class Game extends BasicGame {
    public static final String GAME_NAME = "Dungeon Derring-Do's";
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

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
    private final MenuState MENU_STATE = new MenuState();
    private final GameState GAME_STATE = new GameState();

    public Game(String gameName) {
       super(gameName);

       state = MENU_STATE;
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        GlobalResources.init();
        state.init(gameContainer);

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
