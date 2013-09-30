package se.sebpa096.tobhu543.ddd.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import se.sebpa096.tobhu543.ddd.ui.UI;
import se.sebpa096.tobhu543.ddd.ui.components.Component;
import se.sebpa096.tobhu543.ddd.ui.components.Label;
import se.sebpa096.tobhu543.ddd.ui.components.MenuButton;
import se.sebpa096.tobhu543.ddd.ui.listeners.ButtonMouseListener;

public class MenuState extends State {
    private UI menuUI;

    @Override
    public void init(GameContainer gameContainer) {
        try {
            menuUI = new UI(this, gameContainer);

            Label header = new Label("Dungeon Derring-Do's");
            menuUI.addComponent(header);
            header.setWidth(UI.STD_COMPONENT_WIDTH);
            header.setHeight(UI.STD_COMPONENT_HEIGHT);
            header.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) / 2);
            header.updateRenderPos();

            MenuButton startGame = new MenuButton("Start New Game");

            startGame.setWidth(UI.STD_COMPONENT_WIDTH);
            startGame.setHeight(UI.STD_COMPONENT_HEIGHT);
            startGame.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) / 2);
            startGame.setY(1 * (UI.STD_COMPONENT_HEIGHT + UI.STD_COMPONENT_MARGIN));
            menuUI.addComponent(startGame);
            menuUI.addMouseListener(startGame.getMouseListener());
            startGame.updateRenderPos();



            MenuButton exit = new MenuButton("Exit Game");
            exit.setWidth(UI.STD_COMPONENT_WIDTH);
            exit.setHeight(UI.STD_COMPONENT_HEIGHT);
            exit.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) / 2);
            exit.setY(2 * (UI.STD_COMPONENT_HEIGHT + UI.STD_COMPONENT_MARGIN));
            exit.setMouseListener(new ButtonMouseListener(exit) {
                @Override
                public void mouseUpLeft(Component sender, float x, float y) {
                    super.mouseDownLeft(sender, x, y);
                    System.exit(0);
                }
            });
            menuUI.addComponent(exit);
            menuUI.addMouseListener(exit.getMouseListener());
            exit.updateRenderPos();


        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        menuUI.update(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        menuUI.render(gameContainer, graphics);
    }
}
