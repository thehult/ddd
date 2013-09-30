package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BackgroundResources extends ResourceManager<Image> {
    private final String menuBackgroundName = "menuBackground";

    private final String menuBackgroundPath = "res/backgrounds/menu_background.gif";

    public BackgroundResources() {
        super();
        try {
            resources.put(menuBackgroundName, new Image(menuBackgroundPath));
        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
