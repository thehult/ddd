package se.sebpa096.tobhu543.ddd.ingame.entities.items;

import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-27 Time: 00:50 To change this template use File | Settings | File
 * Templates.
 */
public class EUnarmed extends EquippedItem
{
    public static int UNARMED_STANDARD_COOLDOWN = 500;

    public EUnarmed(){
	super();
	cooldownMax = UNARMED_STANDARD_COOLDOWN;
    }
    @Override public void use(final Player user, final int direction) {
	System.out.println("SMACK!");
    }
}
