package org.dapples.papi.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.dapples.joinOpt;

import java.util.List;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class playerExit {
    public static FileConfiguration config = getPlugin(joinOpt.class).getConfig();
    public static String playerExitName = config.getString("playerExit.name");
    public static String playerExitPrefix = config.getString("playerExit.prefix");
    public static String playerExitSuffix = config.getString("playerExit.suffix");
    public static String playerExitClickCommand = config.getString("playerExit.command.click");
    public static String playerExitAutoCommand = config.getString("playerExit.command.auto.command");
    public static String playerExitAutoCommandType = config.getString("playerExit.command.auto.type");
    public static List<String> playerExitHoverText = config.getStringList("playerExit.hoverText");
    public static boolean playerExitIsEnable = config.getBoolean("playerExit.enable");


}
