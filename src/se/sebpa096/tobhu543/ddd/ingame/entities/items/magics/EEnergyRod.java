package se.sebpa096.tobhu543.ddd.ingame.entities.items.magics;

import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

public class EEnergyRod extends EquippedItem {
    public static int BOS_STANDARD_COOLDOWN = 6000;
    public EEnergyRod(){
        super();
        cooldownMax = BOS_STANDARD_COOLDOWN;
        this.setRange(4 * Tile.TILE_WIDTH_IN_PX);
        droppedTwin = new DEnergyRod(this);
    }

    @Override
    protected void use(final Unit user, final float normX, final float normY) {

    }
}
