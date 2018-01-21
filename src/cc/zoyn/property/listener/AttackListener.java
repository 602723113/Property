package cc.zoyn.property.listener;

import cc.zoyn.property.cache.PropertyCache;
import cc.zoyn.property.dto.Property;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

/**
 * @author Zoyn
 * @since 2018-01-20
 */
public class AttackListener implements Listener {

    private static final Random RANDOM = new Random();

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            Property property = PropertyCache.getProperty(player.getName());
            double damage = event.getDamage();

            if (event.getEntity() instanceof Player) {
                Player target = (Player) event.getEntity();
                Property targetProperty = PropertyCache.getProperty(target.getName());

                /* 闪避判定 */
                double hit = property.getHit();
                double dodge = property.getDodge();
                double odds = dodge - hit;
                // 如果随机数是在闪避几率内部的则进行返回
                if (RANDOM.nextInt(101) < odds) {
                    target.sendMessage("§7你闪避了本次攻击!");
                    player.sendMessage("§7对方闪避了你的攻击!");
                    event.setCancelled(true);
                    return;
                }

                /* 伤害判定 */
                // 大于0说明防御比攻击高
                if (targetProperty.getPhysicalDefense() - property.getPhysicalAttack() > 0) {
                    event.setCancelled(true);
                    return;
                } else {
                    damage += property.getPhysicalAttack() - targetProperty.getPhysicalDefense();
                }
            } else {
                damage += property.getPhysicalAttack();
            }
            event.setDamage(damage);
        }
    }

}
