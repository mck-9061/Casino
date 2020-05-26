package me.threalmck.casino.entities;

import me.threalmck.casino.utils.Utils;
import org.bukkit.inventory.ItemStack;

import me.threalmck.casino.*;

public class SlotsIcon {
    private static int aWin = Main.getSlotsConfig().getInt("a");
    private static int bWin = Main.getSlotsConfig().getInt("b");
    private static int cWin = Main.getSlotsConfig().getInt("c");
    private static int cherryWin = Main.getSlotsConfig().getInt("cherry");
    private static int grapesWin = Main.getSlotsConfig().getInt("grapes");
    private static int lemonWin = Main.getSlotsConfig().getInt("lemon");
    private static int limeWin = Main.getSlotsConfig().getInt("lime");
    private static int orangeWin = Main.getSlotsConfig().getInt("orange");
    private static int sevenWin = Main.getSlotsConfig().getInt("seven");

    public static final ItemStack A = Utils.getSkull("http://textures.minecraft.net/texture/8108027353d6ee8d71f276b6a2679ee23316fb215de2503ed5ba6ccac4e0", "§rA", String.format("§rWinnings: %s:1", aWin));
    public static final ItemStack B = Utils.getSkull("http://textures.minecraft.net/texture/da1484f5c5458a3ada594a528b65bf9a9d577e25b2717da786461c9b6588b48", "§rB", String.format("§rWinnings: %s:1", bWin));
    public static final ItemStack C = Utils.getSkull("http://textures.minecraft.net/texture/5931b97de7a253b63dff567ea95077df93d4b11c6325f6435f6a9103b7122f0", "§rC", String.format("§rWinnings: %s:1", cWin));
    public static final ItemStack CHERRY = Utils.getSkull("http://textures.minecraft.net/texture/d525707696bcd15a173056fa39296e80ff41168bb0add552f4523e2558a3119", "§rCherry", String.format("§rWinnings: %s:1", cherryWin));
    public static final ItemStack ORANGE = Utils.getSkull("http://textures.minecraft.net/texture/65b1db547d1b7956d4511accb1533e21756d7cbc38eb64355a2626412212", "§rOrange", String.format("§rWinnings: %s:1", orangeWin));
    public static final ItemStack LEMON = Utils.getSkull("http://textures.minecraft.net/texture/957fd56ca15978779324df519354b6639a8d9bc1192c7c3de925a329baef6c", "§rLemon", String.format("§rWinnings: %s:1", lemonWin));
    public static final ItemStack LIME = Utils.getSkull("http://textures.minecraft.net/texture/7f24b7135789fe799df34594d6805f5112bee6232605ba6de215186ad94", "§rLime", String.format("§rWinnings: %s:1", limeWin));
    public static final ItemStack GRAPES = Utils.getSkull("http://textures.minecraft.net/texture/ee5935863c53a996f5334e90f55de538e83ffc5f6b0b8e83a4dc4f6e6b1208", "§rGrapes", String.format("§rWinnings: %s:1", grapesWin));
    public static final ItemStack SEVEN = Utils.getSkull("http://textures.minecraft.net/texture/9e198fd831cb61f3927f21cf8a7463af5ea3c7e43bd3e8ec7d2948631cce879", "§rSeven", String.format("§rWinnings: %s:1", sevenWin));
}
