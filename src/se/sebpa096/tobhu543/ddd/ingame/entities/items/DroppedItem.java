package se.sebpa096.tobhu543.ddd.ingame.entities.items;

import javafx.geometry.Rectangle2D;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.IRoomListener;
import se.sebpa096.tobhu543.ddd.ingame.Room;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-25 Time: 19:08 To change this template use File | Settings | File
 * Templates.
 */
public class DroppedItem extends Entity implements IRoomListener
{
    protected EquippedItem droppedTwin;
    private boolean onMap;
    private HashMap<Unit, Boolean> recentPlayerTable = new HashMap<Unit, Boolean>(); //keeps track of who can pick up

    public DroppedItem(){
	super();
    }
    public DroppedItem(EquippedItem twin){
	super();
	droppedTwin = twin;
	droppedTwin.setDroppedTwin(this);
    }

    @Override
    public void render(final GameContainer gameContainer, final Graphics graphics, final float screenX, final float screenY) {
	if(onMap)
		super.render(gameContainer, graphics, screenX, screenY);

    }

    @Override
    public void gameUpdate(GameContainer gameContainer, int delta){
	super.gameUpdate(gameContainer, delta);
	if(onMap){
	    handlePlayerCollision();
	}

    }

    private void handlePlayerCollision(){
	ArrayList<Player> collPlayers = collidingPlayers();
	if(collPlayers.size() > 0){
	    collPlayers.get(0).receiveItem(droppedTwin);
	    removeFromMap();
	}
    }

    private ArrayList<Player> collidingPlayers(){ //returns all colliding eligible players
	Rectangle2D itemRect = new Rectangle2D(x, y, TILE_WIDTH_IN_PX, TILE_HEIGHT_IN_PX);
	ArrayList<Player> colliding = new ArrayList<Player>();
	for(Player player: Game.GAME_STATE.getPlayers()){
	    Rectangle2D playerRect = new Rectangle2D(player.getX(), player.getY(), TILE_HEIGHT_IN_PX, TILE_WIDTH_IN_PX);
	    boolean intersects = itemRect.intersects(playerRect) && player.getCurrentRoom() == getCurrentRoom();
  	    if(intersects && !recentPlayerTable.get(player) && player.hasItemRoom()){
		colliding.add(player);
	    }else if(!itemRect.intersects(playerRect)){
		recentPlayerTable.put(player, false);
	    }
	}
	return colliding;
    }

    public void addRecentPlayer(Unit unit){
	recentPlayerTable.put(unit, true);
    }

    public void putOnMap(Room room) {
	setCurrentRoom(room);
	this.onMap = true;
    }

    public void removeFromMap(){
	setCurrentRoom(null);
	recentPlayerTable.clear();
	onMap = false;
    }
}
