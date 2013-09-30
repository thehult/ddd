package se.sebpa096.tobhu543.ddd.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
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
    private UI optionsUI;

    private static final float BACK_POSX_RAT = 1.0f/4.0f; //position of back button as a ration of screen with, from the left
    private static final float BACK_POSY_RAT = 1.0f/8.0f; // -- || --                                     height         top
    private static final float SAVE_POSX_RAT = 3.0f/4.0f; // -- || --   save
    private static final float SAVE_POSY_RAT = 1.0f/8.0f; // take a guess

    public void init(GameContainer gameContainer) {
        try {
            optionsUI = new UI(this, gameContainer);

            Label header = new Label("Dungeon Derring-Do's");
            optionsUI.addComponent(header);
            //header.setWidth(componentWidth);
            //header.setHeight(componentHeight);
            header.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) / 2);
            header.updateRenderPos();

            MenuButton back = new MenuButton("back");

            back.setWidth(UI.STD_COMPONENT_WIDTH);
            back.setHeight(UI.STD_COMPONENT_HEIGHT);
            back.setX((gameContainer.getWidth() - UI.STD_COMPONENT_WIDTH) * BACK_POSX_RAT);
            back.setY((gameContainer.getHeight() - UI.STD_COMPONENT_HEIGHT) * BACK_POSY_RAT);
	    back.setMouseListener(new ButtonMouseListener(back){
		@Override
		public void mouseUpLeft(Component sender, float x, float y){
		    super.mouseDownLeft(sender, x, y);
		    //TODO: change state to menu!
		    System.out.println("Changes state to menu!");
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
		public void mouseUpLeft(Component sender, float x, float y) {
		    super.mouseDownLeft(sender, x, y);
		    //TODO: save current settings
		    System.out.println("Settings saved!");
		}
	    });
            optionsUI.addComponent(save);
            optionsUI.addMouseListener(save.getMouseListener());
            save.updateRenderPos();


        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override public void update(final GameContainer gameContainer, final int delta) {
	optionsUI.update(gameContainer, delta);
    }

    @Override public void render(final GameContainer gameContainer, final Graphics graphics) {
	optionsUI.render(gameContainer, graphics);
    }
}
