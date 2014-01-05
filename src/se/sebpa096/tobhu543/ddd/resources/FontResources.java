package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;



public class FontResources extends ResourceManager<Font> {
    public static final String MENU_FONT = "menuFont";
    public static final String INGAME_FONT = "ingameFont";

    public FontResources() {
        super();
        try {
            UnicodeFont menuFont = new UnicodeFont("res/fonts/sketchedcassiusbroken.ttf", 22, false, false);
            menuFont.addAsciiGlyphs();
            menuFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
            menuFont.loadGlyphs();
            resources.put(MENU_FONT, menuFont);

            UnicodeFont ingameFont = new UnicodeFont("res/fonts/sketchedcassiusbroken.ttf", 44, false, false);
            ingameFont.addAsciiGlyphs();
            ingameFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
            ingameFont.loadGlyphs();
            resources.put(INGAME_FONT, ingameFont);

        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
