package me.threalmck.casino.listeners;

import me.threalmck.casino.Main;
import me.threalmck.casino.entities.SlotsIcon;
import me.threalmck.casino.inventories.SlotsInventory;
import me.threalmck.casino.utils.InventoryUtils;
import me.threalmck.casino.utils.Utils;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SlotsButtonListener implements Listener {
    @EventHandler
    public void onButtonPush(PlayerInteractEvent event) {
        List<Material> buttons = new ArrayList<>();
        buttons.add(Material.LEVER);

        try {
            if (buttons.contains(Objects.requireNonNull(event.getClickedBlock()).getType())) {
                List<String> locStringList = Main.getCustomConfig().getStringList("SlotsLocations");
                boolean isButton = false;
                Block b = event.getClickedBlock();
                Location l = b.getLocation();
                for (String s : locStringList) {
                    String[] strings = s.split(":");
                    String world = strings[0];
                    String x = strings[1];
                    String y = strings[2];
                    String z = strings[3];

                    if (Objects.requireNonNull(l.getWorld()).getName().equals(world) && String.valueOf(l.getBlockX()).equals(x) && String.valueOf(l.getBlockY()).equals(y) && String.valueOf(l.getBlockZ()).equals(z))
                        isButton = true;
                }
                if (isButton) {
                    event.setCancelled(true);
                    //Button press; Open roulette
                    Player p = event.getPlayer();

                    //Get bet
                    AtomicInteger bet = new AtomicInteger();
                    new AnvilGUI.Builder()
                            .onClose(player -> {                      //called when the inventory is closing
                            })
                            .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                event.getPlayer().closeInventory();
                                try {
                                    System.out.println(text);
                                    if (text.equalsIgnoreCase("")) bet.set(-1);
                                    int i = Integer.parseInt(text);
                                    double balance = Main.econ.getBalance(Bukkit.getOfflinePlayer(event.getPlayer().getUniqueId()));
                                    if (i < 1) bet.set(-1);
                                    else if (i > balance) bet.set(-1);
                                    else bet.set(i);
                                } catch (Exception e) {
                                    bet.set(-1);
                                    e.printStackTrace();
                                }

                                if (bet.get() == -1)
                                    event.getPlayer().sendMessage("Invalid! Bet lower than 1, invalid bet format, or you don't have enough money to bet that much.");
                                else {

                                    //Initialize: Generate 3 random lists from list of slot icons
                                    List<ItemStack> slot1 = Arrays.asList(SlotsIcon.A, SlotsIcon.B, SlotsIcon.C, SlotsIcon.CHERRY, SlotsIcon.GRAPES, SlotsIcon.LEMON, SlotsIcon.LIME, SlotsIcon.ORANGE, SlotsIcon.SEVEN);
                                    List<ItemStack> slot2 = Arrays.asList(SlotsIcon.A, SlotsIcon.B, SlotsIcon.C, SlotsIcon.CHERRY, SlotsIcon.GRAPES, SlotsIcon.LEMON, SlotsIcon.LIME, SlotsIcon.ORANGE, SlotsIcon.SEVEN);
                                    List<ItemStack> slot3 = Arrays.asList(SlotsIcon.A, SlotsIcon.B, SlotsIcon.C, SlotsIcon.CHERRY, SlotsIcon.GRAPES, SlotsIcon.LEMON, SlotsIcon.LIME, SlotsIcon.ORANGE, SlotsIcon.SEVEN);

                                    Collections.shuffle(slot1);
                                    Collections.shuffle(slot2);
                                    Collections.shuffle(slot3);

                                    SlotsInventory slotsInventory = new SlotsInventory(slot1, slot2, slot3, bet.get(), p);

                                    Main.currentSlotsMap.put(p, slotsInventory);

                                    //Create inventory
                                    Inventory inv = slotsInventory.get();

                                    p.openInventory(inv);


                                }


                                return AnvilGUI.Response.text(text);
                            })
                            .text("0")     //sets the text the GUI should start with
                            .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                            .title("Enter initial bet.")              //set the title of the GUI (only works in 1.14+)
                            .plugin(Main.instance)                 //set the plugin instance
                            .open(event.getPlayer());
                }
            }
        } catch (Exception ignored) {}
    }
}
