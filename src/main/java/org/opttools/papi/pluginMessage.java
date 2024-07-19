package org.opttools.papi;

import org.bukkit.Bukkit;
import org.opttools.tools.colorSet;
import java.util.Arrays;
import java.util.List;

public class pluginMessage {
    public static String Error = "&8[&3JoinOpt&c(Error)&8] ";
    public static String Warning = "&8[&3JoinOpt&e(Warning)&8] ";
    public static String Normal = "&8[&3JoinOpt&a(Normal)&8] ";
    public static String Tips = "&8[&3JoinOpt&f(Tips)&8] ";

    public static void sendStartMessage() {
        List<String> startMessage = Arrays.asList(
                "&8|      &3_       _        ___        _",
                "&8| &3    | | ___ (_)_ __  / _ \\ _ __ | |_",
                "&8| &3 _  | |/ _ \\| | '_ \\| | | | '_ \\| __|",
                "&8| &3| |_| | (_) | | | | | |_| | |_) | |_",
                "&8| &3 \\___/ \\___/|_|_| |_|\\___/| .__/ \\__|",
                "&8|                           &3|_|");
        startMessage.forEach(l -> Bukkit.getConsoleSender().sendMessage(colorSet.CText(l)));
        Bukkit.getConsoleSender().sendMessage(colorSet.CText(Normal + "&fJoinOpt plugin started successfully"));
    }
    public static void sendStopMessage() {
        List<String> startMessage = Arrays.asList(
                "&8|      &3_       _        ___        _",
                "&8| &3    | | ___ (_)_ __  / _ \\ _ __ | |_",
                "&8| &3 _  | |/ _ \\| | '_ \\| | | | '_ \\| __|",
                "&8| &3| |_| | (_) | | | | | |_| | |_) | |_",
                "&8| &3 \\___/ \\___/|_|_| |_|\\___/| .__/ \\__|",
                "&8|                           &3|_|");
        startMessage.forEach(l -> Bukkit.getConsoleSender().sendMessage(colorSet.CText(l)));
        Bukkit.getConsoleSender().sendMessage(colorSet.CText(Normal + "&fJoinOpt plugin disable successfully."));
    }
}
