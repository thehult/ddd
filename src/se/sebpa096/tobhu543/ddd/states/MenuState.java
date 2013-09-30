package se.sebpa096.tobhu543.ddd.states;

import javafx.scene.image.Image;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ui.UI;
import se.sebpa096.tobhu543.ddd.ui.components.Component;
import se.sebpa096.tobhu543.ddd.ui.components.Label;
import se.sebpa096.tobhu543.ddd.ui.components.MenuButton;
import se.sebpa096.tobhu543.ddd.ui.listeners.ButtonMouseEvent;
import se.sebpa096.tobhu543.ddd.ui.listeners.MouseEvent;

public class MenuState extends State {
    private UI menuUI;

    private final int componentWidth = 250;
    private final int componentHeight = 50;
    private final int componentMargin = 10;


    @Override
    public void init(GameContainer gameContainer) {
        try {
            menuUI = new UI(this, gameContainer);

            Label header = new Label("MENU");
            header.setWidth(componentWidth);
            header.setHeight(componentHeight);
            header.setX((gameContainer.getWidth() - componentWidth) / 2);
            menuUI.addComponent(header);

            MenuButton startGame = new MenuButton("Start New Game");
            startGame.setWidth(componentWidth);
            startGame.setHeight(componentHeight);
            startGame.setX((gameContainer.getWidth() - componentWidth) / 2);
            startGame.setY(1 * (componentHeight + componentMargin));

            menuUI.addComponent(startGame);
            menuUI.addMouseListener(startGame);


            MenuButton exit = new MenuButton("Exit Game");
            exit.setWidth(componentWidth);
            exit.setHeight(componentHeight);
            exit.setX((gameContainer.getWidth() - componentWidth) / 2);
            exit.setY(2 * (componentHeight + componentMargin));
            exit.setMouseEvent(new ButtonMouseEvent(exit) {
                @Override
                public void mouseDownLeft(Component sender, int x, int y) {
                    super.mouseDownLeft(sender, x, y);
                    System.exit(0);
                }
            });
            menuUI.addComponent(exit);
            menuUI.addMouseListener(exit);

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
        graphics.drawString("MENU", 200, 200);
    }
}
