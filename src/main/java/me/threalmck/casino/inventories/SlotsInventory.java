package me.threalmck.casino.inventories;

import me.threalmck.casino.Main;
import me.threalmck.casino.utils.InventoryUtils;
import me.threalmck.casino.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SlotsInventory {
    private final List<ItemStack> slot1;
    private final List<ItemStack> slot2;
    private final List<ItemStack> slot3;
    private final Player p;
    private List<String> linesPicked;
    private int bet;

    public SlotsInventory(List<ItemStack> slot1, List<ItemStack> slot2, List<ItemStack> slot3, int bet, Player p) {
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.slot3 = slot3;
        this.bet = bet;
        this.p = p;
        linesPicked = new ArrayList<>();
    }

    public List<ItemStack> getSlot1() {
        return slot1;
    }

    public List<ItemStack> getSlot2() {
        return slot2;
    }

    public List<ItemStack> getSlot3() {
        return slot3;
    }

    public List<String> getLinesPicked() {
        return linesPicked;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setLinesPicked(List<String> linesPicked) {
        this.linesPicked = linesPicked;
    }

    public Inventory get() {
        Inventory inv = InventoryUtils.getPrefilledInventory(p, 54, new ItemStack(Material.GRAY_STAINED_GLASS_PANE), "Slots");

        inv.setItem(0, Utils.getSkull("http://textures.minecraft.net/texture/cc58321d4bffbec2ddf66bf38cf2f9e9ddf3fa2f1387dc7d30c62b4d010c8", "", ""));
        inv.setItem(1, Utils.getSkull("http://textures.minecraft.net/texture/c148a8865bc4afe0747f3415138b96bbb4e8bbb7261f45e5d11d7219f368e4", "", ""));
        inv.setItem(2, Utils.getSkull("http://textures.minecraft.net/texture/612c7afea48e53325e5129038a45aec51afe256abca941b6bc8206fae1cef", "", ""));
        inv.setItem(3, Utils.getSkull("http://textures.minecraft.net/texture/ced9f431a997fce0d8be1844f62090b1783ac569c9d2797528349d37c215fcc", "", ""));
        inv.setItem(4, Utils.getSkull("http://textures.minecraft.net/texture/ca516fbae16058f251aef9a68d3078549f48f6d5b683f19cf5a1745217d72cc", "§rLine 1", ""));
        inv.setItem(5, Utils.getSkull("http://textures.minecraft.net/texture/2b3513aa4117a3a329e1f9a43d2a8c51cd722aadd4e8af2feda67b33b64c298", "§rLine 2", ""));
        inv.setItem(6, Utils.getSkull("http://textures.minecraft.net/texture/c4226f2eb64abc86b38b61d1497764cba03d178afc33b7b8023cf48b49311", "§rLine 3", ""));
        inv.setItem(7, Utils.getSkull("http://textures.minecraft.net/texture/a7ac53233ae842aebb38c13becce7c91f8d5f67976332ce1ba88dc0e682f8d4", "§rLine 4", ""));
        inv.setItem(8, Utils.getSkull("http://textures.minecraft.net/texture/df3f565a88928ee5a9d6843d982d78eae6b41d9077f2a1e526af867d78fb", "§rLine 5", ""));
        inv.setItem(17, Utils.newItemStackWithNameAndLore(Material.BOOK, "§6Jackpot", String.format("§rPick all 5 lines to have&§ra chance at jackpot!&§rLine up 3 of §a%s§r in line 1&§rto win!&§rCurrent jackpot: $%s&§rMinimum initial bet: $%s", Main.getSlotsConfig().getString("JackpotIcon"), Main.getSlotsConfig().getInt("CurrentJackpot"), Main.getSlotsConfig().getInt("MinimumBet"))));
        inv.setItem(20, slot1.get(0));
        inv.setItem(21, slot2.get(0));
        inv.setItem(22, slot3.get(0));
        inv.setItem(25, Utils.getSkull("http://textures.minecraft.net/texture/beb588b21a6f98ad1ff4e085c552dcb050efc9cab427f46048f18fc803475f7", "§cCancel", ""));
        inv.setItem(29, slot1.get(1));
        inv.setItem(30, slot2.get(1));
        inv.setItem(31, slot3.get(1));
        inv.setItem(34, Utils.getSkull("http://textures.minecraft.net/texture/a92e31ffb59c90ab08fc9dc1fe26802035a3a47c42fee63423bcdb4262ecb9b6", "§aConfirm", ""));
        inv.setItem(38, slot1.get(2));
        inv.setItem(39, slot2.get(2));
        inv.setItem(40, slot3.get(2));
        inv.setItem(53, Utils.newItemStackWithNameAndLore(Material.ANVIL, String.format("§rBet: %s", bet), String.format("§rBalance: %s", Main.econ.getBalance(Bukkit.getOfflinePlayer(p.getUniqueId())))));

        if (linesPicked.contains("one")) {
            //inv.setItem(27, Utils.getSkull("http://textures.minecraft.net/texture/ca516fbae16058f251aef9a68d3078549f48f6d5b683f19cf5a1745217d72cc", "§rLine 1", ""));
            inv.setItem(28, Utils.getSkull("http://textures.minecraft.net/texture/956a3618459e43b287b22b7e235ec699594546c6fcd6dc84bfca4cf30ab9311", " ", ""));
        }
        if (linesPicked.contains("two")) {
            //inv.setItem(18, Utils.getSkull("http://textures.minecraft.net/texture/2b3513aa4117a3a329e1f9a43d2a8c51cd722aadd4e8af2feda67b33b64c298", "§rLine 2", ""));
            inv.setItem(19, Utils.getSkull("http://textures.minecraft.net/texture/117f3666d3cedfae57778c78230d480c719fd5f65ffa2ad3255385e433b86e", " ", ""));
        }
        if (linesPicked.contains("three")) {
            //inv.setItem(36, Utils.getSkull("http://textures.minecraft.net/texture/c4226f2eb64abc86b38b61d1497764cba03d178afc33b7b8023cf48b49311", "§rLine 3", ""));
            inv.setItem(37, Utils.getSkull("http://textures.minecraft.net/texture/4ef356ad2aa7b1678aecb88290e5fa5a3427e5e456ff42fb515690c67517b8", " ", ""));
        }
        if (linesPicked.contains("four")) {
            //inv.setItem(9, Utils.getSkull("http://textures.minecraft.net/texture/a7ac53233ae842aebb38c13becce7c91f8d5f67976332ce1ba88dc0e682f8d4", "§rLine 4", ""));
            inv.setItem(10, Utils.getSkull("http://textures.minecraft.net/texture/832e6a70cc1e6e6a2757cb91fb13c90e8fecdd791582d17c033ecf58c1d1f8c", " ", ""));
        }
        if (linesPicked.contains("five")) {
            //inv.setItem(45, Utils.getSkull("http://textures.minecraft.net/texture/df3f565a88928ee5a9d6843d982d78eae6b41d9077f2a1e526af867d78fb", "§rLine 5", ""));
            inv.setItem(46, Utils.getSkull("http://textures.minecraft.net/texture/574e65e2f1625b0b2102d6bf3df8264ac43d9d679437a3a42e262d24c4fc", " ", ""));
        }

        return inv;
    }
}
