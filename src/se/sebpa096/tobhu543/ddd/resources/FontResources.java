package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;



public class FontResources extends ResourceManager<Font> {
    private final String menuFontName = "menuFont";

    private final String menuFontPath = "res/fonts/sketchedcassiusbroken.ttf";

    public FontResources() {
        super();
        try {
            UnicodeFont menuFont = new UnicodeFont(menuFontPath, 22, false, false);
            menuFont.addAsciiGlyphs();
            menuFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
            menuFont.loadGlyphs();
            resources.put(menuFontName, menuFont);

        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
