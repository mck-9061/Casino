package me.threalmck.casino.listeners;

import me.threalmck.casino.Main;
import me.threalmck.casino.entities.RouletteSlot;
import me.threalmck.casino.inventories.RouletteInventory;
import me.threalmck.casino.utils.InventoryUtils;
import me.threalmck.casino.utils.Utils;
import net.wesjd.anvilgui.AnvilGUI;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainRouletteInventoryListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player && Main.currentRouletteMap.containsKey((Player) event.getWhoClicked()) ) {
            if (event.getView().getTitle().equals("Rolling...")) event.setCancelled(true);
            if (event.getView().getTitle().equals("Roulette")) {
                event.setCancelled(true);
                if (event.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) return;
                else {
                    Player p = (Player) event.getWhoClicked();
                    int slot = event.getSlot();
                    switch (slot) {
                        case 1:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                .onClose(player -> {                      //called when the inventory is closing
                                })
                                .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                    int bet = anvilStuff(p, text);

                                    if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                    else {
                                        //Run success code
                                        RouletteInventory inv = Main.currentRouletteMap.get(p);
                                        inv.setBet3(bet);
                                        inv.fixTotalBet();
                                        Main.currentRouletteMap.put(p, inv);
                                        p.openInventory(inv.get());
                                    }
                                    return AnvilGUI.Response.text(text);
                                })
                                .text("0")     //sets the text the GUI should start with
                                .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                .plugin(Main.instance)                 //set the plugin instance
                                .open(p);
                            break;
                        case 2:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet6(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 3:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet9(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 4:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet12(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 5:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet15(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 6:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet18(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 8:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetHoriGreen(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 9:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet0(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 10:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet2(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 11:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet5(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 12:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet8(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 13:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet11(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 14:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet14(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 15:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet17(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 17:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetHoriPurple(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 19:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet1(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 20:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet4(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 21:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet7(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 22:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet10(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 23:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet13(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 24:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBet16(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 26:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetHoriBlue(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 37:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetVertiBlue(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 38:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetVertiYellow(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 39:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetVertiBrown(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 40:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetVertiPurple(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 41:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetVertiLime(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 42:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetVertiCyan(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 46:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetRed(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 49:
                            p.closeInventory();
                            new AnvilGUI.Builder()
                                    .onClose(player -> {                      //called when the inventory is closing
                                    })
                                    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
                                        int bet = anvilStuff(p, text);

                                        if (bet == -1) p.sendMessage("Invalid! Bet lower than 1 or invalid bet format.");
                                        else {
                                            //Run success code
                                            RouletteInventory inv = Main.currentRouletteMap.get(p);
                                            inv.setBetBlack(bet);
                                            inv.fixTotalBet();
                                            Main.currentRouletteMap.put(p, inv);
                                            p.openInventory(inv.get());
                                        }
                                        return AnvilGUI.Response.text(text);
                                    })
                                    .text("0")     //sets the text the GUI should start with
                                    .item(new ItemStack(Material.PAPER)) //use a custom item for the first slot
                                    .title("Enter your bet.")              //set the title of the GUI (only works in 1.14+)
                                    .plugin(Main.instance)                 //set the plugin instance
                                    .open(p);
                            break;
                        case 52:
                            Main.currentRouletteMap.remove(p);
                            p.closeInventory();
                            p.sendMessage("You cancelled the bet!");
                        case 53:
                            //Run the roulette
                            Inventory inv = InventoryUtils.getPrefilledInventory(p,18, new ItemStack(Material.GRAY_STAINED_GLASS_PANE), "Rolling...");
                            inv.setItem(4, new ItemStack(Material.HOPPER));
                            List<ItemStack> skulls = new ArrayList<>();

                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/defa4a74447d0e2fa4c43f03d9661a7ee6dee51da82e02ea53aad93f715292", "§a0", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/d2a6f0e84daefc8b21aa99415b16ed5fdaa6d8dc0c3cd591f49ca832b575", "§a1", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/b13b778c6e5128024214f859b4fadc7738c7be367ee4b9b8dbad7954cff3a", "§a2", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/cd319b9343f17a35636bcbc26b819625a9333de3736111f2e932827c8e749", "§a3", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/95bc42c69846c3da9531ac7dba2b55363f8f9472576e17d423b7a9b81c9151", "§a4", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/7fb91bb97749d6a6eed4449d23aea284dc4de6c3818eea5c7e149ddda6f7c9", "§a5", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/c5da1cb6c4c23710224b4f4e8d6ffcf8b4b55f7fe891c1204af7485cf252a1d8", "§a6", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/9e198fd831cb61f3927f21cf8a7463af5ea3c7e43bd3e8ec7d2948631cce879", "§a7", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/1683440c6447c195aaf764e27a1259219e91c6d8ab6bd89a11ca8d2cc799fa8", "§a8", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/9f7aa0d97983cd67dfb67b7d9d9c641bc9aa34d96632f372d26fee19f71f8b7", "§a9", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/f5987f43ff57d4dabaa2d2ceb9f01fc6ee46db162a5e12dfdbb57fd468132b8", "§a10", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/d92536c753d7308c9afe371ed8a853b5f988b84c943dfe9b6aa60fac7aa4dbb", "§a11", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/7e14f14f1e12ea72575f68134bb4f2b9ec6ce6205525bfc4c62654c55dae547", "§a12", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/fcfa3e181fc2d81f46555811e79758655d9cc8ed8f4373f203efc9d6b94f", "§a13", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/edc3c228dc17254124b6be51f5cb26d08f89727ad27463ff9c4bc29918e1ab", "§a14", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/df62c12bdd652ebc53afe692fad9bad83ddc6792818bf413b54154e87e29", "§a15", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/42d9786a312cb0b5167312f43d747150e7eb528c3d6e9dd27438507dd979a7f3", "§a16", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/f81f02c8a3bb370ab55428182fe8888aecf0d7f16921464c1d3e5b31ce1d", "§a17", ""));
                            skulls.add(me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/1beb64cf826831eca246f12c3d397f6881decf98ade887e6bc01ab54263128", "§a18", ""));

                            //Init
                            inv.setItem(9, skulls.get(0));
                            inv.setItem(10, skulls.get(1));
                            inv.setItem(11, skulls.get(2));
                            inv.setItem(12, skulls.get(3));
                            inv.setItem(13, skulls.get(4));
                            inv.setItem(14, skulls.get(5));
                            inv.setItem(15, skulls.get(6));
                            inv.setItem(16, skulls.get(7));
                            inv.setItem(17, skulls.get(8));

                            p.openInventory(inv);

                            RouletteInventory rouletteInventory = Main.currentRouletteMap.get(p);
                            rouletteInventory.fixTotalBet();
                            Main.currentRouletteMap.put(p, rouletteInventory);

                            if (rouletteInventory.getTotalBet() == 0) {
                                p.closeInventory();
                                p.sendMessage("You didn't enter any bets!");
                                return;
                            }

                            if (rouletteInventory.getTotalBet() > Main.econ.getBalance(Bukkit.getOfflinePlayer(p.getUniqueId()))) {
                                p.closeInventory();
                                p.sendMessage("You don't have enough money for this bet!");
                                return;
                            }

                            final int[] pointerAtEnd = {8};
                            Random r = new Random();
                            int ticksToRun = r.nextInt(180) + 20;

                            for (int i = 1; i <= ticksToRun; i++) {
                                if ((i % 2) != 0) {
                                    continue;
                                } else {
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            pointerAtEnd[0]++;
                                            if (pointerAtEnd[0] > 18) {
                                                pointerAtEnd[0] = 0;
                                            }
                                            if (pointerAtEnd[0] > 7) {
                                                inv.setItem(9, skulls.get(pointerAtEnd[0]-8));
                                                inv.setItem(10, skulls.get(pointerAtEnd[0]-7));
                                                inv.setItem(11, skulls.get(pointerAtEnd[0]-6));
                                                inv.setItem(12, skulls.get(pointerAtEnd[0]-5));
                                                inv.setItem(13, skulls.get(pointerAtEnd[0]-4));
                                                inv.setItem(14, skulls.get(pointerAtEnd[0]-3));
                                                inv.setItem(15, skulls.get(pointerAtEnd[0]-2));
                                                inv.setItem(16, skulls.get(pointerAtEnd[0]-1));
                                                inv.setItem(17, skulls.get(pointerAtEnd[0]));
                                            } else {
                                                inv.setItem(17, skulls.get(pointerAtEnd[0]));
                                                if (pointerAtEnd[0]-1 < 0) inv.setItem(16, skulls.get(pointerAtEnd[0]+18));
                                                else inv.setItem(16, skulls.get(pointerAtEnd[0]-1));

                                                if (pointerAtEnd[0]-2 < 0) inv.setItem(15, skulls.get(pointerAtEnd[0]+17));
                                                else inv.setItem(15, skulls.get(pointerAtEnd[0]-2));

                                                if (pointerAtEnd[0]-3 < 0) inv.setItem(14, skulls.get(pointerAtEnd[0]+16));
                                                else inv.setItem(14, skulls.get(pointerAtEnd[0]-3));

                                                if (pointerAtEnd[0]-4 < 0) inv.setItem(13, skulls.get(pointerAtEnd[0]+15));
                                                else inv.setItem(13, skulls.get(pointerAtEnd[0]-4));

                                                if (pointerAtEnd[0]-5 < 0) inv.setItem(12, skulls.get(pointerAtEnd[0]+14));
                                                else inv.setItem(12, skulls.get(pointerAtEnd[0]-5));

                                                if (pointerAtEnd[0]-6 < 0) inv.setItem(11, skulls.get(pointerAtEnd[0]+13));
                                                else inv.setItem(11, skulls.get(pointerAtEnd[0]-6));

                                                if (pointerAtEnd[0]-7 < 0) inv.setItem(10, skulls.get(pointerAtEnd[0]+12));
                                                else inv.setItem(10, skulls.get(pointerAtEnd[0]-7));

                                                if (pointerAtEnd[0]-8 < 0) inv.setItem(9, skulls.get(pointerAtEnd[0]+11));
                                                else inv.setItem(9, skulls.get(pointerAtEnd[0]-8));
                                            }
                                        }
                                    }.runTaskLaterAsynchronously(Main.instance, i);
                                }
                            }

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    inv.setItem(9, Utils.newItemStackWithName(Material.GRAY_STAINED_GLASS_PANE, " "));
                                    inv.setItem(17, Utils.newItemStackWithName(Material.GRAY_STAINED_GLASS_PANE, " "));
                                }
                            }.runTaskLaterAsynchronously(Main.instance, ticksToRun+1);
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    inv.setItem(10, Utils.newItemStackWithName(Material.GRAY_STAINED_GLASS_PANE, " "));
                                    inv.setItem(16, Utils.newItemStackWithName(Material.GRAY_STAINED_GLASS_PANE, " "));
                                }
                            }.runTaskLaterAsynchronously(Main.instance, ticksToRun+6);
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    inv.setItem(11, Utils.newItemStackWithName(Material.GRAY_STAINED_GLASS_PANE, " "));
                                    inv.setItem(15, Utils.newItemStackWithName(Material.GRAY_STAINED_GLASS_PANE, " "));
                                }
                            }.runTaskLaterAsynchronously(Main.instance, ticksToRun+11);
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    inv.setItem(12, Utils.newItemStackWithName(Material.GRAY_STAINED_GLASS_PANE, " "));
                                    inv.setItem(14, Utils.newItemStackWithName(Material.GRAY_STAINED_GLASS_PANE, " "));
                                }
                            }.runTaskLaterAsynchronously(Main.instance, ticksToRun+16);
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    //End of the roulette: Calculate results
                                    inv.setItem(5, Utils.newItemStackWithName(Material.PAPER, "§bReturn to betting menu"));
                                    RouletteInventory rouletteInventory = Main.currentRouletteMap.get(p);
                                    int totalBet = rouletteInventory.getTotalBet();
                                    Main.currentRouletteMap.remove(p);

                                    ItemStack landedSkull = inv.getItem(13);
                                    RouletteSlot slot = Utils.getRouletteSlotFromSkull(landedSkull);

                                    int numberBet = rouletteInventory.getBet(slot.getNumber());
                                    int colourBet = rouletteInventory.getBet(slot.getColour());
                                    int vertiGroupBet = rouletteInventory.getBet(slot.getVertiGroup());
                                    int horiGroupBet = rouletteInventory.getBet(slot.getHoriGroup());

                                    int totalWin = numberBet*18 + colourBet*2 + vertiGroupBet*6 + horiGroupBet*3;

                                    p.sendMessage("§b[----------------§aResults§b----------------]");
                                    p.sendMessage(String.format("                  §dYour total bet: %s", totalBet));
                                    p.sendMessage(String.format("               §eNumber: %s §7(Your bet: %s)", slot.getNumber(), numberBet));
                                    p.sendMessage(String.format("              §9Colour: %s §7(Your bet: %s)", WordUtils.capitalize(slot.getColour().toString().toLowerCase()), colourBet));
                                    p.sendMessage(String.format("           §6Vertical Group: %s §7(Your bet: %s)", WordUtils.capitalize(slot.getVertiGroup().toString().toLowerCase()), vertiGroupBet));
                                    p.sendMessage(String.format("          §3Horizontal Group: %s §7(Your bet: %s)", WordUtils.capitalize(slot.getHoriGroup().toString().toLowerCase()), horiGroupBet));
                                    p.sendMessage(" ");
                                    p.sendMessage("§b[----------------§aWinnings§b----------------]");
                                    p.sendMessage(String.format("                        §eNumber: %s", numberBet*18));
                                    p.sendMessage(String.format("                        §9Colour: %s", colourBet*2));
                                    p.sendMessage(String.format("                    §6Vertical Group: %s", vertiGroupBet*6));
                                    p.sendMessage(String.format("                   §3Horizontal Group: %s", horiGroupBet*3));
                                    p.sendMessage(String.format("                         §dTotal: %s", totalWin));
                                    p.sendMessage(" ");

                                    if (totalWin > totalBet) {
                                        p.sendMessage(String.format("                         §aProfit: %s", totalWin - totalBet));
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                Firework fw = (Firework) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                                                FireworkMeta fwm = fw.getFireworkMeta();

                                                fwm.setPower(3);
                                                fwm.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(true).build());

                                                fw.setFireworkMeta(fwm);
                                                fw.detonate();
                                            }
                                        }.runTask(Main.instance);
                                    }
                                    else if (totalBet > totalWin) {
                                        p.sendMessage(String.format("                         §4Loss: %s", totalBet - totalWin));
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                Firework fw = (Firework) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                                                FireworkMeta fwm = fw.getFireworkMeta();

                                                fwm.setPower(3);
                                                fwm.addEffect(FireworkEffect.builder().withColor(Color.RED).flicker(true).build());

                                                fw.setFireworkMeta(fwm);
                                                fw.detonate();
                                            }
                                        }.runTask(Main.instance);
                                    }
                                    else p.sendMessage("          §5Even: Your win and bet were equal.");

                                    Main.econ.withdrawPlayer(Bukkit.getOfflinePlayer(p.getUniqueId()), totalBet);
                                    Main.econ.depositPlayer(Bukkit.getOfflinePlayer(p.getUniqueId()), totalWin);
                                }
                            }.runTaskLaterAsynchronously(Main.instance, ticksToRun+21);


                        default:
                            System.out.println(" ");
                    }
                }
            }
        }
    }

    private int anvilStuff(Player p, String text) {
        int bet = 0;
        p.closeInventory();
        try {
            if (text.equalsIgnoreCase("")) bet = -1;
            int i = Integer.parseInt(text);
            if (i < 1) bet = -1;
            else bet = i;
        } catch (Exception e) {
            bet = -1;
            e.printStackTrace();
        }
        return bet;
    }
}
