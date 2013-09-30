package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ButtonImageResources extends ResourceManager<Image> {
    private final String defaultStandardName = "defaultStandard";
    private final String defaultHoverName = "defaultHover";
    private final String defaultClickedName = "defaultClicked";
    private final String menuStandardName = "menuStandard";
    private final String menuHoverName = "menuHover";
    private final String menuClickedName = "menuClicked";

    private final String defaultStandardPath = "res/default_button_standard.gif";
    private final String defaultHoverPath = "res/default_button_hover.gif";
    private final String defaultClickedPath = "res/default_button_clicked.gif";
    private final String menuStandardPath = "res/menu_button_standard.gif";
    private final String menuHoverPath = "res/menu_button_hover.gif";
    private final String menuClickedPath = "res/menu_button_clicked.gif";

    public ButtonImageResources() {
        super();
        try {
            resources.put(defaultStandardName, new Image(defaultStandardPath));
            resources.put(defaultHoverName, new Image(defaultHoverPath));
            resources.put(defaultClickedName, new Image(defaultClickedPath));
            resources.put(menuStandardName, new Image(menuStandardPath));
            resources.put(menuHoverName, new Image(menuHoverPath));
            resources.put(menuClickedName, new Image(menuClickedPath));
        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
