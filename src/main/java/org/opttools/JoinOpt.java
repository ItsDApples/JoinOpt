package org.opttools;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.opttools.bstats.bstatsConfig;
import org.opttools.commands.mainCommand;
import org.opttools.config.configTools;
import org.opttools.event.PlayerExit;
import org.opttools.event.PlayerJoin;
import org.opttools.papi.pluginMessage;
import org.opttools.config.checkPlugin;
import java.util.logging.Logger;

public final class JoinOpt extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        //Bstats
        bstatsConfig.startBstats();
        //Start Message
        pluginMessage.sendStartMessage();
        //Load Config
        configTools.loadConfig();
        //Papi
        checkPlugin.checkPapi();
        //Check Plugin
        checkPlugin.checkConfigVersion();
        //Reg Event
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerExit(),this);
        //Reg Command
        Bukkit.getPluginCommand("joinopt").setExecutor(new mainCommand());
    }

    @Override
    public void onDisable() {
        //Stop Message
        pluginMessage.sendStopMessage();
    }

}
