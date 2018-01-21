package cc.zoyn.property.command.subcommand;

import cc.zoyn.property.command.SubCommand;
import org.bukkit.command.CommandSender;

public class HelpCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("§e=-=-=-=-=-= §8[§6属性 §f§l| §6Property§8] §e=-=-=-=-=-=");
        sender.sendMessage(" §e/pp check §6查看自身的属性");
    }
}
