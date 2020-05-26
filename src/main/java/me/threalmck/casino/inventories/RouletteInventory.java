package me.threalmck.casino.inventories;

import me.threalmck.casino.Main;
import me.threalmck.casino.entities.RouletteColour;
import me.threalmck.casino.entities.RouletteHoriGroup;
import me.threalmck.casino.entities.RouletteVertiGroup;
import me.threalmck.casino.utils.InventoryUtils;
import me.threalmck.casino.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RouletteInventory {
    private Player p;
    private int totalBet = 0;
    private int bet0 = 0;
    private int bet1 = 0;
    private int bet2 = 0;
    private int bet3 = 0;
    private int bet4 = 0;
    private int bet5 = 0;
    private int bet6 = 0;
    private int bet7 = 0;
    private int bet8 = 0;
    private int bet9 = 0;
    private int bet10 = 0;
    private int bet11 = 0;
    private int bet12 = 0;
    private int bet13 = 0;
    private int bet14 = 0;
    private int bet15 = 0;
    private int bet16 = 0;
    private int bet17 = 0;
    private int bet18 = 0;
    private int betRed = 0;
    private int betBlack = 0;
    private int betHoriGreen = 0;
    private int betHoriPurple = 0;
    private int betHoriBlue = 0;
    private int betVertiBlue = 0;
    private int betVertiYellow = 0;
    private int betVertiBrown = 0;
    private int betVertiPurple = 0;
    private int betVertiLime = 0;
    private int betVertiCyan = 0;

    public int getTotalBet() {
        return totalBet;
    }

    public int getBet0() {
        return bet0;
    }

    public int getBet1() {
        return bet1;
    }

    public int getBet2() {
        return bet2;
    }

    public int getBet3() {
        return bet3;
    }

    public int getBet4() {
        return bet4;
    }

    public int getBet5() {
        return bet5;
    }

    public int getBet6() {
        return bet6;
    }

    public int getBet7() {
        return bet7;
    }

    public int getBet8() {
        return bet8;
    }

    public int getBet9() {
        return bet9;
    }

    public int getBet10() {
        return bet10;
    }

    public int getBet11() {
        return bet11;
    }

    public int getBet12() {
        return bet12;
    }

    public int getBet13() {
        return bet13;
    }

    public int getBet14() {
        return bet14;
    }

    public int getBet15() {
        return bet15;
    }

    public int getBet16() {
        return bet16;
    }

    public int getBet17() {
        return bet17;
    }

    public int getBet18() {
        return bet18;
    }

    public int getBetRed() {
        return betRed;
    }

    public int getBetBlack() {
        return betBlack;
    }

    public int getBetHoriGreen() {
        return betHoriGreen;
    }

    public int getBetHoriPurple() {
        return betHoriPurple;
    }

    public int getBetHoriBlue() {
        return betHoriBlue;
    }

    public int getBetVertiBlue() {
        return betVertiBlue;
    }

    public int getBetVertiYellow() {
        return betVertiYellow;
    }

    public int getBetVertiBrown() {
        return betVertiBrown;
    }

    public int getBetVertiPurple() {
        return betVertiPurple;
    }

    public int getBetVertiLime() {
        return betVertiLime;
    }

    public int getBetVertiCyan() {
        return betVertiCyan;
    }

    public int getBet(int number) {
        switch (number) {
            case 0: return bet0;
            case 1: return bet1;
            case 2: return bet2;
            case 3: return bet3;
            case 4: return bet4;
            case 5: return bet5;
            case 6: return bet6;
            case 7: return bet7;
            case 8: return bet8;
            case 9: return bet9;
            case 10: return bet10;
            case 11: return bet11;
            case 12: return bet12;
            case 13: return bet13;
            case 14: return bet14;
            case 15: return bet15;
            case 16: return bet16;
            case 17: return bet17;
            case 18: return bet18;
            default: System.out.println(" ");
        }
        return 0;
    }

    public int getBet(RouletteColour colour) {
        switch (colour) {
            case BLACK: return betBlack;
            case RED: return betRed;
            default: System.out.println(" ");
        }
        return 0;
    }

    public int getBet(RouletteVertiGroup group) {
        switch (group) {
            case BLUE: return betVertiBlue;
            case YELLOW: return betVertiYellow;
            case BROWN: return betVertiBrown;
            case PURPLE: return betVertiPurple;
            case LIME: return betVertiLime;
            case CYAN: return betVertiCyan;
            default: System.out.println(" ");
        }
        return 0;
    }

    public int getBet(RouletteHoriGroup group) {
        switch (group) {
            case GREEN: return betHoriGreen;
            case PURPLE: return betHoriPurple;
            case BLUE: return betHoriBlue;
            default: System.out.println(" ");
        }
        return 0;
    }

    public void setTotalBet(int totalBet) {
        this.totalBet = totalBet;
    }

    public void setBet0(int bet0) {
        this.bet0 = bet0;
    }

    public void setBet1(int bet1) {
        this.bet1 = bet1;
    }

    public void setBet2(int bet2) {
        this.bet2 = bet2;
    }

    public void setBet3(int bet3) {
        this.bet3 = bet3;
    }

    public void setBet4(int bet4) {
        this.bet4 = bet4;
    }

    public void setBet5(int bet5) {
        this.bet5 = bet5;
    }

    public void setBet6(int bet6) {
        this.bet6 = bet6;
    }

    public void setBet7(int bet7) {
        this.bet7 = bet7;
    }

    public void setBet8(int bet8) {
        this.bet8 = bet8;
    }

    public void setBet9(int bet9) {
        this.bet9 = bet9;
    }

    public void setBet10(int bet10) {
        this.bet10 = bet10;
    }

    public void setBet11(int bet11) {
        this.bet11 = bet11;
    }

    public void setBet12(int bet12) {
        this.bet12 = bet12;
    }

    public void setBet13(int bet13) {
        this.bet13 = bet13;
    }

    public void setBet14(int bet14) {
        this.bet14 = bet14;
    }

    public void setBet15(int bet15) {
        this.bet15 = bet15;
    }

    public void setBet16(int bet16) {
        this.bet16 = bet16;
    }

    public void setBet17(int bet17) {
        this.bet17 = bet17;
    }

    public void setBet18(int bet18) {
        this.bet18 = bet18;
    }

    public void setBetRed(int betRed) {
        this.betRed = betRed;
    }

    public void setBetBlack(int betBlack) {
        this.betBlack = betBlack;
    }

    public void setBetHoriGreen(int betHoriGreen) {
        this.betHoriGreen = betHoriGreen;
    }

    public void setBetHoriPurple(int betHoriPurple) {
        this.betHoriPurple = betHoriPurple;
    }

    public void setBetHoriBlue(int betHoriBlue) {
        this.betHoriBlue = betHoriBlue;
    }

    public void setBetVertiBlue(int betVertiBlue) {
        this.betVertiBlue = betVertiBlue;
    }

    public void setBetVertiYellow(int betVertiYellow) {
        this.betVertiYellow = betVertiYellow;
    }

    public void setBetVertiBrown(int betVertiBrown) {
        this.betVertiBrown = betVertiBrown;
    }

    public void setBetVertiPurple(int betVertiPurple) {
        this.betVertiPurple = betVertiPurple;
    }

    public void setBetVertiLime(int betVertiLime) {
        this.betVertiLime = betVertiLime;
    }

    public void setBetVertiCyan(int betVertiCyan) {
        this.betVertiCyan = betVertiCyan;
    }

    public void fixTotalBet() {
        this.totalBet = bet0+bet1+bet2+bet3+bet4+bet5+bet6+bet7+bet8+bet9+bet10+bet11+bet12+bet13+bet14+bet15+bet16+bet17+bet18+betBlack+betRed+betHoriBlue+betHoriPurple+betHoriGreen+betVertiCyan+betVertiLime+betVertiPurple+betVertiBrown+betVertiYellow+betVertiBlue;
    }

    public RouletteInventory(Player p) {
        this.p = p;
    }

    public Inventory get() {
        Inventory inv = InventoryUtils.getPrefilledInventory(p, 54, new ItemStack(Material.GRAY_STAINED_GLASS_PANE), "Roulette");

        inv.setItem(1, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/cd319b9343f17a35636bcbc26b819625a9333de3736111f2e932827c8e749", "§8Bet: 3", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 1:1", bet3)));
        inv.setItem(2, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/c5da1cb6c4c23710224b4f4e8d6ffcf8b4b55f7fe891c1204af7485cf252a1d8", "§cBet: 6", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 1:1", bet6)));
        inv.setItem(3, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/9f7aa0d97983cd67dfb67b7d9d9c641bc9aa34d96632f372d26fee19f71f8b7", "§8Bet: 9", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 1:1", bet9)));
        inv.setItem(4, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/8bedfe349bc32cfd961abe40a856197b59e5d45e69ce9715589dc8e820be29f", "§cBet: 12", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 1:1", bet12)));
        inv.setItem(5, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/df62c12bdd652ebc53afe692fad9bad83ddc6792818bf413b54154e87e29", "§cBet: 15", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet15)));
        inv.setItem(6, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/1beb64cf826831eca246f12c3d397f6881decf98ade887e6bc01ab54263128", "§8Bet: 18", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet18)));
        inv.setItem(7, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/8550b7f74e9ed7633aa274ea30cc3d2e87abb36d4d1f4ca608cd44590cce0b", " ", ""));
        inv.setItem(8, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/21e4ea59b54cc99416bc9f624548ddac2a38eea6a2dbf6e4ccd83cec7ac969", "§2Bet: 3/6/9/12/15/18", String.format("§rCurrent bets: %s&§rOdds: 1/3&§rWin: 3:1", betHoriGreen)));
        inv.setItem(9, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/defa4a74447d0e2fa4c43f03d9661a7ee6dee51da82e02ea53aad93f715292", "§aBet: 0", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet0)));
        inv.setItem(10, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/b13b778c6e5128024214f859b4fadc7738c7be367ee4b9b8dbad7954cff3a", "§cBet: 2", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet2)));
        inv.setItem(11, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/7fb91bb97749d6a6eed4449d23aea284dc4de6c3818eea5c7e149ddda6f7c9", "§8Bet: 5", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet5)));
        inv.setItem(12, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/1683440c6447c195aaf764e27a1259219e91c6d8ab6bd89a11ca8d2cc799fa8", "§cBet: 8", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet8)));
        inv.setItem(13, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/3997e7c194c4702cd214428e1f5e64615726a52f7c6e3a337893091e786722a", "§8Bet: 11", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet11)));
        inv.setItem(14, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/edc3c228dc17254124b6be51f5cb26d08f89727ad27463ff9c4bc29918e1ab", "§8Bet: 14", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet14)));
        inv.setItem(15, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/f81f02c8a3bb370ab55428182fe8888aecf0d7f16921464c1d3e5b31ce1d", "§cBet: 17", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet17)));
        inv.setItem(16, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/2eff7559102aa8ff9712976b62292ee45e0793c46f668916868207f399effab", " ", ""));
        inv.setItem(17, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/1ef134f0efa88351b837f7c087afe1b3fb36435ab7d746fa37c0ef155e4f29", "§5Bet: 2/5/8/11/14/17", String.format("§rCurrent bets: %s&§rOdds: 1/3&§rWin: 3:1", betHoriPurple)));
        inv.setItem(19, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/d2a6f0e84daefc8b21aa99415b16ed5fdaa6d8dc0c3cd591f49ca832b575", "§8Bet: 1", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet1)));
        inv.setItem(20, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/95bc42c69846c3da9531ac7dba2b55363f8f9472576e17d423b7a9b81c9151", "§cBet: 4", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet4)));
        inv.setItem(21, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/9e198fd831cb61f3927f21cf8a7463af5ea3c7e43bd3e8ec7d2948631cce879", "§8Bet: 7", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet7)));
        inv.setItem(22, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/f5987f43ff57d4dabaa2d2ceb9f01fc6ee46db162a5e12dfdbb57fd468132b8", "§cBet: 10", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet10)));
        inv.setItem(23, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/fcfa3e181fc2d81f46555811e79758655d9cc8ed8f4373f203efc9d6b94f", "§cBet: 13", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet13)));
        inv.setItem(24, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/42d9786a312cb0b5167312f43d747150e7eb528c3d6e9dd27438507dd979a7f3", "§8Bet: 16", String.format("§rCurrent bets: %s&§rOdds: 1/19&§rWin: 17:1", bet16)));
        inv.setItem(25, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/5ae78451bf26cf49fd5f54cd8f2b37cd25c92e5ca76298b3634cb541e9ad89", " ", ""));
        inv.setItem(26, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/bd21b0bafb89721cac494ff2ef52a54a18339858e4dca99a413c42d9f88e0f6", "§1Bet: 1/4/7/10/13/16", String.format("§rCurrent bets: %s&§rOdds: 1/3&§rWin: 3:1", betHoriBlue)));
        inv.setItem(28, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/f2fc23866523caaa8a9534566127a6f8389af3e76b8e3c33c2473cba6889c4", " ", ""));
        inv.setItem(29, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/3e4f2f9698c3f186fe44cc63d2f3c4f9a241223acf0581775d9cecd7075", " ", ""));
        inv.setItem(30, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/142413cb28cdcb7edd0deca654b26d584d81646d94b825e8529db2f2df30e0", " ", ""));
        inv.setItem(31, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/94a04b32d2b7598f9dd8e23fb4015c69c3cd942a37a9ea84d06869f459f1", " ", ""));
        inv.setItem(32, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/b221da4418bd3bfb42eb64d2ab429c61decb8f4bf7d4cfb77a162be3dcb0b927", " ", ""));
        inv.setItem(33, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/4b221cb9607c8a9bf02fef5d7614e3eb169cc219bf4250fd5715d5d2d6045f7", " ", ""));
        inv.setItem(37, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/bd21b0bafb89721cac494ff2ef52a54a18339858e4dca99a413c42d9f88e0f6", "§1Bet: 1/2/3", String.format("§rCurrent bets: %s&§rOdds: 1/6&§rWin: 6:1", betVertiBlue)));
        inv.setItem(38, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/58cca1e0fb5d9bf77f527356e8bf4e53cb4a4c56f11e779abadae541bbedc6", "§eBet: 4/5/6", String.format("§rCurrent bets: %s&§rOdds: 1/6&§rWin: 6:1", betVertiYellow)));
        inv.setItem(39, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/8b959649e1f9a20658c4142d181162014bf34710be91cb4d495bc74a7e127a", "§6Bet: 7/8/9", String.format("§rCurrent bets: %s&§rOdds: 1/6&§rWin: 6:1", betVertiBrown)));
        inv.setItem(40, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/6e31837d89c264c3b54f8214ae24f89a368a92bc46df9225333ad7cd449f856", "§5Bet: 10/11/12", String.format("§rCurrent bets: %s&§rOdds: 1/6&§rWin: 6:1", betVertiPurple)));
        inv.setItem(41, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/a2c142af59f29eb35ab29c6a45e33635dcfc2a956dbd4d2e5572b0d38891b354", "§aBet: 13/14/15", String.format("§rCurrent bets: %s&§rOdds: 1/6&§rWin: 6:1", betVertiLime)));
        inv.setItem(42, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/412aab401d69a5f0c5cadcb3c1d137b10794c43b058f93630b8145b83497a40", "§bBet: 16/17/18", String.format("§rCurrent bets: %s&§rOdds: 1/6&§rWin: 6:1", betVertiCyan)));
        inv.setItem(44, Utils.newItemStackWithNameAndLore(Material.ANVIL, String.format("§rCurrent total bet: %s", totalBet), String.format("§rBalance: %s", Main.econ.getBalance(Bukkit.getOfflinePlayer(p.getUniqueId())))));
        inv.setItem(45, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/fcfe8845a8d5e635fb87728ccc93895d42b4fc2e6a53f1ba78c845225822", " ", ""));
        inv.setItem(46, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/35f45c875eff538fcec98f6acc1df2aecae28f4860aecd24e2dbdf13924b327", "§cBet: Red", String.format("§rCurrent bets: %s&§rOdds: 1/2&§rWin: 1:1", betRed)));
        inv.setItem(48, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/682ad1b9cb4dd21259c0d75aa315ff389c3cef752be3949338164bac84a96e", " ", ""));
        inv.setItem(49, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/9eca98befd0d7efca9b11ebf4b2da459cc19a378114b3cdde67d4067afb896", "§8Bet: Black", String.format("§rCurrent bets: %s&§rOdds: 1/2&§rWin: 1:1", betBlack)));
        inv.setItem(52, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/beb588b21a6f98ad1ff4e085c552dcb050efc9cab427f46048f18fc803475f7", "§cCancel", ""));
        inv.setItem(53, me.threalmck.casino.utils.Utils.getSkull("http://textures.minecraft.net/texture/a92e31ffb59c90ab08fc9dc1fe26802035a3a47c42fee63423bcdb4262ecb9b6", "§aConfirm", ""));

        return inv;
    }
}
