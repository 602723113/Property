package cc.zoyn.property.util;

import cc.zoyn.property.cache.PropertyCache;
import cc.zoyn.property.dto.Property;
import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * 通用工具类
 *
 * @author Zoyn
 * @since 2017-12-30
 */
public final class CommonUtils {

    /**
     * 获取在线玩家集合
     *
     * @return {@link List}
     */
    public static List<Player> getOnlinePlayers() {
        List<Player> playerList = Lists.newArrayList();

        for (World world : Bukkit.getWorlds()) {
            if (!world.getPlayers().isEmpty()) {
                playerList.addAll(world.getPlayers());
            }
        }
        return playerList;
    }

    public static void sendPlayerInformation(Player player) {
        Property property = PropertyCache.getProperty(player.getName());
        if (property == null) {
            PropertyCache.addProperty(player.getName(), new Property(player.getName()));
            property = PropertyCache.getProperty(player.getName());
        }
        player.sendMessage("§7§l§m==========§7§l[§f§lAsgard§7§l] §7信息面板§l§m==========");
        player.sendMessage("● §8信息: §7[ §f§l" + player.getName() + " §7] [ §eLV." + player.getLevel() + " §7]");
        player.sendMessage("● §8主手: §7[ " + (player.getItemInHand() == null || player.getItemInHand().getType().equals(Material.AIR) ? "空" : player.getItemInHand().getItemMeta().getDisplayName()) + " §7]");
        player.sendMessage("● §8头盔: §7[ " + (player.getEquipment().getHelmet() == null ? "空" : player.getEquipment().getHelmet().getItemMeta().getDisplayName()) + " §7]");
        player.sendMessage("● §8胸甲: §7[ " + (player.getEquipment().getChestplate() == null ? "空" : player.getEquipment().getChestplate().getItemMeta().getDisplayName()) + " §7]");
        player.sendMessage("● §8护腿: §7[ " + (player.getEquipment().getLeggings() == null ? "空" : player.getEquipment().getLeggings().getItemMeta().getDisplayName()) + " §7]");
        player.sendMessage("● §8靴子: §7[ " + (player.getEquipment().getBoots() == null ? "空" : player.getEquipment().getBoots().getItemMeta().getDisplayName()) + " §7]");
        player.sendMessage("§7§l§m========================================");
        player.sendMessage(property.toString());
    }

}
