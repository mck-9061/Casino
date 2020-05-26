package me.threalmck.casino.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import me.threalmck.casino.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetGameButton implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("*")) {
                Player p = (Player) sender;
                List<Material> buttons = new ArrayList<>();
                buttons.add(Material.BIRCH_BUTTON);
                buttons.add(Material.ACACIA_BUTTON);
                buttons.add(Material.DARK_OAK_BUTTON);
                buttons.add(Material.JUNGLE_BUTTON);
                buttons.add(Material.OAK_BUTTON);
                buttons.add(Material.SPRUCE_BUTTON);
                buttons.add(Material.STONE_BUTTON);
                buttons.add(Material.LEVER);

                if (buttons.contains(p.getTargetBlockExact(200).getType())) {
                    System.out.println(Arrays.toString(args));
                    if (args[0].equalsIgnoreCase("roulette")) {
                        Block block = ((Player) sender).getTargetBlock(null, 200);
                        Location location = block.getLocation();

                        int x = location.getBlockX();
                        int y = location.getBlockY();
                        int z = location.getBlockZ();

                        String world = location.getWorld().getName();

                        String blocklocations = world + ":" + x + ":" + y + ":" + z;

                        List<String> currentlist = Main.getCustomConfig().getStringList("Locations");
                        List<String> currentlistSlots = Main.getCustomConfig().getStringList("SlotsLocations");
                        currentlist.add(blocklocations);
                        currentlistSlots.remove(blocklocations);
                        Main.getCustomConfig().set("Locations", currentlist);
                        Main.getCustomConfig().set("SlotsLocations", currentlistSlots);
                        Main.saveDbConfig();
                        sender.sendMessage("Successfully set this button as a roulette button.");
                        return true;
                    } else if (args[0].equalsIgnoreCase("slots")) {
                        Block block = ((Player) sender).getTargetBlock(null, 200);
                        Location location = block.getLocation();

                        int x = location.getBlockX();
                        int y = location.getBlockY();
                        int z = location.getBlockZ();

                        String world = location.getWorld().getName();

                        String blocklocations = world + ":" + x + ":" + y + ":" + z;

                        List<String> currentlist = Main.getCustomConfig().getStringList("SlotsLocations");
                        List<String> currentlistRoulette = Main.getCustomConfig().getStringList("Locations");
                        currentlist.add(blocklocations);
                        currentlistRoulette.remove(blocklocations);
                        Main.getCustomConfig().set("SlotsLocations", currentlist);
                        Main.getCustomConfig().set("Locations", currentlistRoulette);
                        Main.saveDbConfig();
                        sender.sendMessage("Successfully set this button as a slots button.");
                        return true;
                    } else {
                        p.sendMessage("Invalid game! Games: roulette, slots");
                    }
                } else {
                    p.sendMessage("You aren't looking at a button!");
                    return false;
                }
            } else {
                sender.sendMessage("You don't have the appropriate permissions! Only an operator can change casino configuration.");
                return false;
            }
        } else {
            sender.sendMessage("This command can only be ran as a player.");
            return false;
        }
        return false;
    }
}
