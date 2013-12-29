package se.sebpa096.tobhu543.ddd.ingame.entities.units.player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import se.sebpa096.tobhu543.ddd.ingame.IUpdateListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EUnarmed;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

public class Player extends Unit implements IUpdateListener {



    public Player() {
        this.setSprite((Image)GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.PLAYER_DOWN));
        this.setMaxVelocity(300.0f);
        this.setMaxNoItems(6);

    }



    @Override
    public void gameUpdate(GameContainer gameContainer, int delta) {
        Input input = gameContainer.getInput();
        float dX = 0.0f, dY = 0.0f;
        if(input.isKeyDown(Input.KEY_LEFT))
            dX = -1.0f;
        if(input.isKeyDown(Input.KEY_RIGHT))
            dX = 1.0f;
        if(input.isKeyDown(Input.KEY_UP))
            dY = -1.0f;
        if(input.isKeyDown(Input.KEY_DOWN))
            dY = 1.0f;
	if(input.isKeyPressed(Input.KEY_Z))
	    cycleCurrentItem(-1);
	if(input.isKeyPressed(Input.KEY_X))
	    cycleCurrentItem(1);
	if(input.isKeyPressed(Input.KEY_SPACE))
	    useItem();
	if(input.isKeyPressed(Input.KEY_C))
	    dropItem(getCurrentItemNo());

        this.setMovingDir(dX, dY);



        super.gameUpdate(gameContainer, delta);
    }
}
