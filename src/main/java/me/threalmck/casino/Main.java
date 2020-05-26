package me.threalmck.casino;

import me.threalmck.casino.inventories.RouletteInventory;
import me.threalmck.casino.inventories.SlotsInventory;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import me.threalmck.casino.commands.*;
import me.threalmck.casino.listeners.*;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main extends JavaPlugin {
    public static File dbFile;
    public static FileConfiguration dbConfig;
    public static File slotsFile;
    public static FileConfiguration slotsConfig;
    public static Plugin instance;
    public static Economy econ;
    public static HashMap<Player, RouletteInventory> currentRouletteMap = new HashMap<>();
    public static HashMap<Player, SlotsInventory> currentSlotsMap = new HashMap<>();
    public static List<Player> currentlyRollingSlots = new ArrayList<>();

    @Override
    public void onEnable() {
        if (!setupEconomy()) {
            this.getLogger().severe("Disabled due to no Vault dependency found!");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        instance = this;

        this.getCommand("setgamebutton").setExecutor(new SetGameButton());

        getServer().getPluginManager().registerEvents(new RouletteButtonListener(), this);
        getServer().getPluginManager().registerEvents(new SlotsButtonListener(), this);
        getServer().getPluginManager().registerEvents(new MainRouletteInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new BackToMainInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new FireworkDamageListener(), this);
        getServer().getPluginManager().registerEvents(new MainSlotsInventoryListener(), this);

        createDbConfig();
        createSlotsConfig();

        //Run broadcast every hour for slots jackpot
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(String.format("§a[Casino] §9The current slots jackpot is §6$%s§9.", Main.getSlotsConfig().getInt("CurrentJackpot")));
            }
        }.runTaskTimer(this, 0L, 72000L);
    }

    public static FileConfiguration getCustomConfig() {
        return dbConfig;
    }

    private void createDbConfig() {
        dbFile = new File(getDataFolder(), "buttons.yml");
        if (!dbFile.exists()) {
            dbFile.getParentFile().mkdirs();
            saveResource("buttons.yml", false);
        }

        dbConfig = new YamlConfiguration();
        try {
            dbConfig.load(dbFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void saveDbConfig() {
        try {
            dbConfig.save(dbFile);
        } catch (Exception e) {e.printStackTrace();}
    }



    public static FileConfiguration getSlotsConfig() {
        return slotsConfig;
    }

    private void createSlotsConfig() {
        slotsFile = new File(getDataFolder(), "slots.yml");
        if (!slotsFile.exists()) {
            slotsFile.getParentFile().mkdirs();
            saveResource("slots.yml", false);
        }

        slotsConfig = new YamlConfiguration();
        try {
            slotsConfig.load(slotsFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void saveSlotsConfig() {
        try {
            slotsConfig.save(slotsFile);
        } catch (Exception e) {e.printStackTrace();}
    }


    private boolean setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) {
            econ = economyProvider.getProvider();
        }
        return (econ != null);
    }

    @Override
    public void onDisable() {
    }
}
