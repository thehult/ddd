package se.sebpa096.tobhu543.ddd.ingame.entities.items;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.ingame.IUpdateListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-25 Time: 19:08 To change this template use File | Settings | File
 * Templates.
 */
public abstract class EquippedItem
{
    protected DroppedItem droppedTwin;

    protected int cooldownMax = 0;
    protected int currentCooldown = 0;

    public EquippedItem(){
	super();
    }
    public EquippedItem(DroppedItem item){
	droppedTwin = item;
    }


    public void showDropped(float x, float y, Player dropper){
	droppedTwin.setX(x);
	droppedTwin.setY(y);
	droppedTwin.putOnMap();
	droppedTwin.addRecentPlayer(dropper);
    }

    public void tryUse(Player user, int direction){
	if(currentCooldown <= 0){
	    currentCooldown = cooldownMax;
	    use(user, direction);
	}
    }

    public void gameUpdate(GameContainer gameContainer, int delta){
	if(currentCooldown > 0){
	    currentCooldown = currentCooldown - delta;
	    if(currentCooldown < 0 ) currentCooldown = 0;
	}
    }

    public abstract void use(Player user, int direction);
}
