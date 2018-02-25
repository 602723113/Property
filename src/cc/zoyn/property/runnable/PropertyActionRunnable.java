package cc.zoyn.property.runnable;

import cc.zoyn.property.cache.PropertyCache;
import cc.zoyn.property.dto.Property;
import cc.zoyn.property.util.CommonUtils;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author Zoyn
 * @since 2018-01-21
 */
public class PropertyActionRunnable extends BukkitRunnable {


    @Override
    public void run() {
        for (Player player : CommonUtils.getOnlinePlayers()) {
            Property property = PropertyCache.getProperty(player.getName());
            player.setMaxHealth(20 + property.getHealth());
        }
    }
}

