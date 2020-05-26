package me.threalmck.casino.listeners;

import me.threalmck.casino.Main;
import me.threalmck.casino.inventories.SlotsInventory;
import me.threalmck.casino.utils.Utils;
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

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MainSlotsInventoryListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        try {
            if (Objects.equals(event.getClickedInventory(), event.getView().getBottomInventory())) return;
        } catch (Exception e) {return;}
        if (event.getWhoClicked() instanceof Player && Main.currentSlotsMap.containsKey((Player) event.getWhoClicked()) && event.getView().getTitle().equals("Slots")) {
            event.setCancelled(true);
            Player p = (Player) event.getWhoClicked();

            if (Main.currentlyRollingSlots.contains(p)) return;

            SlotsInventory inv;
            List<String> current;

            switch (event.getSlot()) {
                case 4:
                    inv = Main.currentSlotsMap.get(p);
                    current = inv.getLinesPicked();
                    if (current.contains("one")) current.remove("one");
                    if (current.contains("two")) current.remove("two");
                    if (current.contains("three")) current.remove("three");
                    if (current.contains("four")) current.remove("four");
                    if (current.contains("five")) current.remove("five");
                    current.add("one");
                    inv.setLinesPicked(current);
                    p.openInventory(inv.get());
                    Main.currentSlotsMap.put(p, inv);
                    break;
                case 5:
                    inv = Main.currentSlotsMap.get(p);
                    current = inv.getLinesPicked();
                    if (current.contains("one")) current.remove("one");
                    current.add("one");
                    if (current.contains("two")) current.remove("two");
                    if (current.contains("three")) current.remove("three");
                    if (current.contains("four")) current.remove("four");
                    if (current.contains("five")) current.remove("five");
                    current.add("two");
                    inv.setLinesPicked(current);
                    p.openInventory(inv.get());
                    Main.currentSlotsMap.put(p, inv);
                    break;
                case 6:
                    inv = Main.currentSlotsMap.get(p);
                    current = inv.getLinesPicked();
                    if (current.contains("one")) current.remove("one");
                    current.add("one");
                    if (current.contains("two")) current.remove("two");
                    current.add("two");
                    if (current.contains("three")) current.remove("three");
                    if (current.contains("four")) current.remove("four");
                    if (current.contains("five")) current.remove("five");
                    current.add("three");
                    inv.setLinesPicked(current);
                    p.openInventory(inv.get());
                    Main.currentSlotsMap.put(p, inv);
                    break;
                case 7:
                    inv = Main.currentSlotsMap.get(p);
                    current = inv.getLinesPicked();
                    if (current.contains("one")) current.remove("one");
                    current.add("one");
                    if (current.contains("two")) current.remove("two");
                    current.add("two");
                    if (current.contains("three")) current.remove("three");
                    current.add("three");
                    if (current.contains("four")) current.remove("four");
                    if (current.contains("five")) current.remove("five");
                    current.add("four");
                    inv.setLinesPicked(current);
                    p.openInventory(inv.get());
                    Main.currentSlotsMap.put(p, inv);
                    break;
                case 8:
                    inv = Main.currentSlotsMap.get(p);
                    current = inv.getLinesPicked();
                    if (current.contains("one")) current.remove("one");
                    current.add("one");
                    if (current.contains("two")) current.remove("two");
                    current.add("two");
                    if (current.contains("three")) current.remove("three");
                    current.add("three");
                    if (current.contains("four")) current.remove("four");
                    current.add("four");
                    if (current.contains("five")) current.remove("five");
                    current.add("five");
                    inv.setLinesPicked(current);
                    p.openInventory(inv.get());
                    Main.currentSlotsMap.put(p, inv);
                    break;
                case 25:
                    if (Main.currentlyRollingSlots.contains(p)) {
                        p.sendMessage("You can't cancel a game that's already running!");
                        break;
                    } else {
                        Main.currentSlotsMap.remove(p);
                        p.closeInventory();
                        p.sendMessage("You cancelled your slots game!");
                        break;
                    }
                case 34:
                    SlotsInventory slotsInventory = Main.currentSlotsMap.get(p);
                    if (Main.currentlyRollingSlots.contains(p)) {
                        p.sendMessage("You're already rolling slots.");
                        break;
                    } else if (slotsInventory.getBet()*slotsInventory.getLinesPicked().size() > Main.econ.getBalance(Bukkit.getOfflinePlayer(p.getUniqueId()))) {
                        if (slotsInventory.getLinesPicked().size() > 1) p.sendMessage(String.format("You picked more than 1 line, so your bet was multiplied by %s.", slotsInventory.getLinesPicked().size()));
                        p.sendMessage("You don't have enough money for this bet!");
                        break;
                    } else if (slotsInventory.getLinesPicked().size() == 0) {
                        p.sendMessage("You haven't picked any lines!");
                        break;
                    } else {
                        if (slotsInventory.getLinesPicked().size() > 1) p.sendMessage(String.format("You picked more than 1 line, so your bet was multiplied by %s.", slotsInventory.getLinesPicked().size()));
                        if (slotsInventory.getLinesPicked().size() == 5 && slotsInventory.getBet() >= Main.getSlotsConfig().getInt("MinimumBet")) p.sendMessage("5% of your bet was added to the jackpot.");

                        boolean isJackpot = (slotsInventory.getLinesPicked().size() == 5 && slotsInventory.getBet() >= Main.getSlotsConfig().getInt("MinimumBet"));

                        List<ItemStack> slot1 = slotsInventory.getSlot1();
                        List<ItemStack> slot2 = slotsInventory.getSlot2();
                        List<ItemStack> slot3 = slotsInventory.getSlot3();

                        Random r = new Random();

                        Main.currentlyRollingSlots.add(p);

                        //How long the first reel will spin; The second reel will stop 1 second after reel 1 and reel 3 will stop 1 second after reel 2.
                        int initialTicksToRun = r.nextInt(180) + 20;
                        int reel1Speed = r.nextInt(4) + 1;
                        int reel2Speed = r.nextInt(4) + 1;
                        int reel3Speed = r.nextInt(4) + 1;

                        final int[] pointerAtBottomSlot1 = {2};
                        final int[] pointerAtBottomSlot2 = {2};
                        final int[] pointerAtBottomSlot3 = {2};

                        Inventory inventory = event.getView().getTopInventory();

                        for (int i = 1; i <= initialTicksToRun; i++) {
                            if ((i % reel1Speed) == 0) {
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        pointerAtBottomSlot1[0] = pointerAtBottomSlot1[0] - 1;
                                        if (pointerAtBottomSlot1[0] < 0) {
                                            pointerAtBottomSlot1[0] = 8;
                                        }

                                        if (pointerAtBottomSlot1[0] > 1) {
                                            inventory.setItem(20, slot1.get(pointerAtBottomSlot1[0] - 2));
                                            inventory.setItem(29, slot1.get(pointerAtBottomSlot1[0] - 1));
                                            inventory.setItem(38, slot1.get(pointerAtBottomSlot1[0]));
                                        } else {
                                            inventory.setItem(38, slot1.get(pointerAtBottomSlot1[0]));

                                            if (pointerAtBottomSlot1[0] - 1 < 0) inventory.setItem(29, slot1.get(pointerAtBottomSlot1[0] + 8));
                                            else inventory.setItem(29, slot1.get(pointerAtBottomSlot1[0] - 1));

                                            if (pointerAtBottomSlot1[0] - 2 < 0) inventory.setItem(20, slot1.get(pointerAtBottomSlot1[0] + 7));
                                            else inventory.setItem(20, slot1.get(pointerAtBottomSlot1[0] - 2));
                                        }
                                    }
                                }.runTaskLaterAsynchronously(Main.instance, i);
                            }
                        }

                        for (int i = 1; i <= initialTicksToRun+20; i++) {
                            if ((i % reel2Speed) == 0) {
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        pointerAtBottomSlot2[0]++;
                                        if (pointerAtBottomSlot2[0] > 8) {
                                            pointerAtBottomSlot2[0] = 0;
                                        }

                                        if (pointerAtBottomSlot2[0] > 1) {
                                            inventory.setItem(21, slot2.get(pointerAtBottomSlot2[0] - 2));
                                            inventory.setItem(30, slot2.get(pointerAtBottomSlot2[0] - 1));
                                            inventory.setItem(39, slot2.get(pointerAtBottomSlot2[0]));
                                        } else {
                                            inventory.setItem(39, slot2.get(pointerAtBottomSlot2[0]));

                                            if (pointerAtBottomSlot2[0] - 1 < 0) inventory.setItem(30, slot2.get(pointerAtBottomSlot2[0] + 8));
                                            else inventory.setItem(30, slot2.get(pointerAtBottomSlot2[0] - 1));

                                            if (pointerAtBottomSlot2[0] - 2 < 0) inventory.setItem(21, slot2.get(pointerAtBottomSlot2[0] + 7));
                                            else inventory.setItem(21, slot2.get(pointerAtBottomSlot2[0] - 2));
                                        }
                                    }
                                }.runTaskLaterAsynchronously(Main.instance, i);
                            }
                        }

                        for (int i = 1; i <= initialTicksToRun+40; i++) {
                            if ((i % reel3Speed) == 0) {
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        pointerAtBottomSlot3[0] = pointerAtBottomSlot3[0] - 1;
                                        if (pointerAtBottomSlot3[0] < 0) {
                                            pointerAtBottomSlot3[0] = 8;
                                        }

                                        if (pointerAtBottomSlot3[0] > 1) {
                                            inventory.setItem(22, slot3.get(pointerAtBottomSlot3[0] - 2));
                                            inventory.setItem(31, slot3.get(pointerAtBottomSlot3[0] - 1));
                                            inventory.setItem(40, slot3.get(pointerAtBottomSlot3[0]));
                                        } else {
                                            inventory.setItem(40, slot3.get(pointerAtBottomSlot3[0]));

                                            if (pointerAtBottomSlot3[0] - 1 < 0) inventory.setItem(31, slot3.get(pointerAtBottomSlot3[0] + 8));
                                            else inventory.setItem(31, slot3.get(pointerAtBottomSlot3[0] - 1));

                                            if (pointerAtBottomSlot3[0] - 2 < 0) inventory.setItem(22, slot3.get(pointerAtBottomSlot3[0] + 7));
                                            else inventory.setItem(22, slot3.get(pointerAtBottomSlot3[0] - 2));
                                        }
                                    }
                                }.runTaskLaterAsynchronously(Main.instance, i);
                            }
                        }



                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Main.currentlyRollingSlots.remove(p);
                                List<String> linesPicked = slotsInventory.getLinesPicked();
                                int initalBet = slotsInventory.getBet();
                                int bet = initalBet*linesPicked.size();





                                int winTotal = 0;
                                boolean wonJackpot = false;
                                p.sendMessage("§b[----------------§aResults§b----------------]");
                                int totalLinesPicked = 0;

                                if (linesPicked.contains("one")) {
                                    totalLinesPicked++;
                                    if (inventory.getItem(29).equals(inventory.getItem(30)) && inventory.getItem(30).equals(inventory.getItem(31))) {
                                        ItemStack i = inventory.getItem(29);
                                        int win = Main.getSlotsConfig().getInt(i.getItemMeta().getDisplayName().toLowerCase().replace("§r", ""));
                                        p.sendMessage("                      §fLine 1: §aWIN");
                                        p.sendMessage(String.format("                      §7(%s: %s:1)", i.getItemMeta().getDisplayName().replace("§r", ""), win));

                                        if (isJackpot) {
                                            String toCompare = i.getItemMeta().getDisplayName().toLowerCase().replace("§r", "");
                                            String jackpotIcon = Main.getSlotsConfig().getString("JackpotIcon");
                                            if (toCompare.equals(jackpotIcon)) {
                                                wonJackpot = true;
                                                p.sendMessage(String.format("                      §6You won the jackpot! $%s", Main.getSlotsConfig().getInt("CurrentJackpot")));
                                                Bukkit.broadcastMessage(String.format("§a[Casino] §6%s §9just won the slots jackpot of §6$%s§9! It has been reset to §6$%s.", event.getWhoClicked().getName(),  Main.getSlotsConfig().getInt("CurrentJackpot"), Main.getSlotsConfig().getInt("DefaultJackpot")));
                                                winTotal = winTotal + Main.getSlotsConfig().getInt("CurrentJackpot");
                                                Main.getSlotsConfig().set("CurrentJackpot", Main.getSlotsConfig().getInt("DefaultJackpot"));
                                                Main.saveSlotsConfig();

                                                for (int i1 = 1; i1 <= 5; i1++) {
                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {
                                                            Firework fw = (Firework) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                                                            FireworkMeta fwm = fw.getFireworkMeta();

                                                            fwm.setPower(3);
                                                            fwm.addEffect(FireworkEffect.builder().withColor(Color.YELLOW).flicker(true).build());

                                                            fw.setFireworkMeta(fwm);
                                                            fw.detonate();
                                                        }
                                                    }.runTaskLater(Main.instance, i1);
                                                }
                                            }
                                        }

                                        winTotal = winTotal + (initalBet * win);
                                    } else {
                                        p.sendMessage("                      §fLine 1: §cLOSS");
                                    }
                                }

                                if (linesPicked.contains("two")) {
                                    totalLinesPicked++;
                                    if (inventory.getItem(20).equals(inventory.getItem(21)) && inventory.getItem(21).equals(inventory.getItem(22))) {
                                        ItemStack i = inventory.getItem(20);
                                        int win = Main.getSlotsConfig().getInt(i.getItemMeta().getDisplayName().toLowerCase().replace("§r", ""));
                                        p.sendMessage("                      §9Line 2: §aWIN");
                                        p.sendMessage(String.format("                      §7(%s: %s:1)", i.getItemMeta().getDisplayName().replace("§r", ""), win));
                                        winTotal = winTotal + (initalBet * win);
                                    } else {
                                        p.sendMessage("                      §9Line 2: §cLOSS");
                                    }
                                }

                                if (linesPicked.contains("three")) {
                                    totalLinesPicked++;
                                    if (inventory.getItem(38).equals(inventory.getItem(39)) && inventory.getItem(39).equals(inventory.getItem(40))) {
                                        ItemStack i = inventory.getItem(38);
                                        int win = Main.getSlotsConfig().getInt(i.getItemMeta().getDisplayName().toLowerCase().replace("§r", ""));
                                        p.sendMessage("                      §aLine 3: §aWIN");
                                        p.sendMessage(String.format("                      §7(%s: %s:1)", i.getItemMeta().getDisplayName().replace("§r", ""), win));
                                        winTotal = winTotal + (initalBet * win);
                                    } else {
                                        p.sendMessage("                      §aLine 3: §cLOSS");
                                    }
                                }

                                if (linesPicked.contains("four")) {
                                    totalLinesPicked++;
                                    if (inventory.getItem(20).equals(inventory.getItem(30)) && inventory.getItem(30).equals(inventory.getItem(40))) {
                                        ItemStack i = inventory.getItem(20);
                                        int win = Main.getSlotsConfig().getInt(i.getItemMeta().getDisplayName().toLowerCase().replace("§r", ""));
                                        p.sendMessage("                      §bLine 4: §aWIN");
                                        p.sendMessage(String.format("                      §7(%s: %s:1)", i.getItemMeta().getDisplayName().replace("§r", ""), win));
                                        winTotal = winTotal + (initalBet * win);
                                    } else {
                                        p.sendMessage("                      §bLine 4: §cLOSS");
                                    }
                                }

                                if (linesPicked.contains("five")) {
                                    totalLinesPicked++;
                                    if (inventory.getItem(38).equals(inventory.getItem(30)) && inventory.getItem(30).equals(inventory.getItem(22))) {
                                        ItemStack i = inventory.getItem(38);
                                        int win = Main.getSlotsConfig().getInt(i.getItemMeta().getDisplayName().toLowerCase().replace("§r", ""));
                                        p.sendMessage("                      §cLine 5: §aWIN");
                                        p.sendMessage(String.format("                      §7(%s: %s:1)", i.getItemMeta().getDisplayName().replace("§r", ""), win));
                                        winTotal = winTotal + (initalBet * win);
                                    } else {
                                        p.sendMessage("                      §cLine 5: §cLOSS");
                                    }
                                }

                                if (isJackpot) {
                                    int newBet = (int) (bet - (bet*0.05));
                                    int currentJackpot = Main.getSlotsConfig().getInt("CurrentJackpot");
                                    currentJackpot = (int) (currentJackpot + (bet*0.05));
                                    Main.getSlotsConfig().set("CurrentJackpot", currentJackpot);
                                    Main.saveSlotsConfig();
                                }

                                p.sendMessage(" ");

                                if (winTotal > 0) {
                                    p.sendMessage(String.format("                    §aYou won $%s!", winTotal));
                                    Main.econ.withdrawPlayer(Bukkit.getOfflinePlayer(p.getUniqueId()), bet);
                                    Main.econ.depositPlayer(Bukkit.getOfflinePlayer(p.getUniqueId()), winTotal);
                                } else {
                                    Main.econ.withdrawPlayer(Bukkit.getOfflinePlayer(p.getUniqueId()), bet);
                                    p.sendMessage("                 §cYou didn't win anything!");
                                }

                                p.sendMessage(" ");
                                if (winTotal > bet) {
                                    p.sendMessage(String.format("                         §aProfit: %s", winTotal - bet));
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
                                } else if (bet > winTotal) {
                                    p.sendMessage(String.format("                          §cLoss: %s", bet - winTotal));
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
                                } else {
                                    p.sendMessage("               §5Even: Your bet and win were equal.");
                                }

                                event.getView().getTopInventory().setItem(53, Utils.newItemStackWithNameAndLore(Material.ANVIL, String.format("§rBet: %s", bet), String.format("§rBalance: %s", Main.econ.getBalance(Bukkit.getOfflinePlayer(p.getUniqueId())))));
                                event.getView().getTopInventory().setItem(17, Utils.newItemStackWithNameAndLore(Material.BOOK, "§6Jackpot", String.format("§rPick all 5 lines to have&§ra chance at jackpot!&§rLine up 3 of §a%s§r in line 1&§rto win!&§rCurrent jackpot: $%s&§rMinimum initial bet: $%s", Main.getSlotsConfig().getString("JackpotIcon"), Main.getSlotsConfig().getInt("CurrentJackpot"), Main.getSlotsConfig().getInt("MinimumBet"))));

                            }
                        }.runTaskLaterAsynchronously(Main.instance, initialTicksToRun+41);

                    }
                    break;


                default:
                    break;
            }
        }
    }
}
