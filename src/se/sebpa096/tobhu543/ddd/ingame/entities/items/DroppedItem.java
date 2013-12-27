package se.sebpa096.tobhu543.ddd.ingame.entities.items;

import javafx.geometry.Rectangle2D;
import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.IRoomListener;
import se.sebpa096.tobhu543.ddd.ingame.IUpdateListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-12-25 Time: 19:08 To change this template use File | Settings | File
 * Templates.
 */
public class DroppedItem extends Entity implements IRoomListener
{
    protected EquippedItem droppedTwin;
    private boolean onMap;
    private HashMap<Player, Boolean> recentPlayerTable = new HashMap<Player, Boolean>(); //keeps track of who can pick up

    public DroppedItem(){
	super();
    }
    public DroppedItem(EquippedItem twin){
	super();
	droppedTwin = twin;
    }

    public void gameUpdate(GameContainer gameContainer, int delta){
	super.update(gameContainer, delta);
	System.out.println("Dropped uppdaterad!");
	if(onMap){
	    handlePlayerCollision();
	}

    }

    private void handlePlayerCollision(){
	ArrayList<Player> collPlayers = collidingPlayers();
	if(collPlayers.size() > 0){
	    collPlayers.get(0).receiveItem(droppedTwin);
	}else{

	}

	boolean foundPlayer = false;
	for(Player collPlayer: collPlayers){
	    if(collPlayer.hasItemRoom()){
		collPlayer.receiveItem(droppedTwin);
		foundPlayer = true;
		break;
	    }
	}
	if(foundPlayer){
	    removeFromMap();
	}
    }

    private ArrayList<Player> collidingPlayers(){ //returns all colliding eligible players
	Rectangle2D itemRect = new Rectangle2D(x, y, TILE_WIDTH_IN_PX, TILE_HEIGHT_IN_PX);
	ArrayList<Player> colliding = new ArrayList<Player>();
	for(Player player: Game.GAME_STATE.getPlayers()){
	    Rectangle2D playerRect = new Rectangle2D(player.getX(), player.getY(), TILE_HEIGHT_IN_PX, TILE_WIDTH_IN_PX);
	    if(itemRect.intersects(playerRect) && !recentPlayerTable.get(player) && player.hasItemRoom()){
		colliding.add(player);
	    }else{
		recentPlayerTable.put(player, false);
	    }
	}
	return colliding;
    }

    public void addRecentPlayer(Player player){
	recentPlayerTable.put(player, true);
    }

    public void putOnMap() {
	this.onMap = true;
    }

    public void removeFromMap(){
	recentPlayerTable.clear();
	onMap = false;
    }
}
