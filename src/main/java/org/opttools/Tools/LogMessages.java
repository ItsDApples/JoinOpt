package org.opttools.Tools;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

public class LogMessages {

    // Prefix
    public static String Tips = "&8[&3Join&2Opt&7(Tip)&8]&7 ";
    public static String Normal = "&8[&3Join&2Opt&f(Normal)&8]&f ";
    public static String Warning = "&8[&3Join&2Opt&e(Warn)&8]&e ";
    public static String Error = "&8[&3Join&2Opt&c(Error)&8]&c ";

    // Messages
    public static void sendFlag() {
        List<String> flags = Arrays.asList(
                "&8|      &3_       _        ___        _",
                "&8| &3    | | ___ (_)_ __  / _ \\ _ __ | |_",
                "&8| &3 _  | |/ _ \\| | '_ \\| | | | '_ \\| __|",
                "&8| &3| |_| | (_) | | | | | |_| | |_) | |_",
                "&8| &3 \\___/ \\___/|_|_| |_|\\___/| .__/ \\__|",
                "&8|                           &3|_|");
        flags.forEach(l -> Bukkit.getConsoleSender().sendMessage(ColorSet.output(l)));
    }

    public static void onStart(){
        sendFlag();
        Bukkit.getConsoleSender().sendMessage(ColorSet.output(Normal + "Plugin Started."));
        Bukkit.getConsoleSender().sendMessage(ColorSet.output(Tips + "QQ Group: 685429475"));
        Bukkit.getConsoleSender().sendMessage(ColorSet.output(Tips + "Discord: https://discord.gg/EteTr4Pkmd"));
    }

    public static void onClose(){
        sendFlag();
        Bukkit.getConsoleSender().sendMessage(ColorSet.output(Normal + "Plugin Disabled."));
        Bukkit.getConsoleSender().sendMessage(ColorSet.output(Tips + "QQ Group: 685429475"));
        Bukkit.getConsoleSender().sendMessage(ColorSet.output(Tips + "Discord: https://discord.gg/EteTr4Pkmd"));
    }

    // Tips Message
    public static void Tips(String message){
        Bukkit.getConsoleSender().sendMessage(ColorSet.output(Tips + message));
    }

    // Normal Message
    public static void Normal(String message){
        Bukkit.getConsoleSender().sendMessage(ColorSet.output(Normal + message));
    }

    // Warning Message
    public static void Warning(String message){
        Bukkit.getConsoleSender().sendMessage(ColorSet.output(Warning + message));
    }

    // Error Message
    public static void Error(String message){
        Bukkit.getConsoleSender().sendMessage(ColorSet.output(Error + message));
    }

    // Default Message
    public static void Default(BaseComponent[] component){
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(component);
        }
    }

    // Player Message
    public static void Player(Player player,String string){
        player.spigot().sendMessage(TextComponent.fromLegacyText(ColorSet.output(string)));
    }

}
