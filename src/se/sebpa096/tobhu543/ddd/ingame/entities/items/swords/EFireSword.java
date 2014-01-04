package se.sebpa096.tobhu543.ddd.ingame.entities.items.swords;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.Tester;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;
import se.sebpa096.tobhu543.ddd.ingame.enums.Faction;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-28 Time: 21:49 To change this template use File | Settings | File
 * Templates.
 */
public class EFireSword extends ESword
{

    public static int FIRE_SWORD_STANDARD_COOLDOWN = 750;
    public static int FIRE_SWORD_STANDARD_DAMAGE = 40;

    public EFireSword(){
	super();
        droppedTwin = new DFireSword(this);
	cooldownMax = FIRE_SWORD_STANDARD_COOLDOWN;
	swordDamage = FIRE_SWORD_STANDARD_DAMAGE;
    }

}

