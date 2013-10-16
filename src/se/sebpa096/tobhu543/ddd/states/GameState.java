package se.sebpa096.tobhu543.ddd.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.Level;
import se.sebpa096.tobhu543.ddd.ingame.LevelFactory;
import se.sebpa096.tobhu543.ddd.ingame.Room;
import se.sebpa096.tobhu543.ddd.ingame.camera.Camera;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

public class GameState extends State {
    private Game game;

    private Level level;
    private Camera camera;
    private Player player;

    @Override
    public void init(GameContainer gameContainer, Game game) {
	    this.game = game;
	    level = LevelFactory.makeTestLevel();
        player = new Player();
        camera = new Camera();
        player.addEntityListener(camera);
        camera.setFollowEntity(player);
        level.getStartRoom().addEntity(player);
        //camera.lockRoom(level.getStartRoom());
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
	    level.update(gameContainer, delta);
        player.update(gameContainer, delta);
        if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT))
            player.setX(player.getX() - 200.0f * delta / 1000.0f);
        if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT))
            player.setX(player.getX() + 200.0f * delta / 1000.0f);
        if(gameContainer.getInput().isKeyDown(Input.KEY_UP))
            player.setY(player.getY() - 200.0f * delta / 1000.0f);
        if(gameContainer.getInput().isKeyDown(Input.KEY_DOWN))
            player.setY(player.getY() + 200.0f * delta / 1000.0f);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
	    level.render(gameContainer, graphics, camera);
    }
}
