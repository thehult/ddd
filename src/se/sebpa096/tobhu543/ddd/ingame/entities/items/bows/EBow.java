package se.sebpa096.tobhu543.ddd.ingame.entities.items.bows;

import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.projectiles.Arrow;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

public class EBow extends EquippedItem{

    public static int BOW_STANDARD_COOLDOWN = 1000;
    public static float BOW_STANDARD_ARROW_SPEED = 600;


    public EBow(){
        super();
        cooldownMax = BOW_STANDARD_COOLDOWN;
        this.setRange(4 * Tile.TILE_WIDTH_IN_PX);
        droppedTwin = new DBow(this);
    }

    @Override
    protected void use(final Unit user, final float normX, final float normY) {
	Arrow arrow = new Arrow(user.getCenterX() - (Arrow.ARROW_STANDARD_SIZE/2), user.getCenterY()-(Arrow.ARROW_STANDARD_SIZE/2),
				normX * BOW_STANDARD_ARROW_SPEED,
				normY * BOW_STANDARD_ARROW_SPEED,
				user);
	arrow.setCurrentRoom(user.getCurrentRoom());
    }
}
