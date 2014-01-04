package se.sebpa096.tobhu543.ddd.ingame.entities.items.magics;

import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.projectiles.EnergyOrb;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

public class EEnergyRod extends EquippedItem {

    public static int ER_STANDARD_COOLDOWN = 1000;
    public static float ER_STANDARD_LAUNCH_SPEED = 200f;

    public EEnergyRod(){
        super();
        cooldownMax = ER_STANDARD_COOLDOWN;
        this.setRange(4 * Tile.TILE_WIDTH_IN_PX);
        droppedTwin = new DEnergyRod(this);
    }

    @Override
    protected void use(final Unit user, final float normX, final float normY) {
	EnergyOrb energyOrb = new EnergyOrb(user.getX(), user.getY(),
					    normX * ER_STANDARD_LAUNCH_SPEED,
					    normY * ER_STANDARD_LAUNCH_SPEED,
					    user);
	energyOrb.setCurrentRoom(user.getCurrentRoom());
    }
}
