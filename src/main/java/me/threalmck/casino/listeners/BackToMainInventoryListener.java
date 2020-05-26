package me.threalmck.casino.listeners;

import me.threalmck.casino.Main;
import me.threalmck.casino.inventories.RouletteInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class BackToMainInventoryListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player && !Main.currentRouletteMap.containsKey((Player) event.getWhoClicked())) {
            if (event.getView().getTitle().equals("Rolling...")) {
                if (event.getSlot() == 5) {
                    Player p = (Player) event.getWhoClicked();

                    RouletteInventory rouletteInventory = new RouletteInventory(p);
                    Inventory inv = rouletteInventory.get();

                    Main.currentRouletteMap.put(p, rouletteInventory);

                    p.openInventory(inv);
                }
            }
        }
    }
}
