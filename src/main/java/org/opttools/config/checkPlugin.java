package org.opttools.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.opttools.JoinOpt;
import org.opttools.papi.pluginMessage;
import org.opttools.tools.colorSet;

import java.io.File;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class checkPlugin {
    //Check hasPlaceholderAPI
    public static void checkPapi() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");
        if (plugin == null) {
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fCan't hook PlaceholderAPI. Please update/download it"));
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Tips + "&fDownload Link: &7https://www.spigotmc.org/resources/placeholderapi.6245/"));
            Bukkit.getPluginManager().disablePlugin(getPlugin(JoinOpt.class));
        } else {
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fSuccessful link PlaceholderAPI!"));
        }
    }

    //Check config version
    public static void checkConfigVersion() {
        int version = configTools.<Integer>getConfig("version",Integer.class);
        int trueVersion = 3;
        if (version != trueVersion ) {
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Warning + "&fError Config Version:"));
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Warning + "&fMust Be: ⌈ " + trueVersion + " ⌋"));
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Warning + "&fBut Now: ⌈ " + version + " ⌋"));
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Warning + "&fPlease delete config.yml or edit you config"));
        } else {
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fConfig version: " + trueVersion));
        }
    }
}

