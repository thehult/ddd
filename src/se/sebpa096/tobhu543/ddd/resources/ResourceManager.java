package se.sebpa096.tobhu543.ddd.resources;

import java.util.HashMap;

/**
 * The main Resource class, which all specific Resource classes inherits from.
 */
public class ResourceManager<E> {
    protected HashMap<String, E> resources;

    public ResourceManager() {
        resources = new HashMap<String, E>();
    }

    public E getResource(String key) {
        return resources.get(key);
    }

}
