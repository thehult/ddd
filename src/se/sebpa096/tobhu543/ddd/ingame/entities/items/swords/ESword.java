package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-25 Time: 19:06 To change this template use File | Settings | File
 * Templates.
 */
public class ESword extends EquippedItem
{

    @Override public void use(final int direction) {
	System.out.println("CHIIIING!");
    }
}
