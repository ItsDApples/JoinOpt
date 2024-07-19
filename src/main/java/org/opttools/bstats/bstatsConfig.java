package org.opttools.bstats;


import org.bukkit.plugin.java.JavaPlugin;
import org.opttools.JoinOpt;

public class bstatsConfig {
    //Bstats
    public static void startBstats() {

        int pluginId = 20494; // <-- Replace with the id of your plugin!
        metrics metrics = new metrics(JavaPlugin.getPlugin(JoinOpt.class), pluginId);

    }

}
