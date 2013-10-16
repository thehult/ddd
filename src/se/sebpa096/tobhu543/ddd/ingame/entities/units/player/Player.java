package se.sebpa096.tobhu543.ddd.ingame.entities.units.player;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

public class Player extends Unit {
    public Player() {
        this.setSprite((Image)GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.PLAYER_DOWN));
    }
}
