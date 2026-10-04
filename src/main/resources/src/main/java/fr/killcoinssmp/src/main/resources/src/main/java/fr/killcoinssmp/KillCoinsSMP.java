package fr.killcoinssmp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KillCoinsSMP extends JavaPlugin implements Listener {

    private final Map<UUID, Integer> coins = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        getCommand("killcoins").setExecutor((sender, command, label, args) -> {
            if (!(sender instanceof Player player)) {
                sender.sendMessage("Cette commande doit être utilisée en jeu.");
                return true;
            }

            int balance = coins.getOrDefault(player.getUniqueId(), 0);
            player.sendMessage("Tu as " + balance + " KillCoins.");
            return true;
        });
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player killer = event.getEntity().getKiller();

        if (killer != null) {
            int balance = coins.getOrDefault(killer.getUniqueId(), 0) + 1;
            coins.put(killer.getUniqueId(), balance);
            killer.sendMessage("Tu as gagné 1 KillCoin ! Total : " + balance);
        }
    }
}
