package se.sebpa096.tobhu543.ddd.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import se.sebpa096.tobhu543.ddd.Game;
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
public class OptionsState extends State
{
    private Game game;

    private UI optionsUI;

    private static final float BACK_POSX_RAT = 1.0f/4.0f; //position of back button as a ration of screen with, from the left
    private static final float BACK_POSY_RAT = 7.0f/8.0f; // -- || --                                     height         top
    private static final float SAVE_POSX_RAT = 3.0f/4.0f; // -- || --   save
    private static final float SAVE_POSY_RAT = 7.0f/8.0f; // take a guess

    public void init(GameContainer gameContainer, Game game) {
        try {
            optionsUI = new UI(this, gameContainer);

            Label header = new Label("Options");
            optionsUI.addComponent(header);
            header.setWidth(UI.STD_COMPONENT_WIDTH);
            header.setHeight(UI.STD_COMPONENT_HEIGHT);
            header.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) / 2);
	    header.setY(UI.STD_COMPONENT_MARGIN);
            header.updateRenderPos();

            MenuButton back = new MenuButton("back");

            back.setWidth(UI.STD_COMPONENT_WIDTH);
            back.setHeight(UI.STD_COMPONENT_HEIGHT);
            back.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) * BACK_POSX_RAT);
            back.setY((gameContainer.getHeight() - UI.STD_COMPONENT_HEIGHT) * BACK_POSY_RAT);
	    final Game context = game;
	    back.setMouseListener(new ButtonMouseListener(back){
            @Override
		public void mouseUpLeft(Component sender, float x, float y, boolean stillOver){
		    super.mouseDownLeft(sender, x, y);
		    context.setState(context.MENU_STATE);
		}
	    });
            optionsUI.addComponent(back);
            optionsUI.addMouseListener(back.getMouseListener());
            back.updateRenderPos();



            MenuButton save = new MenuButton("save");
            save.setWidth(UI.STD_COMPONENT_WIDTH);
            save.setHeight(UI.STD_COMPONENT_HEIGHT);
            save.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) * SAVE_POSX_RAT);
            save.setY((gameContainer.getHeight() - UI.STD_COMPONENT_HEIGHT) * SAVE_POSY_RAT);
            save.setMouseListener(new ButtonMouseListener(save)
	    {
		@Override
		public void mouseUpLeft(Component sender, float x, float y, boolean stillOver) {
		    super.mouseDownLeft(sender, x, y);
		    //TODO: save current settings
		    System.out.println("Settings saved!");
		}
	    });
            optionsUI.addComponent(save);
            optionsUI.addMouseListener(save.getMouseListener());
            save.updateRenderPos();

	    this.backgroundImage = (Image) GlobalResources.getResource("backgroundImage", "menuBackground");


        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
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
