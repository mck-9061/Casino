package me.threalmck.casino.listeners;

import me.threalmck.casino.Main;
import me.threalmck.casino.inventories.RouletteInventory;
import me.threalmck.casino.utils.InventoryUtils;
import me.threalmck.casino.utils.Utils;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.threalmck.casino.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RouletteButtonListener implements Listener {
    @EventHandler
    public void onButtonPush(PlayerInteractEvent event) {
        List<Material> buttons = new ArrayList<>();
        buttons.add(Material.BIRCH_BUTTON);
        buttons.add(Material.ACACIA_BUTTON);
        buttons.add(Material.DARK_OAK_BUTTON);
        buttons.add(Material.JUNGLE_BUTTON);
        buttons.add(Material.OAK_BUTTON);
        buttons.add(Material.SPRUCE_BUTTON);
        buttons.add(Material.STONE_BUTTON);

        try {
            if (buttons.contains(event.getClickedBlock().getType())) {
                List<String> locStringList = Main.getCustomConfig().getStringList("Locations");
                boolean isButton = false;
                Block b = event.getClickedBlock();
                Location l = b.getLocation();
                for (String s : locStringList) {
                    String[] strings = s.split(":");
                    String world = strings[0];
                    String x = strings[1];
                    String y = strings[2];
                    String z = strings[3];

                    if (l.getWorld().getName().equals(world) && String.valueOf(l.getBlockX()).equals(x) && String.valueOf(l.getBlockY()).equals(y) && String.valueOf(l.getBlockZ()).equals(z))
                        isButton = true;
                }
                if (isButton) {
                    //Button press; Open roulette

                    //Get bet
                    //                AtomicInteger bet = new AtomicInteger();
                    //                new AnvilGUI.Builder()
                    //                        .onClose(player -> {                      //called when the inventory is closing
                    //                        })
                    //                        .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                    //                            event.getPlayer().closeInventory();
                    //                            try {
                    //                                System.out.println(text);
                    //                                if (text.equalsIgnoreCase("")) bet.set(-1);
                    //                                int i = Integer.parseInt(text);
                    //                                double balance = Main.econ.getBalance(Bukkit.getOfflinePlayer(event.getPlayer().getUniqueId()));
                    //                                if (i < 1) bet.set(-1);
                    //                                else if (i < balance) bet.set(-1);
                    //                                else bet.set(i);
                    //                            } catch (Exception e) {
                    //                                bet.set(-1);
                    //                                e.printStackTrace();
                    //                            }
                    //
                    //                            if (bet.get() == -1) event.getPlayer().sendMessage("Invalid! Bet lower than 1, invalid bet format, or you don't have enough money to bet that much.");
                    //                            else {

                    RouletteInventory rouletteInventory = new RouletteInventory(event.getPlayer());
                    Inventory inv = rouletteInventory.get();

                    Main.currentRouletteMap.put(event.getPlayer(), rouletteInventory);

                    event.getPlayer().openInventory(inv);
                    //                            }
                    //
                    //
                    //
                    //                            return AnvilGUI.Response.text(text);
                    //                        })
                    //                        .text("0")     //sets the text the GUI should start with
                    //                        .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                    //                        .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                    //                        .plugin(Main.instance)                 //set the plugin instance
                    //                        .open(event.getPlayer());
                }
            }
        } catch (Exception ignored) {}
    }
}
