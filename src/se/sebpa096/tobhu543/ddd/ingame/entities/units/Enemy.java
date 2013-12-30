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
        float closestDistance = Float.MAX_VALUE;
        for(Player player : Game.GAME_STATE.getPlayers()) {
            float connectAdds = ((player.getCurrentRoom().getX() - getCurrentRoom().getX()) + (player.getCurrentRoom().getY() - getCurrentRoom().getY())) * TILE_WIDTH_IN_PX;
            float playerDist = (float)Math.hypot(((player.getCurrentRoom().getX() * Room.ROOM_WIDTH_IN_PX + player.getX()) - (getCurrentRoom().getX() * Room.ROOM_WIDTH_IN_PX + getX())),
                    ((player.getCurrentRoom().getY() * Room.ROOM_HEIGHT_IN_PX + player.getY() + connectAdds) - (getCurrentRoom().getY() * Room.ROOM_HEIGHT_IN_PX + getY())));
            if(playerDist < closestDistance) {
                closestDistance = playerDist;
                closestPlayer = player;
            }
        }
        if(closestPlayer != null) {
            float connectAddsX = (closestPlayer.getCurrentRoom().getX() - getCurrentRoom().getX()) * TILE_WIDTH_IN_PX;
            float connectAddsY = (closestPlayer.getCurrentRoom().getY() - getCurrentRoom().getY()) * TILE_HEIGHT_IN_PX;
            float normX = ((closestPlayer.getCurrentRoom().getX() * Room.ROOM_WIDTH_IN_PX + closestPlayer.getX() + connectAddsX) - (getCurrentRoom().getX() * Room.ROOM_WIDTH_IN_PX + getX()))/closestDistance;
            float normY = ((closestPlayer.getCurrentRoom().getY() * Room.ROOM_HEIGHT_IN_PX + closestPlayer.getY() + connectAddsY) - (getCurrentRoom().getY() * Room.ROOM_HEIGHT_IN_PX + getY()))/closestDistance;
            if(closestDistance < getCurrentItem().getRange()) {
                stopEntity();
                //TODO: TA BORT NÄSTA IF-SATS, TEST ONLY
                if(getCurrentItem().getCurrentCooldown() <= 0)
                    closestPlayer.setHealth(closestPlayer.getHealth() - 10);
                getCurrentItem().tryUse(this, normX, normY);

            } else {
                setMovingDir(normX, normY);
            }
        }
        super.gameUpdate(gameContainer, delta);
    }
}
