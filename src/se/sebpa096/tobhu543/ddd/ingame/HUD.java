package se.sebpa096.tobhu543.ddd.ingame;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.Game;
import se.sebpa096.tobhu543.ddd.ingame.entities.Entity;
import se.sebpa096.tobhu543.ddd.ingame.entities.items.EquippedItem;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.IUnitListener;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.Unit;
import se.sebpa096.tobhu543.ddd.ingame.entities.units.player.Player;
import se.sebpa096.tobhu543.ddd.resources.FontResources;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.HUDResources;


@SuppressWarnings({ "UnusedParameters", "JavaDoc" })
public class HUD implements IUpdateListener, IUnitListener {

    private Image hudImage;
    private Image hudHealth;
    private Image hudRealHealth;
    private Image hudItem;
    private Player player;
    private Font font;

    private static final float HEALTH_START_X = 276.0f;
    private static final float HEALTH_START_Y = 575.0f;
    private static final float LEVEL_DISPLAY_X = 60.0f;
    private static final float LEVEL_DISPLAY_Y = 556.0f;
    private static final float HEALTH_HEIGHT = 18.0f;
    private static final float HEALTH_WIDTH = 248.0f;
    private static final float INVENTORY_X = 559.0f;
    private static final float INVENTORY_Y = 562.0f;
    private static final float INVENTORY_SLOT_MARGIN_WIDTH = 40.0f;
    private static final float INVENTORY_SLOT_WIDTH = 32.0f;

    private Image[] items;



    private float currentHealthWidth = HEALTH_WIDTH;
    private int currentItem = 0;



    public HUD(Player player) {
        this.player = player;
        this.hudImage = (Image)GlobalResources.getResource(GlobalResources.HUD_RESOURCES, HUDResources.HUD1);
        this.hudHealth = (Image)GlobalResources.getResource(GlobalResources.HUD_RESOURCES, HUDResources.HUD1_CUR_HEALTH);
        this.hudRealHealth = hudHealth;
        this.hudItem = (Image)GlobalResources.getResource(GlobalResources.HUD_RESOURCES, HUDResources.HUD1_CUR_ITEM);
        this.font = (Font)GlobalResources.getResource(GlobalResources.FONT_RESOURCES, FontResources.INGAME_FONT);
        items = new Image[player.getMaxNoItems()];
        player.addUnitListener(this);

    }

    @Override
    public void gameUpdate(GameContainer gameContainer, int delta) {

    }

    //Suppress since GameContainer might be of use later on (it contains the window parameters and such)

    public void render(@SuppressWarnings("UnusedParameters") GameContainer gameContainer, Graphics graphics) {
        graphics.setFont(this.font);

        graphics.drawImage(hudImage, 0.0f, 0.0f);
        graphics.drawImage(hudRealHealth, HEALTH_START_X, HEALTH_START_Y);
        graphics.drawImage(hudItem, INVENTORY_X - 1 + currentItem * INVENTORY_SLOT_MARGIN_WIDTH, INVENTORY_Y - 1);
        for(int i = 0;i<items.length;i++) {
            if(items[i] != null) {
                graphics.drawImage(items[i], INVENTORY_X + i * INVENTORY_SLOT_MARGIN_WIDTH, INVENTORY_Y);
            }
        }
        graphics.drawString("Level " + Game.GAME_STATE.getLevelNumber(), LEVEL_DISPLAY_X, LEVEL_DISPLAY_Y);
    }


    //Suppress since they are empty at the moment (but needs to be there)

    @Override
    public void unitDied(Unit unit) {

    }

    @Override
    public void unitKilled(Unit unit) {

    }

    @Override
    public void unitChangedCurrentItem(int item) {
        currentItem = item;
    }

    @Override
    public void unitHealthChanged(int health) {
        if(health > 0) {
            currentHealthWidth = HEALTH_WIDTH * health / player.getMaxHealth();
            hudRealHealth = hudHealth.getScaledCopy((int)currentHealthWidth, (int)HEALTH_HEIGHT);
        }
    }

    @Override
    public void unitChangedItems(EquippedItem[] equippedItems) {
        items = new Image[player.getMaxNoItems()];
        for(int i=0;i<equippedItems.length;i++) {
            if(equippedItems[i] != null)
                items[i] = equippedItems[i].getDroppedTwin().getSprite().getSubImage(0, (int)-Entity.TILE_RENDER_OFFSET_Y, (int) Entity.TILE_WIDTH_IN_PX, (int) Entity.TILE_HEIGHT_IN_PX).getScaledCopy((int)INVENTORY_SLOT_WIDTH, (int)INVENTORY_SLOT_WIDTH);
        }
    }
}
