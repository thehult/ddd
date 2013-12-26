package se.sebpa096.tobhu543.ddd.ingame.entities.items;

import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-25 Time: 19:08 To change this template use File | Settings | File
 * Templates.
 */
public abstract class EquippedItem
{
    private DroppedItem droppedTwin;

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

    public abstract void use(int direction);
}
