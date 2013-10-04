package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BackgroundResources extends ResourceManager<Image> {
    public static final String MENU_BACKGROUND = "menuBackground";

    public BackgroundResources() {
        super();
        try {
            resources.put(MENU_BACKGROUND, new Image("res/backgrounds/menu_background.gif"));
        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
