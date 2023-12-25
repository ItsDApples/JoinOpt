package org.dapples.configs;

import org.dapples.joinOpt;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class defaultConfig {
    public static void saveDefaultConfig() {
        getPlugin(joinOpt.class).
                saveDefaultConfig();
    }
}
