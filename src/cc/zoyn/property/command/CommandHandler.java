package cc.zoyn.property.command;

import cc.zoyn.property.command.subcommand.CheckCommand;
import cc.zoyn.property.command.subcommand.HelpCommand;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Map;

public class CommandHandler implements CommandExecutor {

    private static Map<String, SubCommand> commandMap = Maps.newHashMap();

    /**
     * Initialize all sub commands
     */
    public CommandHandler() {
        registerCommand("help", new HelpCommand());
        registerCommand("check", new CheckCommand());
    }

    private void registerCommand(String commandName, SubCommand subCommand) {
        if (commandMap.containsKey(commandName)) {
            Bukkit.getLogger().warning("duplicate add command!");
        }
        commandMap.put(commandName, subCommand);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            commandMap.get("help").execute(sender, args);
            return true;
        }
        if (!commandMap.containsKey(args[0])) {
            sender.sendMessage("§c未知指令!");
            return true;
        }
        // args[0] ---> SubCommand name
        SubCommand subCommand = commandMap.get(args[0]);
        subCommand.execute(sender, args);
        return true;
    }
}
