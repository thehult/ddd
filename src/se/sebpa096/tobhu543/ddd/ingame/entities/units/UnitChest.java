package se.sebpa096.tobhu543.ddd.ingame.entities.units;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.enums.Faction;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

/**
 * A chest which contains an item. Extends Unit to provide the hit registration for players.
 */
public class UnitChest extends Unit {

    public UnitChest() {
	this.setSprite((Image) GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.CHEST_DOWN));
        this.setMaxVelocity(0.0f);
        this.setRandomHealthMin(1);
        this.setRandomHealthMax(2);
	this.setFaction(Faction.ENEMY);
    }
}
