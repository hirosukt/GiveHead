package hirosuke.givehead;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

class Info {
    public String name;
    public String id;
}

public class CommandGiveHead implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("head") || command.getName().equalsIgnoreCase("h")
            || command.getName().equalsIgnoreCase("atama")
            || command.getName().equalsIgnoreCase("kubi")
            || command.getName().equalsIgnoreCase("namakubi")
            || command.getName().equalsIgnoreCase("skull")
            || command.getName().equalsIgnoreCase("playerskull")) {

            Player player = null;
            String targetPlayerName;

            if(sender instanceof Player) {
                player = ((Player) sender).getPlayer();
            }

            if(args.length == 0) {
                targetPlayerName = player.getName();
            } else {
                targetPlayerName = args[0];
            }

            try {
                ItemStack item = SkullCreator.itemFromName(targetPlayerName);

                player.getInventory().addItem(item);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return true;
        }
        return false;
    }
}
