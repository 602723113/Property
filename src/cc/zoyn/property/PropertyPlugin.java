package cc.zoyn.property;

import cc.zoyn.property.command.CommandHandler;
import cc.zoyn.property.listener.AttackListener;
import cc.zoyn.property.listener.ExperienceListener;
import cc.zoyn.property.runnable.PropertyActionRunnable;
import cc.zoyn.property.runnable.SyncDataRunnable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 主类
 *
 * @author Zoyn
 * @since 2018-01-20
 */
public class PropertyPlugin extends JavaPlugin {

    private static PropertyPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        // 指令注册
        Bukkit.getPluginCommand("property").setExecutor(new CommandHandler());

        // 事件注册
        Bukkit.getPluginManager().registerEvents(new AttackListener(), this);
        Bukkit.getPluginManager().registerEvents(new ExperienceListener(), this);

        SyncDataRunnable syncDataRunnable = new SyncDataRunnable();
        PropertyActionRunnable propertyActionRunnable = new PropertyActionRunnable();

        syncDataRunnable.runTaskTimerAsynchronously(this, 0L, 2 * 30L);
        propertyActionRunnable.runTaskTimer(this, 20L, 3 * 20L);

    }

    public static PropertyPlugin getInstance() {
        return instance;
    }
}
