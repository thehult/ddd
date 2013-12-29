package se.sebpa096.tobhu543.ddd.ingame.entities.units;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.Room;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

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
        float normX = ((closestPlayer.getCurrentRoom().getX() * Room.ROOM_WIDTH_IN_PX + closestPlayer.getX()) - (getCurrentRoom().getX() * Room.ROOM_WIDTH_IN_PX + getX()))/closestDistance;
        float normY = ((closestPlayer.getCurrentRoom().getY() * Room.ROOM_HEIGHT_IN_PX + closestPlayer.getY()) - (getCurrentRoom().getY() * Room.ROOM_HEIGHT_IN_PX + getY()))/closestDistance;
        if(closestDistance < getCurrentItem().getRange()) {
            stopEntity();
            getCurrentItem().tryUse(this, normX, normY);
        } else {
            setMovingDir(normX, normY);
        }
        super.gameUpdate(gameContainer, delta);
    }
}
