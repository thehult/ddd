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
 * The state when the Player is in the menu.
 */
public class MenuState extends State {
    private UI menuUI = null;
    private static final int TOP_MARGIN = 100;

    @Override
    public void init(GameContainer gameContainer, Game game) {
        //try {
                menuUI = new UI(this, gameContainer);

            final Game context = game;

            Label header = new Label("Dungeon Derring-Do's");
            menuUI.addComponent(header);
            header.setWidth(UI.STD_COMPONENT_WIDTH);
            header.setHeight(UI.STD_COMPONENT_HEIGHT);
            header.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) / 2.0f);
            header.setY(TOP_MARGIN);
            header.updateRenderPos();

            MenuButton startGame = new MenuButton("Start New Game");
            startGame.setWidth(UI.STD_COMPONENT_WIDTH);
            startGame.setHeight(UI.STD_COMPONENT_HEIGHT);
            startGame.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) / 2.0f);
            startGame.setY((UI.STD_COMPONENT_HEIGHT + UI.STD_COMPONENT_MARGIN) + TOP_MARGIN);
            final GameContainer gameContainerContext = gameContainer;
            startGame.setMouseListener(new ButtonMouseListener(startGame){
                @Override
                public void mouseUpLeft(final Component sender, final float x, final float y, final boolean stillOver) {
                    super.mouseUpLeft(sender, x, y,
                              stillOver);
                    if(stillOver) {
                        Game.GAME_STATE.setLevelNumber(1);
                        context.setAndInitState(Game.GAME_STATE, gameContainerContext);
                    }
                }
                });
            menuUI.addComponent(startGame);
            menuUI.addMouseListener(startGame.getMouseListener());
            startGame.updateRenderPos();

            MenuButton options = new MenuButton("Options");
            options.setWidth(UI.STD_COMPONENT_WIDTH);
            options.setHeight(UI.STD_COMPONENT_HEIGHT);
            options.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) / 2.0f);
            options.setY(2 * (UI.STD_COMPONENT_HEIGHT + UI.STD_COMPONENT_MARGIN)  + TOP_MARGIN);
            options.setMouseListener(new ButtonMouseListener(options){
            @Override
                public void mouseUpLeft(Component sender, float x, float y, boolean stillOver){
                super.mouseUpLeft(sender, x, y, stillOver);
                if(stillOver)
                context.setState(Game.OPTIONS_STATE);
            }
            });
            menuUI.addComponent(options);
            menuUI.addMouseListener(options.getMouseListener());
            options.updateRenderPos();



            MenuButton exit = new MenuButton("Exit Game");
            exit.setWidth(UI.STD_COMPONENT_WIDTH);
            exit.setHeight(UI.STD_COMPONENT_HEIGHT);
            exit.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) / 2.0f);
            exit.setY(3 * (UI.STD_COMPONENT_HEIGHT + UI.STD_COMPONENT_MARGIN)  + TOP_MARGIN);
            exit.setMouseListener(new ButtonMouseListener(exit) {
                @Override
                public void mouseUpLeft(Component sender, float x, float y, boolean stillOver) {
                    super.mouseUpLeft(sender, x, y, stillOver);
                    if(stillOver)
                        System.exit(0);
                }
            });
            menuUI.addComponent(exit);
            menuUI.addMouseListener(exit.getMouseListener());
            exit.updateRenderPos();

            this.backgroundImage = (Image)GlobalResources.getResource(GlobalResources.BACKGROUND_RESOURCES, BackgroundResources.MENU_BACKGROUND);

        /*} catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }*/
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        menuUI.update(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        if(this.backgroundImage != null)
            this.backgroundImage.draw(0.0f, 0.0f, gameContainer.getWidth(), gameContainer.getHeight());
        menuUI.render(gameContainer, graphics);
    }
}
