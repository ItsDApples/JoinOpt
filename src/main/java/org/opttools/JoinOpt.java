package org.opttools;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.opttools.event.Commands;
import org.opttools.config.configTools;
import org.opttools.event.PlayerExit;
import org.opttools.event.PlayerJoin;
import org.opttools.config.loadPlugin;
import org.opttools.event.WelcomeRewards;


public final class JoinOpt extends JavaPlugin implements Listener {
    public static Economy econ = null;
    @Override
    public void onEnable() {

        //Bstats
        loadPlugin.startBstats();
        //Start Message
        loadPlugin.sendStartMessage();
        //Load Config
        configTools.loadConfig();
        //Papi/vault
        loadPlugin.checkPapi();
        loadPlugin.checkVault();
        if (!setupEconomy() ) {
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Error + "Error when link Vault!" + getDescription().getName()));
            return;
        }
        //Check Plugin
        loadPlugin.checkConfigVersion();
        //Reg Event
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerExit(),this);
        getServer().getPluginManager().registerEvents(new WelcomeRewards(), this);
        //Reg Command
        Bukkit.getPluginCommand("joinopt").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        //Stop Message
        loadPlugin.sendStopMessage();
    }
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}
