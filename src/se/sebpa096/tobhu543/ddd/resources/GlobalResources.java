package se.sebpa096.tobhu543.ddd.resources;

import java.util.HashMap;

public class GlobalResources {
    private static HashMap<String, ResourceManager> resourceManagers;

    static {
        resourceManagers = new HashMap<String, ResourceManager>();
        addResourceManager("buttonImage", new ButtonImageResources());
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
