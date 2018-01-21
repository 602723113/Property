package cc.zoyn.property.listener;

import cc.zoyn.property.cache.PropertyCache;
import cc.zoyn.property.dto.Property;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

/**
 * 经验加成
 *
 * @author Zoyn
 * @since 2018-01-20
 */
public class ExperienceListener implements Listener {

    @EventHandler
    public void onChange(PlayerExpChangeEvent event) {
        Player player = event.getPlayer();
        Property property = PropertyCache.getProperty(player.getName());

        double expPlus = property.getExpPlus();
        expPlus = expPlus / 100;
        event.setAmount((int) (event.getAmount() + event.getAmount() * expPlus));
    }

}
