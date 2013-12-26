package se.sebpa096.tobhu543.ddd.ingame.entities.units.player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import se.sebpa096.tobhu543.ddd.ingame.IUpdateListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.UnitResources;

import java.util.ArrayList;

public class Player extends Unit implements IUpdateListener {
    public static int maxNoItems = 6;

    private EquippedItem[] equippedItems;

    public Player() {
        this.setSprite((Image)GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.PLAYER_DOWN));
        this.setMaxVelocity(300.0f);
	equippedItems = new EquippedItem[maxNoItems];
    }

    public boolean hasItemRoom(){
	return equippedItems.length < maxNoItems;
    }

    public void receiveItem(EquippedItem item){
	if (equippedItems.length < maxNoItems){
	    boolean foundEmpty = false;
	    for(int i = 0; i< maxNoItems; i++){
		if(equippedItems[i] == null){
		    equippedItems[i] = item;
		    foundEmpty = true;
		    break;
		}
	    }
	    if(!foundEmpty){
		System.out.println("ERROR! iteration över fullt inventory!");
	    }
	}else{
	    System.out.println("ERROR! spelare med fullt inventory tog upp item!");
	}
    }

    public void dropItem(int itemNo){
	EquippedItem item = equippedItems[itemNo];
	if(item != null){
	    item.showDropped(x, y, this); //drop on our position, register as recent user
	}
	equippedItems[itemNo] = null;
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
        this.setMovingDir(dX, dY);

        super.update(gameContainer, delta);
    }
}
