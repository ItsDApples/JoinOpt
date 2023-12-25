package org.dapples.bstats;

import org.bukkit.plugin.java.JavaPlugin;
import org.dapples.joinOpt;

public class bstatsConfig {

    public static void startBstats() {

        int pluginId = 20494; // <-- Replace with the id of your plugin!
        metrics metrics = new metrics(JavaPlugin.getPlugin(joinOpt.class), pluginId);

    }

}
