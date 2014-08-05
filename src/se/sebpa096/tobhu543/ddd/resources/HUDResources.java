package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.io.File;

/**
 * Resources.
 */
public class HUDResources extends ResourceManager<Image> {
    public static final String HUD1 = "hud1";
    public static final String HUD1_CUR_ITEM = "hud1CurItem";
    public static final String HUD1_CUR_HEALTH = "hud1CurHealth";

    public HUDResources() {
	try {
            resources.put(HUD1, new Image("res" + File.separator + "hud" + File.separator + "hud1.png"));
            resources.put(HUD1_CUR_ITEM, new Image("res" + File.separator + "hud" + File.separator + "hud1_curitem.png"));
            resources.put(HUD1_CUR_HEALTH, new Image("res" + File.separator + "hud" + File.separator + "hud1_curhealth.png"));

        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
