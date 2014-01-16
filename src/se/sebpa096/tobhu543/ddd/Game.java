package se.sebpa096.tobhu543.ddd;


import org.newdawn.slick.*;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.states.*;

import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

//ClassName... unlucky mistake from our side to name it Game. Tried renaming it to DDDGame, but the references and parameters got all messed up, since they didn't change with it, and though Game was the superclass. Leaving it as "Game" for now.
@SuppressWarnings({ "JavaDoc", "ClassNameSameAsAncestorName" })
public class Game extends BasicGame {
    public static final String GAME_NAME = "Dungeon Derring-Do's";
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final float MILLISEC_PER_SEC = 1000.0f;

    public static final boolean TEST = false;

    @SuppressWarnings("UnusedDeclaration") public static void main(String[] args) {
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

    private State state = null;
    @SuppressWarnings("UnusedDeclaration")
    private static boolean started = false;
    public static final MenuState MENU_STATE = new MenuState();
    public static final GameState GAME_STATE = new GameState();
    public static final OptionsState OPTIONS_STATE = new OptionsState();
    public static final GameOverState GAMEOVER_STATE = new GameOverState();
    public static final WinState WIN_STATE = new WinState();

    private Game(String gameName) {
        super(gameName);

    }

    public static void setStarted(boolean started) {
	Game.started = started;
    }

    //Might be of use
    @SuppressWarnings("UnusedDeclaration") public static boolean isStarted() {
	return started;
    }

    private void initMenuStates(GameContainer gameContainer){
        MENU_STATE.init(gameContainer, this);
        OPTIONS_STATE.init(gameContainer, this);
        GAMEOVER_STATE.init(gameContainer, this);
        WIN_STATE.init(gameContainer, this);
    }

    public void setState(State state){
	    this.state = state;
    }

    public void setAndInitState(State state, GameContainer gameContainer){
        state.init(gameContainer, this); //TODO maybe fix a better solution. private pointer to gameContainer?
	this.state = state;
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        GlobalResources.init();
        initMenuStates(gameContainer);
	state = MENU_STATE;

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
