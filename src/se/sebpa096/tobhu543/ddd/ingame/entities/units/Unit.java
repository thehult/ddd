package se.sebpa096.tobhu543.ddd.ingame.entities.units;

import org.newdawn.slick.GameContainer;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.MovingEntity;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EUnarmed;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JavaDoc")
public class Unit extends MovingEntity {
    private int maxNoItems = 1;
    private EquippedItem[] equippedItems = null;
    private int currentItemNo = 0;
    private EquippedItem unarmedItem;

    private List<IUnitListener> unitListeners = new ArrayList<IUnitListener>();

    private int randomHealthMin = 10;
    private int randomHealthMax = 100;

    private int maxHealth=100;
    private int health=100;

    @SuppressWarnings("UnusedDeclaration") public static final double STANDARD_DROP_CHANCE = 0.1;

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
        for(int i=unitListeners.size() - 1;i>=0;i--) {
            unitListeners.get(i).unitChangedItems(equippedItems);
        }
    }

    public void cycleCurrentItem(int steps){
	currentItemNo += steps;
        if(currentItemNo < 0)
            currentItemNo = maxNoItems - 1;
        if(currentItemNo >= maxNoItems)
            currentItemNo = 0;
        for(int i=unitListeners.size() - 1;i>=0;i--) {
            unitListeners.get(i).unitChangedCurrentItem(currentItemNo);
        }
    }

    public boolean hasEquippedItem() {
	return equippedItems[currentItemNo] != null;
    }

    public void useItem(){
	if(!hasEquippedItem()){
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
        for(int i=unitListeners.size() - 1;i>=0;i--) {
            unitListeners.get(i).unitChangedItems(equippedItems);
        }
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

    @SuppressWarnings("UnusedDeclaration") public void setCurrentItemNo(int currentItemNo) {
        this.currentItemNo = currentItemNo;
        for(int i=unitListeners.size() - 1;i>=0;i--) {
            unitListeners.get(i).unitChangedCurrentItem(currentItemNo);
        }
    }

    public EquippedItem[] getEquippedItems() {
        return equippedItems;
    }

    @SuppressWarnings("UnusedDeclaration") public void setEquippedItems(EquippedItem[] equippedItems) {
        this.equippedItems = equippedItems;
        for(int i=unitListeners.size() - 1;i>=0;i--) {
            unitListeners.get(i).unitChangedItems(this.equippedItems);
        }
    }

    @Override public void getHit(final int incoming, final Entity attacker) {
	super.getHit(incoming, attacker);
	setHealth(health - incoming);
	if(health <= 0){
	    die();
	}
    }

    public void die(){
        if(this.equippedItems[0] != null)
            this.dropItem(0);
	setCurrentRoom(null);
    }

    @SuppressWarnings("UnusedDeclaration") public EquippedItem getUnarmedItem() {
        return unarmedItem;
    }

    @SuppressWarnings("UnusedDeclaration") public void setUnarmedItem(EquippedItem unarmedItem) {
        this.unarmedItem = unarmedItem;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        for(int i=unitListeners.size() - 1;i>=0;i--) {
            unitListeners.get(i).unitHealthChanged(health);
        }
    }

    public void addUnitListener(IUnitListener listener) {
        unitListeners.add(listener);
    }

    @SuppressWarnings("UnusedDeclaration") public void removeUnitListener(IUnitListener listener) {
        unitListeners.remove(listener);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getRandomHealthMax() {
        return randomHealthMax;
    }

    public void setRandomHealthMax(int randomHealthMax) {
        this.randomHealthMax = randomHealthMax;
    }

    public int getRandomHealthMin() {
        return randomHealthMin;
    }

    public void setRandomHealthMin(int randomHealthMin) {
        this.randomHealthMin = randomHealthMin;
    }
}
