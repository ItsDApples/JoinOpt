package org.opttools;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.opttools.Events.PlayerExit;
import org.opttools.Events.PlayerJoin;
import org.opttools.Tools.ConfigManager;
import org.opttools.Tools.LogMessages;
import org.opttools.Tools.PluginLoader;
import org.opttools.Tools.RewardsBuilder;

import java.util.ArrayList;

import static org.opttools.Tools.PluginLoader.CheckDepends;


public final class JoinOpt extends JavaPlugin implements Listener {

    // Get instance of JoinOpt
    private static JoinOpt instance;

    // Plugin startup logic
    @Override
    public void onEnable() {

        // Instance
        instance = this;
        // Configs and Locates
        ConfigManager.loadConfigYml();
        // BStats
        PluginLoader.startBStats();
        // Messages
        LogMessages.onStart();
        // Checks
        CheckDepends();
        // Reg events
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerExit(),this);
        Bukkit.getPluginManager().registerEvents(new RewardsBuilder(),this);

    }

    // Plugin shutdown logic
    @Override
    public void onDisable() {

        LogMessages.onClose();

    }

    // Get JoinOpt's instance
    public static JoinOpt getInstance() {
        return instance;
    }

    // Give rewards
    public static void giveRewards(Player player, ArrayList<String > arrayList) {
        Bukkit.getScheduler().runTask(JoinOpt.getInstance(), () -> {
            for (String command :arrayList) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
            }
        });
    }

}
