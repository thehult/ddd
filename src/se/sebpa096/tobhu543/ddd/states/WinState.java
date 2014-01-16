package se.sebpa096.tobhu543.ddd.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.resources.BackgroundResources;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.ui.UI;
import se.sebpa096.tobhu543.ddd.ui.components.Component;
import se.sebpa096.tobhu543.ddd.ui.components.Label;
import se.sebpa096.tobhu543.ddd.ui.components.MenuButton;
import se.sebpa096.tobhu543.ddd.ui.listeners.ButtonMouseListener;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-09-30 Time: 17:37 To change this template use File | Settings | File
 * Templates.
 */
public class WinState extends State
{
    private Game gameD = null;

    private UI optionsUI = null;
    private MenuButton next = null;
    private Label header = null;

    private static final float BACK_POSX_RAT = 2.0f/4.0f; //position of next button as a ration of screen with, from the left
    private static final float BACK_POSY_RAT = 7.0f/8.0f; // -- || --                                     height         top


    public void init(GameContainer gameContainer, Game game) {
        //try {
       	this.gameD = game;
            optionsUI = new UI(this, gameContainer);

            header = new Label("Level x finished!");
            optionsUI.addComponent(header);
            header.setWidth(UI.STD_COMPONENT_WIDTH);
            header.setHeight(UI.STD_COMPONENT_HEIGHT);
            header.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) / 2.0f);
	    header.setY(UI.STD_COMPONENT_MARGIN);
            header.updateRenderPos();

            next = new MenuButton("Start level x!");

            next.setWidth(UI.STD_COMPONENT_WIDTH);
            next.setHeight(UI.STD_COMPONENT_HEIGHT);
            next.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) * BACK_POSX_RAT);
            next.setY((gameContainer.getHeight() - UI.STD_COMPONENT_HEIGHT) * BACK_POSY_RAT);
	    final Game context = game;
	    next.setMouseListener(new ButtonMouseListener(next) {
            @Override
            public void mouseUpLeft(Component sender, float x, float y, boolean stillOver) {
		super.mouseUpLeft(sender, x, y, stillOver);
                mouseDownLeft(sender, x, y);
                Game.GAME_STATE.initNewLevel();
                Game.GAME_STATE.movePlayersToNewLevel();
                context.setState(Game.GAME_STATE);
            }
        });
            optionsUI.addComponent(next);
            optionsUI.addMouseListener(next.getMouseListener());
            next.updateRenderPos();

	    this.backgroundImage = (Image) GlobalResources.getResource(GlobalResources.BACKGROUND_RESOURCES, BackgroundResources.WIN_BACKGROUND);


        /*} catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }*/
    }

    public void setFinishedLevel(int finishedLevel) {
        header.setText("Level " + finishedLevel + " finished!");
        next.setLabel("Start level " + (finishedLevel + 1) + "!");
        final int fLevel = finishedLevel;
        optionsUI.removeMouseListener(next.getMouseListener());
        next.setMouseListener(new ButtonMouseListener(next) {
            @Override
            public void mouseUpLeft(Component sender, float x, float y, boolean stillOver) {
		super.mouseUpLeft(sender, x, y, stillOver);
                mouseDownLeft(sender, x, y);
                Game.GAME_STATE.setLevelNumber(fLevel + 1);
                Game.GAME_STATE.initNewLevel();
                Game.GAME_STATE.movePlayersToNewLevel();
                gameD.setState(Game.GAME_STATE);
            }
        });
        optionsUI.addMouseListener(next.getMouseListener());
    }

    @Override public void update(final GameContainer gameContainer, final int delta) {
	optionsUI.update(gameContainer, delta);
    }

    @Override public void render(final GameContainer gameContainer, final Graphics graphics) {
	if(this.backgroundImage != null)
	            this.backgroundImage.draw(0.0f, 0.0f, gameContainer.getWidth(), gameContainer.getHeight());
    	optionsUI.render(gameContainer, graphics);
    }
}
