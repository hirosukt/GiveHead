package hirosuke.givehead;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class CommandGiveHead implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("head") || command.getName().equalsIgnoreCase("h")) {
            Player player = null;
            Player targetPlayer = Bukkit.getPlayer(args[0]);

            if(sender instanceof Player) {
                player = ((Player) sender).getPlayer();
            }

            if(args.length == 0) {
                targetPlayer = player;
            }

            ItemStack item = new ItemStack(Material.SKULL);
            SkullMeta skull = (SkullMeta) item.getItemMeta();

            skull.setDisplayName(player.getName());
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(targetPlayer.getName() + "'s Head");
            skull.setLore(lore);
            skull.setOwner(targetPlayer.getName());
            item.setItemMeta(skull);

            player.getInventory().addItem(item);
        }
        return false;
    }
}
