package cc.zoyn.property.listener;

import cc.zoyn.property.cache.PropertyCache;
import cc.zoyn.property.dto.Property;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

/**
 * @author Zoyn
 * @since 2018-02-25
 */
public class HealthRecoverListener implements Listener {

    @EventHandler
    public void onRecover(EntityRegainHealthEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            Property property = PropertyCache.getProperty(entity.getName());
            event.setAmount(event.getAmount() + property.getHealthScala());
        }
    }

}
