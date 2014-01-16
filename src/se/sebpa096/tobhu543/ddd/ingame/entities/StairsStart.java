package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.TileResources;

@SuppressWarnings("JavaDoc")
public class StairsStart extends StaticEntity {

    public StairsStart() {
        this.setSprite((Image)GlobalResources.getResource(GlobalResources.TILE_RESOURCES, TileResources.STAIRS_START));
    }


}
