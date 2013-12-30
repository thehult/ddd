package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.camera.Camera;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.IEntityListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA. User: Sebbe Date: 2013-10-02 Time: 18:56 To change this template use File | Settings | File
 * Templates.
 */
public class Level implements IUpdateListener, IEntityListener
{
    private Room startRoom;
    private ArrayList<ILevelListener> levelListeners = new ArrayList<ILevelListener>();
    private ArrayList<Room> activeRooms = new ArrayList<Room>();
    private ArrayList<Entity> activeEntities = new ArrayList<Entity>();

    public Level(){
    }


    public void initActives(){
	updateActiveRooms();
	updateActiveEntities();
    }

    public void render(GameContainer gameContainer, Graphics graphics, Camera camera){
        //startRoom.render(gameContainer, graphics, camera);
        camera.render(gameContainer, graphics);
    }


    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

    @Override public void entityChanged() {
    }

    @Override
    public void entityChangedRoom(Room r){
	updateActiveRooms();
	updateActiveEntities();
    }

    @Override
    public void gameUpdate(GameContainer gameContainer, int delta) {
	for(int i = 0; i<activeRooms.size(); i++){
	    activeRooms.get(i).gameUpdate(gameContainer, delta);
	}
        for(ILevelListener r: levelListeners){
            r.gameUpdate(gameContainer, delta);
        }
    }

    private void updateActiveRooms(){
	activeRooms.clear();
	for(Player p: Game.GAME_STATE.getPlayers()){
	    Room temp = p.getCurrentRoom();
	    if(!activeRooms.contains(temp) && temp != null) activeRooms.add(temp);
	    temp = p.getCurrentRoom().getTopRoom();
	    if(!activeRooms.contains(temp) && temp != null) activeRooms.add(temp);
	    temp = p.getCurrentRoom().getRightRoom();
	    if(!activeRooms.contains(temp) && temp != null) activeRooms.add(temp);
	    temp = p.getCurrentRoom().getBottomRoom();
	    if(!activeRooms.contains(temp) && temp != null) activeRooms.add(temp);
	    temp = p.getCurrentRoom().getLeftRoom();
	    if(!activeRooms.contains(temp) && temp != null) activeRooms.add(temp);
	}
    }

    private void updateActiveEntities(){
	activeEntities.clear();
	for(Room r: activeRooms){
	    for(Entity e: r.getEntities()) activeEntities.add(e);
	}
    }

    public void addLevelListener(ILevelListener e){
	levelListeners.add(e);
    }


    public ArrayList<Room> getActiveRooms(){
	return activeRooms;
    }

    public ArrayList<Entity> getActiveEntities() {
	return activeEntities;
    }
}
