package se.sebpa096.tobhu543.ddd.ingame.entities.items.bows;

import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

public class EBow extends EquippedItem{
    public static int BOW_STANDARD_COOLDOWN = 4000;
    public EBow(){
        super();
        cooldownMax = BOW_STANDARD_COOLDOWN;
        this.setRange(4 * Tile.TILE_WIDTH_IN_PX);
        droppedTwin = new DBow(this);
    }

    @Override
    protected void use(final Unit user, final float normX, final float normY) {

    }
}
