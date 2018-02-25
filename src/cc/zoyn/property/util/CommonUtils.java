package cc.zoyn.property.util;

import cc.zoyn.property.cache.PropertyCache;
import cc.zoyn.property.dto.Property;
import cc.zoyn.property.util.reflect.ReflectionUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.Validate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

/**
 * 通用工具类
 *
 * @author Zoyn
 * @since 2017-12-30
 */
public final class CommonUtils {

    /**
     * 反射获取玩家手中的物品
     * <br />
     * use reflect to get player hand item
     *
     * @param player 玩家
     * @return {@link ItemStack}
     */
    public static ItemStack getItemInMainHand(Player player) {
        Validate.notNull(player);

        if (!player.isOnline()) {
            return null;
        }
        boolean hasMethod = ReflectionUtils.hasMethod(NMSUtils.getOBCClass("inventory.CraftInventoryPlayer"), "getItemInMainHand");
        if (hasMethod) {
            return player.getInventory().getItemInMainHand();
        } else {
            return player.getItemInHand();
        }
    }

    /**
     * 获取在线玩家集合
     *
     * @return {@link List}
     */
    public static List<Player> getOnlinePlayers() {
        List<Player> playerList = Lists.newArrayList();
        for (World world : Bukkit.getWorlds()) {
            playerList.addAll(world.getPlayers());
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

    public static Property getItemProperty(ItemStack itemStack) {
        Property property = new Property(null);
        if (itemStack != null && itemStack.hasItemMeta() && itemStack.getItemMeta().hasLore()) {
            List<String> lore = itemStack.getItemMeta().getLore();
            for (String aLore : lore) {
                if (aLore.contains("血量恢复")) {
                    property.setHealthScala(property.getHealthScala() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("血量")) {
                    property.setHealth(property.getHealth() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1]).replaceAll("%", "")));
                } else if (aLore.contains("物理攻击")) {
                    property.setPhysicalAttack(property.getPhysicalAttack() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("物理防御")) {
                    property.setPhysicalDefense(property.getPhysicalDefense() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("火系攻击")) {
                    property.setFireAttack(property.getFireAttack() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("火系防御")) {
                    property.setFireDefense(property.getFireDefense() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("木系攻击")) {
                    property.setWoodAttack(property.getWoodAttack() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("木系防御")) {
                    property.setWoodDefense(property.getWoodDefense() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("水系攻击")) {
                    property.setWaterAttack(property.getWaterAttack() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("水系防御")) {
                    property.setWaterDefense(property.getWaterDefense() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("光系攻击")) {
                    property.setLightAttack(property.getLightAttack() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("光系防御")) {
                    property.setLightDefense(property.getLightDefense() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("暗系攻击")) {
                    property.setDarkAttack(property.getDarkAttack() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("暗系防御")) {
                    property.setDarkDefense(property.getDarkDefense() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("吸血")) {
                    property.setSuckBlood(property.getSuckBlood() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("真实伤害")) {
                    property.setRealAttack(property.getRealAttack() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1])));
                } else if (aLore.contains("闪避几率")) {
                    property.setDodge(property.getDodge() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1]).replaceAll("%", "")));
                } else if (aLore.contains("命中几率")) {
                    property.setHit(property.getHit() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1]).replaceAll("%", "")));
                } else if (aLore.contains("经验加成")) {
                    property.setExpPlus(property.getExpPlus() + Double.valueOf(ChatColor.stripColor(aLore.split(":")[1]).replaceAll("%", "")));
                }
            }
        }
        return property;
    }

    public static Property getPlayerEquipmentProperty(Player player) {
        if (player == null || !player.isOnline()) {
            return null;
        }
        Property property = new Property(null);

        // player equipments
        List<ItemStack> itemStacks = Arrays.asList(player.getEquipment().getArmorContents());
        // prevent java.lang.UnsupportedOperationException
        List<ItemStack> listTemp = Lists.newArrayList(itemStacks);
        ItemStack itemInHand = getItemInMainHand(player);
        if (itemInHand != null && !itemInHand.getType().equals(Material.AIR)) {
            listTemp.add(itemInHand);
        }

        for (ItemStack itemStack : listTemp) {
            property = sumProperty(property, getItemProperty(itemStack));
        }

        return property;
    }

    public static Property sumProperty(Property... properties) {
        Property property = new Property(null);
        for (Property propertyTemp : properties) {
            property.setPhysicalAttack(property.getPhysicalAttack() + propertyTemp.getPhysicalAttack());
            property.setPhysicalDefense(property.getPhysicalDefense() + propertyTemp.getPhysicalDefense());
            property.setFireAttack(property.getFireAttack() + propertyTemp.getFireAttack());
            property.setFireDefense(property.getFireDefense() + propertyTemp.getFireDefense());
            property.setWoodAttack(property.getWoodAttack() + propertyTemp.getWoodAttack());
            property.setWoodDefense(property.getWoodDefense() + propertyTemp.getWoodDefense());
            property.setWaterAttack(property.getWaterAttack() + propertyTemp.getWaterAttack());
            property.setWaterDefense(property.getWaterDefense() + propertyTemp.getWaterDefense());
            property.setLightAttack(property.getLightAttack() + propertyTemp.getLightAttack());
            property.setLightDefense(property.getLightDefense() + propertyTemp.getLightDefense());
            property.setDarkAttack(property.getDarkAttack() + propertyTemp.getDarkAttack());
            property.setDarkDefense(property.getDarkDefense() + propertyTemp.getDarkDefense());
            property.setHealth(property.getHealth() + propertyTemp.getHealth());
            property.setHealthScala(property.getHealthScala() + propertyTemp.getHealthScala());
            property.setSuckBlood(property.getSuckBlood() + propertyTemp.getSuckBlood());
            property.setRealAttack(property.getRealAttack() + propertyTemp.getRealAttack());
            property.setDodge(property.getDodge() + propertyTemp.getDodge());
            property.setHit(property.getHit() + propertyTemp.getHit());
            property.setExpPlus(property.getExpPlus() + propertyTemp.getExpPlus());
        }
        return property;
    }

}
