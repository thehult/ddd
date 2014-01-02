package se.sebpa096.tobhu543.ddd.ingame.entities.items.magics;

import se.sebpa096.tobhu543.ddd.ingame.UnitFactory;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.bows.DBow;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemySkeleton;

public class EBookOfSin extends EquippedItem {
    public static int BOS_STANDARD_COOLDOWN = 8000;
    public EBookOfSin(){
        super();
        cooldownMax = BOS_STANDARD_COOLDOWN;
        this.setRange(5 * Tile.TILE_WIDTH_IN_PX);
        droppedTwin = new DBookOfSin(this);
    }

    @Override
    protected void use(final Unit user, final float normX, final float normY) {
        EnemySkeleton skeleton = (EnemySkeleton)UnitFactory.makeUnit(EnemySkeleton.class);
        skeleton.setX(user.getX());
        skeleton.setY(user.getY());
        skeleton.setCurrentRoom(user.getCurrentRoom());
    }
}
