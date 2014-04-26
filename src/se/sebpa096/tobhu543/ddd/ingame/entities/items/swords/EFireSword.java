package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

/**
 * The item Fire Sword equipped.
 */
public class EFireSword extends ESword
{

    public static final int FIRE_SWORD_STANDARD_COOLDOWN = 750;
    public static final int FIRE_SWORD_STANDARD_DAMAGE = 40;

    public EFireSword(){
	droppedTwin = new DFireSword(this);
	cooldownMax = FIRE_SWORD_STANDARD_COOLDOWN;
	swordDamage = FIRE_SWORD_STANDARD_DAMAGE;
    }

}

