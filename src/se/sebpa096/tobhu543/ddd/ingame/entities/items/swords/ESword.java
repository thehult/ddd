package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-25 Time: 19:06 To change this template use File | Settings | File
 * Templates.
 */
public class ESword extends EquippedItem
{
    public static int SWORD_STANDARD_COOLDOWN = 750;
    public ESword(){
	super();
	cooldownMax = SWORD_STANDARD_COOLDOWN;
    }

    @Override protected void use(final Player user,final int direction) {
	System.out.println("CHIIIING!");
    }
}
