package org.opttools.Tools;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.opttools.JoinOpt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.opttools.Tools.PluginLoader.hasPapi;

public class ConfigManager {

    // Files
    private static File ConfigYmlFile = new File(JoinOpt.getInstance().getDataFolder(), "config.yml");
    private static FileConfiguration configYml;
    private final static String ConfigVersion = "1.0.1";

    // Config.yml
    public static void loadConfigYml(){

        if (!ConfigYmlFile.exists()){
            JoinOpt.getInstance().saveResource("config.yml",false);
        }

        configYml = YamlConfiguration.loadConfiguration(ConfigYmlFile);

        if (!ConfigManager.getString("version").equals(ConfigVersion)){

            LogMessages.Warning("Error version in yaml file: &fconfig.yml&e!");
            LogMessages.Tips("You can delete that file and restart server, plugin will regenerate that file.");

        }else {
            LogMessages.Normal("Config version: " + ConfigVersion);
        }

    }

    public static FileConfiguration ConfigYml(){
        return configYml;
    }

    // Replace list ph
    public static ArrayList<String> replaceListPH(ArrayList<String> list, Player player) {

        ArrayList<String> replacedList = new ArrayList<>();
        for (String string : list) {
            if (hasPapi) {
                String replaced = PlaceholderAPI.setPlaceholders(player, string).replace("{player}",player.getName());
                replacedList.add(replaced);
            }else {
                String replaced = string.replace("{player}",player.getName());
                replacedList.add(replaced);
            }
        }
        return replacedList;

    }

    // Get Configs
    public static String getString(String path) {
        try {
            return configYml.getString(path, " ");
        } catch (Exception e) {
            LogMessages.Error("An internal error occurred. Error code: C1.");
            return " ";
        }
    }

    public static String getString(Player player, String path) {
        try {
            String value = configYml.getString(path, " ");
            if (value == null || value.isEmpty()) {
                return " ";
            }
            if (hasPapi) {
                return PlaceholderAPI.setPlaceholders(player, value).replace("{player}", player.getName());
            } else {
                return value.replace("{player}", player.getName());
            }
        } catch (Exception e) {
            LogMessages.Error("An internal error occurred. Error code: C2.");
            return " ";
        }
    }

    public static Boolean getBoolean(String path) {
        try {
            return configYml.getBoolean(path, false);
        } catch (Exception e) {
            LogMessages.Error("An internal error occurred. Error code: C3.");
            return false;
        }
    }

    public static Integer getInteger(String path) {
        try {
            return configYml.getInt(path, 0);
        } catch (Exception e) {
            LogMessages.Error("An internal error occurred. Error code: C4.");
            return 0;
        }
    }

    public static ArrayList<String> getList(Player player,String path){
        try {
            ArrayList<String> value = (ArrayList<String>) configYml.getStringList(path);
            if (!value.isEmpty()){
                return replaceListPH(value,player);
            }else {
                return value;
            }
        } catch (Exception e) {
            LogMessages.Error("An internal error occurred. Error code: C6.");
            return null;
        }
    }



}
