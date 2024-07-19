package org.opttools.event;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.opttools.JoinOpt;
import org.opttools.config.configTools;
import org.opttools.config.loadVariable;
import org.opttools.papi.pluginMessage;
import org.opttools.tools.colorSet;


import java.util.List;
import java.util.regex.Pattern;

import static org.opttools.commands.mainCommand.getConfig;

public class PlayerJoin implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
        loadVariable.load();
        //Get Player
        Player joinPlayer = e.getPlayer();
        //isFirstJoin?
        if (joinPlayer.hasPlayedBefore()) {
            //Player Join Event
            if (loadVariable.jenable) {
                //Set Join Message = null
                e.setJoinMessage(null);
                //Add PlaceholderAPI
                String name1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.jname);
                String prefix1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.jprefix);
                String suffix1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.jsuffix);
                String clickAction1 = PlaceholderAPI.setPlaceholders(e.getPlayer(),loadVariable.jclickAction);
                String autoAction1 = PlaceholderAPI.setPlaceholders(e.getPlayer(),loadVariable.jautoAction);
                //Replace {eventPlayer}
                String name2 = name1.replace("{eventPlayer}", e.getPlayer().getName());
                String prefix2 = prefix1.replace("{eventPlayer}", e.getPlayer().getName());
                String suffix2 = suffix1.replace("{eventPlayer}", e.getPlayer().getName());
                String autoAction2 = autoAction1.replace("{eventPlayer}", e.getPlayer().getName());
                String clickAction2 = clickAction1.replace("{eventPlayer}", e.getPlayer().getName());

                //Message
                TextComponent message = new TextComponent();
                message.setText(colorSet.CText(prefix2 + name2 + suffix2));
                //BuildHoverText

                if (loadVariable.jclickType.equals("suggest")){
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, clickAction2);
                    message.setClickEvent(clickEvent);
                } else if (loadVariable.jclickType.equals("run")) {
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND,clickAction2);
                    message.setClickEvent(clickEvent);
                }else {
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fConfig Error!(Loc: &3{PlayerJoin.command.click.type}&f)"));
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fMust Be:{player/console},But Now:{&3" + loadVariable.jclickType + "&f}"));
                }
                if (loadVariable.jautoType.equals("player")) {
                    joinPlayer.chat(autoAction2);
                } else if (loadVariable.jautoType.equals("console")) {
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    String regex = "^/.*";
                    Pattern pattern = Pattern.compile(regex);
                    boolean matches = pattern.matcher(autoAction2).matches();
                    if (matches) {
                        String autoAction3 = autoAction2.replace("/","");
                        System.out.println(autoAction3);
                        Bukkit.getServer().dispatchCommand(console,autoAction3);
                    } else {
                        Bukkit.broadcastMessage(autoAction2);
                    }
                } else {
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fConfig Error!(Loc: &3{PlayerJoin.command.auto.type}&f)"));
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fMust Be:{player/console},But Now:{&3" + loadVariable.jautoType + "&f}"));
                }
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.spigot().sendMessage(message);
                    e.setJoinMessage(null);
                }
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&8[&a+&8] " + name2));
            }
        } else {
            if (loadVariable.firstEnable) {
                //Set Join Message
                e.setJoinMessage(null);
                //Add PlaceholderAPI
                String firstName1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.firstName);
                String firstPrefix1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.firstPrefix);
                String firstSuffix1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.firstSuffix);
                String firstAutoAction1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.firstAutoAction);
                String firstClickAction1 = PlaceholderAPI.setPlaceholders(e.getPlayer(),loadVariable.firstClickAction);
                //Replace {eventPlayer}
                String firstName2 = firstName1.replace("{eventPlayer}", e.getPlayer().getName());
                String firstPrefix2 = firstPrefix1.replace("{eventPlayer}", e.getPlayer().getName());
                String firstSuffix2 = firstSuffix1.replace("{eventPlayer}", e.getPlayer().getName());
                String firstAutoAction2 = firstAutoAction1.replace("{eventPlayer}", e.getPlayer().getName());
                String firstClickAction2 = firstClickAction1.replace("{eventPlayer}", e.getPlayer().getName());
                //Message
                TextComponent message = new TextComponent();
                message.setText(colorSet.CText(firstPrefix2 + firstName2 + firstSuffix2));
                //hoverText

                if (loadVariable.firstClickType.equals("suggest")){
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, firstClickAction2);
                    message.setClickEvent(clickEvent);
                } else if (loadVariable.firstClickType.equals("run")) {
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND,firstClickAction2);
                    message.setClickEvent(clickEvent);
                }else {
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fConfig Error!(Loc: &3{FirstJoin.command.click.type}&f)"));
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fMust Be:{player/console},But Now:{&3" + loadVariable.firstClickType + "&f}"));
                }
                if (loadVariable.firstAutoType.equals("player")) {
                    joinPlayer.chat(firstAutoAction2);
                } else if (loadVariable.firstAutoType.equals("console")) {
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    String regex = "^/.*";
                    Pattern pattern = Pattern.compile(regex);
                    boolean matches = pattern.matcher(firstAutoAction2).matches();
                    if (matches) {
                        String firstAutoAction3 = firstAutoAction2.replace("/","");
                        System.out.println(firstAutoAction3);
                        Bukkit.getServer().dispatchCommand(console,firstAutoAction3);
                    } else {
                        Bukkit.broadcastMessage(firstAutoAction2);
                    }
                } else {
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fConfig Error!(Loc: &3{FirstJoin.command.auto.type}&f)"));
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fMust Be:{player/console},But Now:{&3" + loadVariable.firstAutoAction + "&f}"));
                }
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.spigot().sendMessage(message);
                    e.setJoinMessage(null);
                }
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&8[&c-&8] " + firstName2));
            }
        }

    }
}


