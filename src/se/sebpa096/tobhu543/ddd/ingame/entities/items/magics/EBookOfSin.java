package se.sebpa096.tobhu543.ddd.ingame.entities.items.magics;

import se.sebpa096.tobhu543.ddd.ingame.UnitFactory;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.enemies.EnemySkeleton;

/**
 * The item Book Of Sin equipped.
 */
public class EBookOfSin extends EquippedItem {
    public static final int BOS_STANDARD_COOLDOWN = 8000;
    public EBookOfSin(){
	setCooldownMax(BOS_STANDARD_COOLDOWN);
        this.setRange(5 * Entity.TILE_WIDTH_IN_PX);
        setDroppedTwin(new DBookOfSin(this));
    }

    @Override
    protected void use(final Unit user, final float normX, final float normY) {
        EnemySkeleton skeleton = (EnemySkeleton)UnitFactory.makeUnit(EnemySkeleton.class);
        skeleton.setX(user.getX());
        skeleton.setY(user.getY());
        skeleton.setCurrentRoom(user.getCurrentRoom());
    }
}
