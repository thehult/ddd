package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.ingame.entities.Tile;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.DroppedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.IUnitListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.HUDResources;


public class HUD implements IUpdateListener, IUnitListener {

    private Image hudImage;
    private Image hudHealth;
    private Image hudRealHealth;
    private Image hudItem;
    private Player player;

    private static final float HEALTH_START_X = 276.0f;
    private static final float HEALTH_START_Y = 575.0f;
    private static final float HEALTH_HEIGHT = 18.0f;
    private static final float HEALTH_WIDTH = 248.0f;
    private static final float INVENTORY_X = 559.0f;
    private static final float INVENTORY_Y = 562.0f;
    private static final float INVENTORY_SLOT_MARGIN_WIDTH = 40.0f;
    private static final float INVENTORY_SLOT_WIDTH = 32.0f;

    private Image[] items;



    private float currentHealthWidth = 248.0f;
    private int currentItem = 0;



    public HUD(Player player) {
        this.player = player;
        this.hudImage = (Image)GlobalResources.getResource(GlobalResources.HUD_RESOURCES, HUDResources.HUD1);
        this.hudHealth = (Image)GlobalResources.getResource(GlobalResources.HUD_RESOURCES, HUDResources.HUD1_CUR_HEALTH);
        this.hudRealHealth = hudHealth;
        this.hudItem = (Image)GlobalResources.getResource(GlobalResources.HUD_RESOURCES, HUDResources.HUD1_CUR_ITEM);
        items = new Image[player.getMaxNoItems()];
        player.addUnitListener(this);

    }

    @Override
    public void gameUpdate(GameContainer gameContainer, int delta) {

    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        graphics.drawImage(hudImage, 0.0f, 0.0f);
        graphics.drawImage(hudRealHealth, HEALTH_START_X, HEALTH_START_Y);
        graphics.drawImage(hudItem, INVENTORY_X - 1 + currentItem * INVENTORY_SLOT_MARGIN_WIDTH, INVENTORY_Y - 1);
        for(int i = 0;i<items.length;i++) {
            if(items[i] != null) {
                graphics.drawImage(items[i], INVENTORY_X + i * INVENTORY_SLOT_MARGIN_WIDTH, INVENTORY_Y);
            }
        }
    }


    @Override
    public void unitDied() {

    }

    @Override
    public void unitKilled() {

    }

    @Override
    public void unitChangedCurrentItem(int item) {
        currentItem = item;
    }

    @Override
    public void unitHealthChanged(int health) {
        if(health > 0) {
            currentHealthWidth = HEALTH_WIDTH * (float)health/(float)player.getMaxHealth();
            hudRealHealth = hudHealth.getScaledCopy((int)currentHealthWidth, (int)HEALTH_HEIGHT);
        }
    }

    @Override
    public void unitChangedItems(EquippedItem[] equippedItems) {
        items = new Image[player.getMaxNoItems()];
        for(int i=0;i<equippedItems.length;i++) {
            if(equippedItems[i] != null)
                items[i] = equippedItems[i].getDroppedTwin().getSprite().getSubImage(0, (int)-Tile.TILE_RENDER_OFFSET_Y, (int)Tile.TILE_WIDTH_IN_PX, (int)Tile.TILE_HEIGHT_IN_PX).getScaledCopy((int)INVENTORY_SLOT_WIDTH, (int)INVENTORY_SLOT_WIDTH);
        }
    }
}
