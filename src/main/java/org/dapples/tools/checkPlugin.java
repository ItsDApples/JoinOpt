package org.dapples.tools;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.dapples.joinOpt;
import org.dapples.papi.pluginMessage;

import java.io.File;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class checkPlugin {
    public static void checkPapi() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");
        File papiFile = new File("plugins/PlaceholderAPI.jar");
        String downloadURL = "https://www.spigotmc.org/resources/placeholderapi.6245/";
        if (plugin == null) {
            papiFile.delete();
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fCan't Hook PlaceholderAPI,Please update/download it"));
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Tips + "&fDownload Link: &7https://www.spigotmc.org/resources/placeholderapi.6245/"));
            Bukkit.getPluginManager().disablePlugin(getPlugin(joinOpt.class));
        } else {
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fSuccessful link PlaceholderAPI!"));
        }
    }

    public static void checkConfigVersion() {
        FileConfiguration config = getPlugin(joinOpt.class).getConfig();
        String Versionconfig = config.getString("version");
        String trueVersion = "v2-201";
        if (!Versionconfig.equals(trueVersion)) {
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Warning + "&fError Config Version:"));
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Warning + "&fMust Be: ⌈ " + trueVersion + " ⌋"));
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Warning + "&fBut Now: ⌈ " + Versionconfig + " ⌋"));
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Warning + "&fPlease delete config.yml or edit you config"));
        } else {
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fConfig version: " + trueVersion));
        }
    }
}

