package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class UnitResources extends ResourceManager<Image> {
    public static final String PLAYER_DOWN = "playerDown";
    public static final String ORC_DOWN = "orcDown";

    public UnitResources() {
        super();
        try {
            resources.put(PLAYER_DOWN, new Image("res/units/player_down.png"));
            resources.put(ORC_DOWN, new Image("res/units/orc_down.png"));

        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
