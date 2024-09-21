package org.opttools.Tools;

import org.bukkit.Bukkit;
import org.opttools.JoinOpt;

public class PluginLoader {

    // BStats
    public static void startBStats() {

        int pluginId = 20494; // <-- Replace with the id of your plugin!
        BStats metrics = new BStats(JoinOpt.getInstance(), pluginId);

    }

    // Check depends
    public static Boolean hasPapi = false;
    public static void CheckDepends(){

        // PlaceholderAPI
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            LogMessages.Normal("Successful link plugin: PlaceholderAPI.");
            hasPapi = true;
        }else {
            LogMessages.Warning("Can't find soft depend plugin: PlaceholderAPI.");
            LogMessages.Tips("Download Link: https://www.spigotmc.org/resources/placeholderapi.6245/");
        }

    }

}
