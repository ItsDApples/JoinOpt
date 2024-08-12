package org.opttools.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.opttools.JoinOpt;
import org.opttools.Tools;

import java.io.File;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class configTools {
    public static void loadConfig() {
        File configFile = new File(getPlugin(JoinOpt.class).getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            getPlugin(JoinOpt.class).saveResource("config.yml", false);
        }
    }
    public static <T> T getConfig(String name, Class<T> returnType) {
            File configFile = new File(getPlugin(JoinOpt.class).getDataFolder(),"config.yml");
            FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
            String value = config.getString(name);
            if (value == null) {
                value = " ";
            }
            try {
                if (returnType == String.class) {
                    return returnType.cast(value);
                } else if (returnType == Integer.class) {
                    return returnType.cast(Integer.valueOf(value));
                } else if (returnType == Boolean.class) {
                    return returnType.cast(Boolean.valueOf(value));
                }
            } catch (ClassCastException e) {
                Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Error + "Config Error"));
                return (T)" ";
            }

        return (T) " ";
    }

}
