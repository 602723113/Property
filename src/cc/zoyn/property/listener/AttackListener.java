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
                double dodge = targetProperty.getDodge();
                double odds = dodge - hit;
                if (odds > 0) { // 当闪避-命中大于0时表示 该玩家还有点闪避可以进行判断, 没有则进行伤害判断
                    // 如果随机数是在闪避几率内部的则进行返回
                    double random = RANDOM.nextInt(101);
//                    System.out.println("随机数 " + random);
                    if (random < odds) {
                        target.sendMessage("§7你闪避了本次攻击!");
                        player.sendMessage("§7对方闪避了你的攻击!");
                        event.setCancelled(true);
                        return;
                    }
                }

//                System.out.println("Defense " + targetProperty.getPhysicalDefense());
//                System.out.println("Attack " + property.getPhysicalAttack());
                /* 伤害判定 */
                // 小于0说明攻击比防御高, 进行累加操作
                if (targetProperty.getPhysicalDefense() - property.getPhysicalAttack() < 0) {
                    damage += property.getPhysicalAttack() - targetProperty.getPhysicalDefense();
                }

                /* 属性判断
                 * 火 木 水 暗 光
                 * */
                if (targetProperty.getFireDefense() - property.getFireAttack() < 0) {
                    damage += property.getFireAttack() - targetProperty.getFireDefense();
                }
                if (targetProperty.getWoodDefense() - property.getWoodAttack() < 0) {
                    damage += property.getWoodAttack() - targetProperty.getWoodDefense();
                }
                if (targetProperty.getWaterDefense() - property.getWaterAttack() < 0) {
                    damage += property.getWaterAttack() - targetProperty.getWaterDefense();
                }
                if (targetProperty.getDarkDefense() - property.getDarkAttack() < 0) {
                    damage += property.getDarkAttack() - targetProperty.getDarkDefense();
                }
                if (targetProperty.getLightDefense() - property.getLightAttack() < 0) {
                    damage += property.getLightAttack() - targetProperty.getLightDefense();
                }

                /* 吸血 */
                double health = player.getHealth();
                double maxHealth = player.getMaxHealth();
                if (maxHealth != health) {
                    if (health + property.getSuckBlood() < maxHealth) {
                        player.setHealth(health + property.getSuckBlood());
                    } else { // 当吸血后的血量大于最大血量时则设定为最大血量
                        player.setHealth(maxHealth);
                    }
                }

                /* 真实伤害 */
                damage += property.getRealAttack() <= 0 ? 0 : property.getRealAttack();
            } else {
                damage += property.getPhysicalAttack();
            }
//            System.out.println("damage" + damage);
            event.setDamage(damage);
        }
    }

}
