package dev.proflix.deluxedeath.listener;

import dev.proflix.deluxedeath.DeluxeDeath;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    private final DeluxeDeath plugin;

    public PlayerDeathListener(DeluxeDeath plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(final PlayerDeathEvent event) {
        // Cancel Bukkit
        event.setDeathMessage(null);

    }
}
