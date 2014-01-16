package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-28 Time: 21:49 To change this template use File | Settings | File
 * Templates.
 */
@SuppressWarnings("JavaDoc")
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

