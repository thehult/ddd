package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.io.File;

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
            resources.put(DEFAULT_STANDARD, new Image("res" + File.separator + "buttons" + File.separator + "default" + File.separator + "standard.gif"));
            resources.put(DEFAULT_HOVER, new Image("res" + File.separator + "buttons" + File.separator + "default" + File.separator + "hover.gif"));
            resources.put(DEFAULT_CLICKED, new Image("res" + File.separator + "buttons" + File.separator + "default" + File.separator + "clicked.gif"));
            resources.put(MENU_STANDARD, new Image("res" + File.separator + "buttons" + File.separator + "menu" + File.separator + "standard.gif"));
            resources.put(MENU_HOVER, new Image("res" + File.separator + "buttons" + File.separator + "menu" + File.separator + "hover.gif"));
            resources.put(MENU_CLICKED, new Image("res" + File.separator + "buttons" + File.separator + "menu" + File.separator + "clicked.gif"));
        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
