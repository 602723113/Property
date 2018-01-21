package cc.zoyn.property.command.subcommand;

import cc.zoyn.property.command.SubCommand;
import cc.zoyn.property.util.CommonUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zoyn
 * @since 2018-01-20
 */
public class CheckCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("你必须是一名玩家!");
            return;
        }
        Player player = (Player) sender;
        CommonUtils.sendPlayerInformation(player);
    }
}
