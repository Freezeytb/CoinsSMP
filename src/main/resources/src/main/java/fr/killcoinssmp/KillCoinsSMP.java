package fr.killcoinssmp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class KillCoinsSMP extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("KillCoinsSMP est activé !");
    }

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {
        sender.sendMessage("Tu as 0 KillCoins.");
        return true;
    }
}
