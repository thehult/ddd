package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ItemResources extends ResourceManager<Image> {

    public static final String SWORD_DROPPED = "swordDropped";
    public static final String SWORD_EQUIPPED = "swordEquipped";
    public static final String FIRE_SWORD_DROPPED = "fireSwordDropped";
    public static final String FIRE_SWORD_EQUIPPED = "fireSwordEquipped";

    public ItemResources() {
        super();
        try {
            resources.put(SWORD_DROPPED, new Image("res/items/sword_dropped.png"));
            resources.put(SWORD_EQUIPPED, new Image("res/items/sword_equipped.png"));
            resources.put(FIRE_SWORD_DROPPED, new Image("res/items/fire_sword_dropped.png"));
            resources.put(FIRE_SWORD_EQUIPPED, new Image("res/items/fire_sword_equipped.png"));

        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
