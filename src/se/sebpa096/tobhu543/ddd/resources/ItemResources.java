package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.io.File;

/**
 * Resources.
 */
public class ItemResources extends ResourceManager<Image> {

    public static final String SWORD_DROPPED = "swordDropped";
    public static final String SWORD_EQUIPPED = "swordEquipped";
    public static final String FIRE_SWORD_DROPPED = "fireSwordDropped";
    public static final String FIRE_SWORD_EQUIPPED = "fireSwordEquipped";
    public static final String BOOK_OF_SIN_DROPPED = "bookOfSinDropped";
    public static final String BOOK_OF_SIN_EFFECT = "bookOfSinEffect";
    public static final String BOW_DROPPED = "bowDropped";
    public static final String BOW_PROJECTILE = "bowProjectile";
    public static final String ENERGY_ROD_DROPPED = "energyRodDropped";
    public static final String ENERGY_ROD_PROJECTILE = "energyRodProjectile";

    public ItemResources() {
	try {
            resources.put(SWORD_DROPPED, new Image("res" + File.separator + "items" + File.separator + "sword_dropped.png"));
            resources.put(SWORD_EQUIPPED, new Image("res" + File.separator + "items" + File.separator + "sword_equipped.png"));
            resources.put(FIRE_SWORD_DROPPED, new Image("res" + File.separator + "items" + File.separator + "fire_sword_dropped.png"));
            resources.put(FIRE_SWORD_EQUIPPED, new Image("res" + File.separator + "items" + File.separator + "fire_sword_equipped.png"));
            resources.put(BOOK_OF_SIN_DROPPED, new Image("res" + File.separator + "items" + File.separator + "book_of_sin_dropped.png"));
            resources.put(BOOK_OF_SIN_EFFECT, new Image("res" + File.separator + "items" + File.separator + "book_of_sin_effect.png"));
            resources.put(BOW_DROPPED, new Image("res" + File.separator + "items" + File.separator + "bow_dropped.png"));
            resources.put(BOW_PROJECTILE, new Image("res" + File.separator + "items" + File.separator + "bow_projectile.png"));
            resources.put(ENERGY_ROD_DROPPED, new Image("res" + File.separator + "items" + File.separator + "energy_rod_dropped.png"));
            resources.put(ENERGY_ROD_PROJECTILE, new Image("res" + File.separator + "items" + File.separator + "energy_rod_projectile.png"));

        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
