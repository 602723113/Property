package cc.zoyn.property.cache;

import cc.zoyn.property.dto.Property;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author Zoyn
 * @since 2018-01-20
 */
public class PropertyCache {

    private static Map<String, Property> propertyMap = Maps.newHashMap();

    public static Map<String, Property> getPropertyMap() {
        return propertyMap;
    }

    public static void addProperty(String playerName, Property property) {
        if (playerName == null || playerName.isEmpty() || playerName.equalsIgnoreCase(" ") || property == null) {
            return;
        }
        propertyMap.put(playerName, property);
    }

    public static Property getProperty(String playerName) {
        if (propertyMap.containsKey(playerName)) {
            return propertyMap.get(playerName);
        } else {
            addProperty(playerName, new Property(playerName));
            return getProperty(playerName);
        }
    }

}
