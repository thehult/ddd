package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.io.File;

/**
 * Resources.
 */
public class BackgroundResources extends ResourceManager<Image> {
    public static final String MENU_BACKGROUND = "menuBackground";
    public static final String GAMEOVER_BACKGROUND = "gameOverBackground";
    public static final String WIN_BACKGROUND = "winBackground";

    public BackgroundResources() {
	try {
            resources.put(MENU_BACKGROUND, new Image("res" + File.separator + "backgrounds" + File.separator + "menu_background.gif"));
            resources.put(GAMEOVER_BACKGROUND, new Image("res" + File.separator + "backgrounds" + File.separator + "gameover_background.gif"));
            resources.put(WIN_BACKGROUND, new Image("res" + File.separator + "backgrounds" + File.separator + "win_background.gif"));
        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
