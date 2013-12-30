package se.sebpa096.tobhu543.ddd.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.*;
import se.sebpa096.tobhu543.ddd.ingame.camera.Camera;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

import java.util.ArrayList;

public class GameState extends State {
    private Game game;

    private Level level;
    private Camera camera;
    private HUD hud;

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Room> activeRooms = new ArrayList<Room>();

    private ArrayList<IUpdateListener> updateListeners = new ArrayList<IUpdateListener>();

    @Override
    public void init(GameContainer gameContainer, Game game) {
	    this.game = game;
	    level = LevelFactory.makeTestLevel();
        Player player = new Player();
        camera = new Camera();
        player.addEntityListener(camera);
	    player.addEntityListener(level);
        camera.setFollowEntity(player);
        player.setCurrentRoom(level.getStartRoom());
        addUpdateListener(level);
        addUpdateListener(player);
	    players.add(player);
	    level.initActives();
        hud = new HUD(player);
        player.setHealth(player.getMaxHealth());
        //camera.lockRoom(level.getStartRoom());
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        for(IUpdateListener listener : updateListeners)
            listener.gameUpdate(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
	    level.render(gameContainer, graphics, camera);
        hud.render(gameContainer, graphics);
        graphics.drawString("x: " + players.get(0).getX(), 20, 30);
        graphics.drawString("y: " + players.get(0).getY(), 20, 50);
        graphics.drawString("blockX: " + players.get(0).blockX, 20, 70);
        graphics.drawString("blockY: " + players.get(0).blockY, 20, 90);
    }

    public void addUpdateListener(IUpdateListener listener) {
        updateListeners.add(listener);
    }

    public void removeUpdateListener(IUpdateListener listener) {
        updateListeners.remove(listener);
    }

    public ArrayList<Player> getPlayers() {
	return players;
    }

    public Level getLevel() {
	return level;
    }
}
