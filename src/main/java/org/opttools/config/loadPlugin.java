package org.opttools.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.opttools.JoinOpt;
import org.opttools.Tools;
import java.util.Arrays;
import java.util.List;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class loadPlugin {
    //load Plugin
    public static Boolean hasPapi = false;
    public static Boolean hasVault = false;
    //Check hasPlaceholderAPI
    public static void checkPapi() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");
        if (plugin == null) {
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Warning + "&fCan't hook PlaceholderAPI. You may cant use Papi's Placeholder"));
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Tips + "&fDownload Link: &7https://www.spigotmc.org/resources/placeholderapi.6245/"));
        } else {
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Normal + "&fSuccessful link PlaceholderAPI!"));
            hasPapi = true;
        }
    }
    //Check hasVault
    public static void checkVault() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Vault");
        if (plugin == null) {
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Warning + "&fCan't hook Vault. You may cant use welcome reward module"));
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Tips + "&fDownload Link: &7https://www.spigotmc.org/resources/vault.34315/"));
        } else {
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Normal + "&fSuccessful found Vault, Linking..."));
            hasVault = true;
        }
    }

    //Check config version
    public static void checkConfigVersion() {
        int version = configTools.<Integer>getConfig("version",Integer.class);
        int trueVersion = 4;
        if (version != trueVersion ) {
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Warning + "&fError Config Version:"));
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Warning + "&fMust Be: ⌈ " + trueVersion + " ⌋"));
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Warning + "&fBut Now: ⌈ " + version + " ⌋"));
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Warning + "&fPlease delete config.yml or edit you config"));
        } else {
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Normal + "&fConfig version: " + trueVersion));
        }
    }

    //Bstats
    public static void startBstats() {

        int pluginId = 20494; // <-- Replace with the id of your plugin!
        metrics metrics = new metrics(JavaPlugin.getPlugin(JoinOpt.class), pluginId);

    }

    //plugin Messages
    public static String Error = "&8[&3JoinOpt&c(Error)&8]&f ";
    public static String Warning = "&8[&3JoinOpt&e(Warning)&8]&f ";
    public static String Normal = "&8[&3JoinOpt&a(Normal)&8]&f ";
    public static String Tips = "&8[&3JoinOpt&f(Tips)&8]&f ";

    public static void sendStartMessage() {
        List<String> startMessage = Arrays.asList(
                "&8|      &3_       _        ___        _",
                "&8| &3    | | ___ (_)_ __  / _ \\ _ __ | |_",
                "&8| &3 _  | |/ _ \\| | '_ \\| | | | '_ \\| __|",
                "&8| &3| |_| | (_) | | | | | |_| | |_) | |_",
                "&8| &3 \\___/ \\___/|_|_| |_|\\___/| .__/ \\__|",
                "&8|                           &3|_|");
        startMessage.forEach(l -> Bukkit.getConsoleSender().sendMessage(Tools.CText(l)));
        Bukkit.getConsoleSender().sendMessage(Tools.CText(Normal + "&fJoinOpt plugin started successfully"));
    }
    public static void sendStopMessage() {
        List<String> startMessage = Arrays.asList(
                "&8|      &3_       _        ___        _",
                "&8| &3    | | ___ (_)_ __  / _ \\ _ __ | |_",
                "&8| &3 _  | |/ _ \\| | '_ \\| | | | '_ \\| __|",
                "&8| &3| |_| | (_) | | | | | |_| | |_) | |_",
                "&8| &3 \\___/ \\___/|_|_| |_|\\___/| .__/ \\__|",
                "&8|                           &3|_|");
        startMessage.forEach(l -> Bukkit.getConsoleSender().sendMessage(Tools.CText(l)));
        Bukkit.getConsoleSender().sendMessage(Tools.CText(Normal + "&fJoinOpt plugin disable successfully."));
    }
}
