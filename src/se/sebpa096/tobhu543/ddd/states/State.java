package se.sebpa096.tobhu543.ddd.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.Game;

@SuppressWarnings("JavaDoc")
public abstract class State {
    protected Image backgroundImage = null;
    public abstract void init(GameContainer gameContainer, Game game);
    public abstract void update(GameContainer gameContainer, int delta);
    public abstract void render(GameContainer gameContainer, Graphics graphics);
}
