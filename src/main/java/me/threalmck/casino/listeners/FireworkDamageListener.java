package me.threalmck.casino.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FireworkDamageListener implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType().equals(EntityType.FIREWORK)) event.setCancelled(true);
    }
}
