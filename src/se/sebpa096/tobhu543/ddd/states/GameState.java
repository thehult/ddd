package se.sebpa096.tobhu543.ddd.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.Tester;
import se.sebpa096.tobhu543.ddd.ingame.*;
import se.sebpa096.tobhu543.ddd.ingame.camera.Camera;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//this.game = game; <= no bug
@SuppressWarnings({ "JavaDoc", "ParameterHidesMemberVariable" })
public class GameState extends State {
    public static final float SPAWN_RATE = 0.01f;

    private Game game = null;

    private int levelNumber = 1;

    private Level level = null;
    private Camera camera = null;
    private HUD hud = null;

    private List<Player> players = new ArrayList<Player>();

    private Collection<IUpdateListener> updateListeners = new ArrayList<IUpdateListener>();
    private List<Room> activeRooms = null;

    @Override
    public void init(GameContainer gameContainer, Game game) {
	this.game = game;
        players = new ArrayList<Player>();
        initNewLevel();
        Player player = new Player();
        camera = new Camera(gameContainer);
        player.addEntityListener(camera);
        camera.setFollowEntity(player);
        player.setHealth(player.getMaxHealth());
        players.add(player);
        movePlayersToNewLevel();
        //addUpdateListener(player); //TODO se över detta, kan vara så att vi inte vill uppdatera via rum

	    level.initActives();
        hud = new HUD(player);
        player.setHealth(player.getMaxHealth());
        //camera.lockRoom(level.getStartRoom());
        Game.setStarted(true);

    }

    public void initNewLevel() {
        activeRooms = new ArrayList<Room>();
        updateListeners = new ArrayList<IUpdateListener>();
        UnitFactory.init();
        if(levelNumber % 4 == 0)
            level = LevelFactory.makeBossLevel();
        else
            level = LevelFactory.makeRealLevel(2, levelNumber * SPAWN_RATE);
        addUpdateListener(level);
        System.out.println("Starting level: " + levelNumber);
    }

    public void movePlayersToNewLevel() {
        for(Player player : players) {
            player.addEntityListener(level);
            player.setX(Entity.TILE_WIDTH_IN_PX * (Room.ROOM_WIDTH_IN_TILES / 2.0f - 1) - 5);
            player.setY(Entity.TILE_HEIGHT_IN_PX * (Room.ROOM_HEIGHT_IN_TILES / 2.0f - 1));
            player.setCurrentRoom(level.getStartRoom());
            player.setHealth(player.getMaxHealth());
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        for(IUpdateListener listener : updateListeners)
            listener.gameUpdate(gameContainer, delta);
	if(Game.TEST){
	    Tester.gameUpdate(gameContainer, game);
	}
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
	if(Game.TEST)
            graphics.scale(Tester.testScale, Tester.testScale);
	level.render(gameContainer, graphics, camera);
        if(Game.TEST)
            graphics.scale(1.0f/Tester.testScale, 1.0f/Tester.testScale);
        hud.render(gameContainer, graphics);

	if(Game.TEST){
        graphics.scale(Tester.testScale, Tester.testScale);
	    Tester.render(gameContainer, graphics);
	    graphics.drawString("x: " + players.get(0).getX(), 20, 30);
	    graphics.drawString("y: " + players.get(0).getY(), 20, 50);

	}

    }

    public void gameOver() {
        game.setState(Game.GAMEOVER_STATE);
    }

    public void levelFinished() {
        Game.WIN_STATE.setFinishedLevel(levelNumber);
        game.setState(Game.WIN_STATE);
    }

    public void addUpdateListener(IUpdateListener listener) {
        updateListeners.add(listener);
    }

    @SuppressWarnings("UnusedDeclaration") public void removeUpdateListener(IUpdateListener listener) {
        updateListeners.remove(listener);
    }

    public Iterable<Player> getPlayers() {
	return players;
    }

    public Level getLevel() {
	return level;
    }

    public Camera getCamera() {
	return camera;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }
}
