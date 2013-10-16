package se.sebpa096.tobhu543.ddd.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.Level;
import se.sebpa096.tobhu543.ddd.ingame.LevelFactory;
import se.sebpa096.tobhu543.ddd.ingame.Room;
import se.sebpa096.tobhu543.ddd.ingame.camera.Camera;

public class GameState extends State {
    private Game game;

    private Level level;
    private Camera camera;

    @Override
    public void init(GameContainer gameContainer, Game game) {
	    this.game = game;
	    level = LevelFactory.makeTestLevel();
        camera = new Camera();
        camera.lockRoom(level.getStartRoom());
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
	    level.update(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
	    level.render(gameContainer, graphics, camera);
    }
}
