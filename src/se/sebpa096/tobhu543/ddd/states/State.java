package se.sebpa096.tobhu543.ddd.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.Game;

public abstract class State {
    public abstract void init(GameContainer gameContainer);
    public abstract void update(GameContainer gameContainer, int delta);
    public abstract void render(GameContainer gameContainer, Graphics graphics);
}
