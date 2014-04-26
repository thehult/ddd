package se.sebpa096.tobhu543.ddd.resources;

import java.util.HashMap;

//I have seriously NO IDEA how to solve this raw type thingy...

/**
 * This static class contains all kind of resources used in game. This to allow for easy resource loading inside other classes.
 */
@SuppressWarnings({ "rawtypes" })
public final class GlobalResources {

    public static final String BUTTON_RESOURCES = "buttons";
    public static final String FONT_RESOURCES = "font";
    public static final String BACKGROUND_RESOURCES = "backgrounds";
    public static final String TILE_RESOURCES = "tiles";
    public static final String UNIT_RESOURCES = "units";
    public static final String HUD_RESOURCES = "huds";
    public static final String ITEM_RESOURCES = "items";


    private static HashMap<String, ResourceManager> resourceManagers = null;

    private GlobalResources() {}

    public static void init() {
        resourceManagers = new HashMap<String, ResourceManager>();
        addResourceManager(BUTTON_RESOURCES, new ButtonImageResources());
        addResourceManager(FONT_RESOURCES, new FontResources());
        addResourceManager(BACKGROUND_RESOURCES, new BackgroundResources());
        addResourceManager(TILE_RESOURCES, new TileResources());
        addResourceManager(UNIT_RESOURCES, new UnitResources());
        addResourceManager(HUD_RESOURCES, new HUDResources());
        addResourceManager(ITEM_RESOURCES, new ItemResources());
    }

    public static void addResourceManager(String name, ResourceManager resourceManager) {
        resourceManagers.put(name, resourceManager);
    }

    public static ResourceManager getResourceManager(String name) {
        return resourceManagers.get(name);
    }

    public static Object getResource(String resourceManagerName, String resourceName) {
        return getResourceManager(resourceManagerName).getResource(resourceName);
    }
}
