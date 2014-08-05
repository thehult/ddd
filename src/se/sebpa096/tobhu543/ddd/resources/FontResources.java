package se.sebpa096.tobhu543.ddd.resources;

import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.Color;
import java.io.File;


/**
 * Resources.
 */
public class FontResources extends ResourceManager<Font> {
    public static final String MENU_FONT = "menuFont";
    public static final String INGAME_FONT = "ingameFont";
    public static final int SMALL_FONT_SIZE = 22;
    public static final int MEDIUM_FONT_SIZE = 44;

    //Suppressing... something was probably wrong with the library
    @SuppressWarnings("unchecked") public FontResources() {
	try {
            UnicodeFont menuFont = new UnicodeFont("res" + File.separator + "fonts" + File.separator + "sketchedcassiusbroken.ttf", SMALL_FONT_SIZE, false, false);
            menuFont.addAsciiGlyphs();
            menuFont.getEffects().add(new ColorEffect(Color.WHITE));
            menuFont.loadGlyphs();
            resources.put(MENU_FONT, menuFont);

            UnicodeFont ingameFont = new UnicodeFont("res" + File.separator + "fonts" + File.separator + "sketchedcassiusbroken.ttf", MEDIUM_FONT_SIZE, false, false);
            ingameFont.addAsciiGlyphs();
            ingameFont.getEffects().add(new ColorEffect(Color.WHITE));
            ingameFont.loadGlyphs();
            resources.put(INGAME_FONT, ingameFont);

        } catch (SlickException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
