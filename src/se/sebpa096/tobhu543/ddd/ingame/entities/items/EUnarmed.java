package se.sebpa096.tobhu543.ddd.ingame.entities.items;

import se.sebpa096.tobhu543.ddd.ingame.entities.items.swords.ESword;

/**
 * This is the item used when no other item is equipped.
 */
@SuppressWarnings("JavaDoc")
public class EUnarmed extends ESword
{
    public static final int UNARMED_STANDARD_COOLDOWN = 500;
    public static final int UNARMED_STANDARD_DAMAGE = 10;

    public EUnarmed(){
	setCooldownMax(UNARMED_STANDARD_COOLDOWN);
	setSwordDamage(UNARMED_STANDARD_DAMAGE);
    }
}
