package cc.zoyn.property.runnable;

import cc.zoyn.property.cache.PropertyCache;
import cc.zoyn.property.dto.Property;
import cc.zoyn.property.util.CommonUtils;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static cc.zoyn.property.cache.PropertyCache.getDefaultProperty;
import static cc.zoyn.property.util.CommonUtils.getPlayerEquipmentProperty;
import static cc.zoyn.property.util.CommonUtils.sumProperty;

/**
 * @author Zoyn
 * @since 2018-01-22
 */
public class SyncDataRunnable extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : CommonUtils.getOnlinePlayers()) {
            Property property = getDefaultProperty();
            property = sumProperty(property, getPlayerEquipmentProperty(player));
            // 更新缓存
            PropertyCache.addProperty(player.getName(), property);
        }
    }
}
