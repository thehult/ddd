package se.sebpa096.tobhu543.ddd.ingame.entities.units;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;

public class Enemy extends Unit {
    public Enemy() {
        this.setMaxNoItems(1);
    }
    public void gameUpdate(GameContainer gameContainer, int delta) {
        Player closestPlayer = null;
        float closestDistance = Integer.MAX_VALUE;
        for(Player player : Game.GAME_STATE.getPlayers()) {
            float playerDist = (float)Math.hypot(player.getX() - this.getX(), player.getY() - this.getY());
            if(playerDist < closestDistance) {
                closestDistance = playerDist;
                closestPlayer = player;
            }
        }
        float normX = (closestPlayer.getX() - getX())/closestDistance;
        float normY = (closestPlayer.getY() - getY())/closestDistance;
        if(closestDistance < getCurrentItem().getRange()) {
            getCurrentItem().tryUse(this, normX, normY);
        } else {
            setMovingDir(normX, normY);
        }
    }
}
