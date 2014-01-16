package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.TileResources;

@SuppressWarnings("JavaDoc")
public class StairsGoal extends StaticEntity {

    public StairsGoal() {
        this.setSprite((Image) GlobalResources.getResource(GlobalResources.TILE_RESOURCES, TileResources.STAIRS_GOAL));
    }

    @Override
    public void gameUpdate(GameContainer gameContainer, int delta) {
        super.gameUpdate(gameContainer, delta);
        for(Player player : Game.GAME_STATE.getPlayers()) {
	    if(player.isCollidingWith(this)){
            Game.GAME_STATE.levelFinished();
	    }
        }
    }
}
