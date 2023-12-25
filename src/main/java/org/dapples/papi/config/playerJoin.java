package org.dapples.papi.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.dapples.joinOpt;

import java.util.List;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class playerJoin {
    public static FileConfiguration config = getPlugin(joinOpt.class).getConfig();
    public static String playerJoinName = config.getString("playerJoin.name");
    public static String playerJoinPrefix = config.getString("playerJoin.prefix");
    public static String playerJoinSuffix = config.getString("playerJoin.suffix");
    public static String playerJoinClickCommand = config.getString("playerJoin.command.click");
    public static String playerJoinAutoCommand = config.getString("playerJoin.command.auto.command");
    public static String playerJoinAutoCommandType = config.getString("playerJoin.command.auto.type");
    public static List<String> playerJoinHoverText = config.getStringList("playerJoin.hoverText");
    public static boolean playerJoinIsEnable = config.getBoolean("playerJoin.enable");


}
