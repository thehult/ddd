package se.sebpa096.tobhu543.ddd.ingame.entities.units;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.ingame.entities.MovingEntity;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EUnarmed;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;

public class Unit extends MovingEntity {
    private int maxNoItems = 1;
    private EquippedItem[] equippedItems;
    private int currentItemNo = 0;
    private EquippedItem unarmedItem;

    public Unit() {
        unarmedItem = new EUnarmed();
        setMaxNoItems(1);
    }


    public void gameUpdate(GameContainer gameContainer, int delta) {

        for(EquippedItem item: equippedItems){
            if(item != null)
                item.gameUpdate(gameContainer, delta);
        }
        unarmedItem.gameUpdate(gameContainer, delta);
        super.gameUpdate(gameContainer,delta);
    }

    public EquippedItem getCurrentItem() {
        EquippedItem current = equippedItems[currentItemNo];
        if(current == null)
            return unarmedItem;
        return current;
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
            unarmedItem.tryUse(this, getMovingDirX(), getMovingDirY()); //TODO fixa direction
        }else{
            equippedItems[currentItemNo].tryUse(this, getMovingDirX(), getMovingDirY()); //TODO fixa direction!
        }
    }

    public void dropItem(int itemNo){
        EquippedItem item = equippedItems[itemNo];
        if(item != null){
            item.showDropped(x, y, this); //drop on our position, register as recent user
        }
        equippedItems[itemNo] = null;
    }

    public int getMaxNoItems() {
        return maxNoItems;
    }

    public void setMaxNoItems(int maxNoItems) {
        this.maxNoItems = maxNoItems;
        this.equippedItems = new EquippedItem[maxNoItems];
    }

    public int getCurrentItemNo() {
        return currentItemNo;
    }

    public void setCurrentItemNo(int currentItemNo) {
        this.currentItemNo = currentItemNo;
    }

    public EquippedItem[] getEquippedItems() {
        return equippedItems;
    }

    public void setEquippedItems(EquippedItem[] equippedItems) {
        this.equippedItems = equippedItems;
    }

    public EquippedItem getUnarmedItem() {
        return unarmedItem;
    }

    public void setUnarmedItem(EquippedItem unarmedItem) {
        this.unarmedItem = unarmedItem;
    }
}
