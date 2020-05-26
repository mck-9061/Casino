package me.threalmck.casino.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.threalmck.casino.entities.RouletteColour;
import me.threalmck.casino.entities.RouletteHoriGroup;
import me.threalmck.casino.entities.RouletteSlot;
import me.threalmck.casino.entities.RouletteVertiGroup;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.org.apache.commons.codec.binary.Base64;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Utils {
    public static ItemStack getSkull(String url, String name, String lore) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        if(url.isEmpty())return head;


        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        headMeta.setDisplayName(name);
        List<String> loreList = Arrays.asList(lore.split("&"));
        headMeta.setLore(loreList);

        head.setItemMeta(headMeta);
        return head;
    }

    public static ItemStack newItemStackWithName(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack newItemStackWithNameAndLore(Material material, String name, String lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        List<String> loreList = Arrays.asList(lore.split("&"));
        meta.setLore(loreList);
        item.setItemMeta(meta);
        return item;
    }

    public static RouletteSlot getRouletteSlotFromSkull(ItemStack skull) {
        ItemMeta meta = skull.getItemMeta();
        int number = Integer.parseInt(meta.getDisplayName().replace("§a", ""));

        List<Integer> blackInts = Arrays.asList(3, 9, 12, 18, 5, 14, 1, 7, 16);

        List<Integer> horiGreenInts = Arrays.asList(3, 6, 9, 12, 15, 18);
        List<Integer> horiPurpleInts = Arrays.asList(2, 5, 8, 11, 14, 17);

        List<Integer> vertiBlueInts = Arrays.asList(1, 2, 3);
        List<Integer> vertiYellowInts = Arrays.asList(4, 5, 6);
        List<Integer> vertiBrownInts = Arrays.asList(7, 8, 9);
        List<Integer> vertiPurpleInts = Arrays.asList(10, 11, 12);
        List<Integer> vertiLimeInts = Arrays.asList(13, 14, 15);

        RouletteVertiGroup vertiGroup;
        RouletteHoriGroup horiGroup;
        RouletteColour colour;

        if (number == 0) return new RouletteSlot(RouletteColour.LIME, RouletteHoriGroup.NONE, RouletteVertiGroup.NONE, number);

        if (blackInts.contains(number)) colour = RouletteColour.BLACK;
        else colour = RouletteColour.RED;

        if (horiGreenInts.contains(number)) horiGroup = RouletteHoriGroup.GREEN;
        else if (horiPurpleInts.contains(number)) horiGroup = RouletteHoriGroup.PURPLE;
        else horiGroup = RouletteHoriGroup.BLUE;

        if (vertiBlueInts.contains(number)) vertiGroup = RouletteVertiGroup.BLUE;
        else if (vertiYellowInts.contains(number)) vertiGroup = RouletteVertiGroup.YELLOW;
        else if (vertiBrownInts.contains(number)) vertiGroup = RouletteVertiGroup.BROWN;
        else if (vertiPurpleInts.contains(number)) vertiGroup = RouletteVertiGroup.PURPLE;
        else if (vertiLimeInts.contains(number)) vertiGroup = RouletteVertiGroup.LIME;
        else vertiGroup = RouletteVertiGroup.CYAN;

        return new RouletteSlot(colour, horiGroup, vertiGroup, number);
    }

}
