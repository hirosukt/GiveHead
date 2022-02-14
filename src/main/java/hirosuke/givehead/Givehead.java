package hirosuke.givehead;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Givehead extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getCommand("head").setExecutor(new CommandGiveHead());
        getLogger().info("plugin has loaded.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("plugin has unloaded.");
    }
}
