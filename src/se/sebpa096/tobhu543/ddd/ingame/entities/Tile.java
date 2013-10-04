package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.TileResources;

public class Tile extends StaticEntity {
    public Tile() {
        super();
        sprite = (Image) GlobalResources.getResource(GlobalResources.TILE_RESOURCES, TileResources.CBBLE_FLOOR_1);
    }
}
