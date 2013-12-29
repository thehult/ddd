package se.sebpa096.tobhu543.ddd.ingame.entities.items;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.ingame.IUpdateListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.IEntityListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-25 Time: 19:08 To change this template use File | Settings | File
 * Templates.
 */
public abstract class EquippedItem
{
    public DroppedItem getDroppedTwin() {
	return droppedTwin;
    }


    public void setDroppedTwin(final DroppedItem droppedTwin) {
	this.droppedTwin = droppedTwin;
    }

    protected DroppedItem droppedTwin;

    protected int cooldownMax = 0;
    protected int currentCooldown = 0;
    protected float range = Tile.TILE_WIDTH_IN_PX;

    public EquippedItem(){
	    super();
    }
    public EquippedItem(DroppedItem item){
	    droppedTwin = item;
    }


    public void showDropped(float x, float y, Unit dropper){
        droppedTwin.setX(x);
        droppedTwin.setY(y);
        droppedTwin.putOnMap(dropper.getCurrentRoom());
        droppedTwin.addRecentPlayer(dropper);
    }

    public void tryUse(Unit user, float normX, float normY){
	if(currentCooldown <= 0){
	    currentCooldown = cooldownMax;
	    use(user, normX, normY);
	}
    }

    public void gameUpdate(GameContainer gameContainer, int delta){
	if(currentCooldown > 0){
	    currentCooldown = currentCooldown - delta;
	    if(currentCooldown < 0 ) currentCooldown = 0;
	}
    }

    protected abstract void use(Unit user, float normX, float normY);

    public int getCooldownMax() {
        return cooldownMax;
    }

    public void setCooldownMax(int cooldownMax) {
        this.cooldownMax = cooldownMax;
    }

    public int getCurrentCooldown() {
        return currentCooldown;
    }

    public void setCurrentCooldown(int currentCooldown) {
        this.currentCooldown = currentCooldown;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }
}
