package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.io.File;

/**
 * Resources.
 */
public class UnitResources extends ResourceManager<Image> {
    public static final String PLAYER_DOWN = "playerDown";
    public static final String ORC_DOWN = "orcDown";
    public static final String WIZARD_DOWN = "wizardDown";
    public static final String NECROMANCER_DOWN = "necromancerDown";
    public static final String SKELETON_DOWN = "skeletonDown";
    public static final String CHEST_DOWN = "chestDown";
    public static final String LE_BOSS_DOWN = "leBossDown";

    public UnitResources() {
	try {
            resources.put(PLAYER_DOWN, new Image("res" + File.separator + "units" + File.separator + "player_down.png"));
            resources.put(ORC_DOWN, new Image("res" + File.separator + "units" + File.separator + "orc_down.png"));
            resources.put(WIZARD_DOWN, new Image("res" + File.separator + "units" + File.separator + "wizard_down.png"));
            resources.put(NECROMANCER_DOWN, new Image("res" + File.separator + "units" + File.separator + "necromancer_down.png"));
            resources.put(SKELETON_DOWN, new Image("res" + File.separator + "units" + File.separator + "skeleton_down.png"));
            resources.put(CHEST_DOWN, new Image("res" + File.separator + "units" + File.separator + "chest_down.png"));
            resources.put(LE_BOSS_DOWN, new Image("res" + File.separator + "units" + File.separator + "le_boss_down.png"));

        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
