package me.threalmck.casino.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {
    public static Inventory getPrefilledInventory(Player player, int size, ItemStack toFill, String name) {
        Inventory i = Bukkit.createInventory(player, size, name);
        for (int i1 = 0; i1 < size; i1++) {
            i.setItem(i1, Utils.newItemStackWithName(toFill.getType(), " "));
        }
        return i;
    }
}
