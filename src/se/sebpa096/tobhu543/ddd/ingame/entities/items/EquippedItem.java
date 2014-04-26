package se.sebpa096.tobhu543.ddd.ingame.entities.items;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;

/**
 * This class handles the logic of equipped items, and gives an abstraction of how the item classes should look.
 */
@SuppressWarnings("UnusedParameters")
public abstract class EquippedItem
{
    public DroppedItem getDroppedTwin() {
	return droppedTwin;
    }


    public void setDroppedTwin(final DroppedItem droppedTwin) {
	this.droppedTwin = droppedTwin;
    }

    protected DroppedItem droppedTwin = null;

    protected int cooldownMax = 0;
    protected int currentCooldown = cooldownMax;
    protected float range = Entity.TILE_WIDTH_IN_PX;

    protected EquippedItem(){

    }
    @SuppressWarnings("UnusedDeclaration") protected EquippedItem(DroppedItem item){
        this();
	    droppedTwin = item;

    }


    public void showDropped(float x, float y, Unit dropper){
        droppedTwin.setX(x);
        droppedTwin.setY(y);
        droppedTwin.putOnMap(dropper.getCurrentRoom());
        droppedTwin.addRecentPlayer(dropper); //TODO: VAD FAN ÄR FEL!?
    }

    public void tryUse(Unit user, float normX, float normY){
	if(currentCooldown <= 0){
	    currentCooldown = cooldownMax;
	    use(user, normX, normY);
	}
    }

    //Suppress since GameContainer might be of use later on (it contains the window parameters and such)

    public void gameUpdate(@SuppressWarnings("UnusedParameters") GameContainer gameContainer, int delta){
	if(currentCooldown > 0){
	    currentCooldown -= delta;
	    if(currentCooldown < 0 ) currentCooldown = 0;
	}
    }

    protected abstract void use(Unit user, float normX, float normY);

    @SuppressWarnings("UnusedDeclaration") public int getCooldownMax() {
        return cooldownMax;
    }

    @SuppressWarnings("UnusedDeclaration") public void setCooldownMax(int cooldownMax) {
        this.cooldownMax = cooldownMax;
    }

    @SuppressWarnings("UnusedDeclaration") public int getCurrentCooldown() {
        return currentCooldown;
    }

    @SuppressWarnings("UnusedDeclaration") public void setCurrentCooldown(int currentCooldown) {
        this.currentCooldown = currentCooldown;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }
}
