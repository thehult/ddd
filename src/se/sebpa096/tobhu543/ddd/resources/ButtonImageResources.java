package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Resources.
 */
public class ButtonImageResources extends ResourceManager<Image> {
    public static final String DEFAULT_STANDARD = "defaultStandard";
    public static final String DEFAULT_HOVER = "defaultHover";
    public static final String DEFAULT_CLICKED = "defaultClicked";
    public static final String MENU_STANDARD = "menuStandard";
    public static final String MENU_HOVER = "menuHover";
    public static final String MENU_CLICKED = "menuClicked";

    public ButtonImageResources() {
	try {
            resources.put(DEFAULT_STANDARD, new Image("res/buttons/default/standard.gif"));
            resources.put(DEFAULT_HOVER, new Image("res/buttons/default/hover.gif"));
            resources.put(DEFAULT_CLICKED, new Image("res/buttons/default/clicked.gif"));
            resources.put(MENU_STANDARD, new Image("res/buttons/menu/standard.gif"));
            resources.put(MENU_HOVER, new Image("res/buttons/menu/hover.gif"));
            resources.put(MENU_CLICKED, new Image("res/buttons/menu/clicked.gif"));
        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
