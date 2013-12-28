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
    public static int maxNoItems = 6;

    private EquippedItem[] equippedItems;
    private int currentItemNo;
    private EquippedItem unarmedItem;

    public Player() {
        this.setSprite((Image)GlobalResources.getResource(GlobalResources.UNIT_RESOURCES, UnitResources.PLAYER_DOWN));
        this.setMaxVelocity(300.0f);
	equippedItems = new EquippedItem[maxNoItems];
	unarmedItem = new EUnarmed();

    }

    public boolean hasItemRoom(){
	boolean hasRoom = false;
	for(EquippedItem item: equippedItems){
	    if(item == null){
		hasRoom = true;
		break;
	    }
	}
	return hasRoom;
    }

    public void receiveItem(EquippedItem item){
	if (hasItemRoom()){
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

    public void cycleCurrentItem(int steps){
	currentItemNo = (currentItemNo + steps);
	if(currentItemNo < 0)
	    currentItemNo = maxNoItems - 1;
	if(currentItemNo >= maxNoItems)
	    currentItemNo = 0;
    }

    public void useItem(){
	EquippedItem current = equippedItems[currentItemNo];
	if(current == null){
	    unarmedItem.tryUse(this, 2); //TODO fixa direction
	}else{
	    equippedItems[currentItemNo].tryUse(this, 2); //TODO fixa direction!
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
	if(input.isKeyPressed(Input.KEY_Z))
	    cycleCurrentItem(-1);
	if(input.isKeyPressed(Input.KEY_X))
	    cycleCurrentItem(1);
	if(input.isKeyPressed(Input.KEY_SPACE))
	    useItem();
	if(input.isKeyPressed(Input.KEY_C))
	    dropItem(currentItemNo);

        this.setMovingDir(dX, dY);

	for(EquippedItem item: equippedItems){
	    if(item != null)
		    item.gameUpdate(gameContainer, delta);
	}
	unarmedItem.gameUpdate(gameContainer, delta);

        super.gameUpdate(gameContainer, delta);
    }
}
