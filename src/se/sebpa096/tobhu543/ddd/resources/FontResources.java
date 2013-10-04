package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;



public class FontResources extends ResourceManager<Font> {
    public static final String MENU_FONT = "menuFont";

    public FontResources() {
        super();
        try {
            UnicodeFont menuFont = new UnicodeFont("res/fonts/sketchedcassiusbroken.ttf", 22, false, false);
            menuFont.addAsciiGlyphs();
            menuFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
            menuFont.loadGlyphs();
            resources.put(MENU_FONT, menuFont);

        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
