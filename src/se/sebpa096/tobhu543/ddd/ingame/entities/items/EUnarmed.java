package se.sebpa096.tobhu543.ddd.ingame.entities.items;

import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.ESword;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-27 Time: 00:50 To change this template use File | Settings | File
 * Templates.
 */
@SuppressWarnings("JavaDoc")
public class EUnarmed extends ESword
{
    public static final int UNARMED_STANDARD_COOLDOWN = 500;
    public static final int UNARMED_STANDARD_DAMAGE = 10;

    public EUnarmed(){
	cooldownMax = UNARMED_STANDARD_COOLDOWN;
	swordDamage = UNARMED_STANDARD_DAMAGE;
    }
}
