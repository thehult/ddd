package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

/**
 * The item Fire Sword equipped.
 */
public class EFireSword extends ESword
{

    public static final int FIRE_SWORD_STANDARD_COOLDOWN = 750;
    public static final int FIRE_SWORD_STANDARD_DAMAGE = 40;

    public EFireSword(){
	setDroppedTwin(new DFireSword(this));
	setCooldownMax(FIRE_SWORD_STANDARD_COOLDOWN);
	setSwordDamage(FIRE_SWORD_STANDARD_DAMAGE);
    }

}

