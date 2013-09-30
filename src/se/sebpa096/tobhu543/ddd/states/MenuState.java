package se.sebpa096.tobhu543.ddd.states;

import javafx.scene.image.Image;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ui.UI;
import se.sebpa096.tobhu543.ddd.ui.components.Label;

public class MenuState extends State {
    private UI menuUI;

    @Override
    public void init(GameContainer gameContainer) {
        menuUI = new UI(this, gameContainer);

        Label header = new Label("MENU");
        menuUI.addComponent(header);


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
