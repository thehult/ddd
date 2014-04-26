package se.sebpa096.tobhu543.ddd.ingame.entities;

import org.newdawn.slick.Image;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.resources.TileResources;

/**
 * A Tile is the what you see as floor. No more than basic construction implemented yet. Plans: randomize tile enchantments to make them more unique.
 */
public class Tile extends StaticEntity {
    public Tile() {
	sprite = (Image) GlobalResources.getResource(GlobalResources.TILE_RESOURCES, TileResources.CBBLE_FLOOR_1);
    }
}
