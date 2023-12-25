package org.dapples.papi.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.dapples.joinOpt;

import java.util.List;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class playerFirstJoin {
    public static FileConfiguration config = getPlugin(joinOpt.class).getConfig();
    public static String playerFirstJoinName = config.getString("playerFirstJoin.name");
    public static String playerFirstJoinPrefix = config.getString("playerFirstJoin.prefix");
    public static String playerFirstJoinSuffix = config.getString("playerFirstJoin.suffix");
    public static String playerFirstJoinClickCommand = config.getString("playerFirstJoin.command.click");
    public static String playerFirstJoinAutoCommand = config.getString("playerFirstJoin.command.auto.command");
    public static String playerFirstJoinAutoCommandType = config.getString("playerFirstJoin.command.auto.type");
    public static List<String> playerFirstJoinHoverText = config.getStringList("playerFirstJoin.hoverText");
    public static boolean playerFirstJoinIsEnable = config.getBoolean("playerFirstJoin.enable");
}
