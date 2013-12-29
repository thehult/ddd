package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-28 Time: 21:49 To change this template use File | Settings | File
 * Templates.
 */
public class EFireSword extends EquippedItem
{

    public static int FIRESWORD_STANDARD_COOLDOWN = 2000;
    public EFireSword(){
	super();
	cooldownMax = FIRESWORD_STANDARD_COOLDOWN;
    }

    @Override
    protected void use(final Unit user, final float normX, final float normY) {
	System.out.println("FWOOOSH");
    }
}
