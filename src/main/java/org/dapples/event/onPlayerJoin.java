package org.dapples.event;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.dapples.papi.pluginMessage;
import org.dapples.tools.colorSet;

import static org.dapples.papi.config.playerFirstJoin.*;
import static org.dapples.papi.config.playerJoin.*;

public class onPlayerJoin implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
        Player Eplayer = e.getPlayer();
        if (Eplayer.hasPlayedBefore()) {//判断是否为老玩家
            Player joinPlayer = e.getPlayer();//获取玩家信息
            if (playerJoinIsEnable) {//判断是否启用
                e.setJoinMessage(null);
                StringBuilder playerJoinHover = new StringBuilder();
                for (String item : playerJoinHoverText) {
                    playerJoinHover.append(item);
                    playerJoinHover.append("\n");
                }
                String playerJoinHoverResult = playerJoinHover.toString();//将hoverText的数值转换为List
                //开始接入placeholderAPI
                String playerJoinHoverResult_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerJoinHoverResult);
                String playerJoinPrefix_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerJoinPrefix);
                String playerJoinName_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerJoinName);
                String playerJoinSuffix_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerJoinSuffix);
                String playerJoinAutoCommand_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerJoinAutoCommand);
                String playerJoinClickCommand_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerJoinClickCommand);
                //开始调用{eventPlayer}变量
                String playerJoinHoverResult_2 = playerJoinHoverResult_1.replace("{eventPlayer}", e.getPlayer().getName());
                String playerJoinPrefix_2 = playerJoinPrefix_1.replace("{eventPlayer}", e.getPlayer().getName());
                String playerJoinName_2 = playerJoinName_1.replace("{eventPlayer}", e.getPlayer().getName());
                String playerJoinSuffix_2 = playerJoinSuffix_1.replace("{eventPlayer}", e.getPlayer().getName());
                String playerJoinAutoCommand_2 = playerJoinAutoCommand_1.replace("{eventPlayer}", e.getPlayer().getName());
                String playerJoinClickCommand_2 = playerJoinClickCommand_1.replace("{eventPlayer}", e.getPlayer().getName());
                //placeHolderAPI结束
                TextComponent message = new TextComponent();//定义TextComponent
                message.setText(colorSet.CText(playerJoinPrefix_2 + playerJoinName_2 + playerJoinSuffix_2));
                HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(colorSet.CText(playerJoinHoverResult_2)));
                message.setHoverEvent(hoverEvent);
                ClickEvent clickCommand = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, playerJoinClickCommand_2);
                message.setClickEvent(clickCommand);
                if (playerJoinAutoCommandType.equals("player")) {
                    joinPlayer.performCommand(playerJoinAutoCommand_2);
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fSuccess makes " + joinPlayer.getName() + " performs a set of instructions"));
                } else if (playerJoinAutoCommandType.equals("console")) {
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    Bukkit.getServer().dispatchCommand(console, playerJoinAutoCommand_2);
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fSuccess makes " + joinPlayer.getName() + " performs a set of instructions"));
                } else {
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fConfig Error!(Loc: &3{playerJoin-command-type}&f)"));
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fMust Be:{player/console},But Now:{&3" + playerJoinAutoCommandType + "&f}"));
                }
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.spigot().sendMessage(message);
                    e.setJoinMessage(null);
                }
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&8[&a+&8] " + playerJoinName_2));
            }
        } else {
            if (playerFirstJoinIsEnable) {//判断是否启用
                Player joinPlayer = e.getPlayer();
                e.setJoinMessage(null);
                StringBuilder playerFirstJoinHover = new StringBuilder();
                for (String item : playerFirstJoinHoverText) {
                    playerFirstJoinHover.append(item);
                    playerFirstJoinHover.append("\n");
                }
                String playerFirstJoinHoverResult = playerFirstJoinHover.toString();//将hoverText的数值转换为List
                //开始接入placeholderAPI
                String playerFirstJoinHoverResult_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerFirstJoinHoverResult);
                String playerFirstJoinPrefix_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerFirstJoinPrefix);
                String playerFirstJoinName_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerFirstJoinName);
                String playerFirstJoinSuffix_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerFirstJoinSuffix);
                String playerFirstJoinAutoCommand_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerFirstJoinAutoCommand);
                String playerFirstJoinClickCommand_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerFirstJoinClickCommand);
                //开始调用{eventPlayer}变量
                String playerFirstJoinHoverResult_2 = playerFirstJoinHoverResult_1.replace("{eventPlayer}", e.getPlayer().getName());
                String playerFirstJoinPrefix_2 = playerFirstJoinPrefix_1.replace("{eventPlayer}", e.getPlayer().getName());
                String playerFirstJoinName_2 = playerFirstJoinName_1.replace("{eventPlayer}", e.getPlayer().getName());
                String playerFirstJoinSuffix_2 = playerFirstJoinSuffix_1.replace("{eventPlayer}", e.getPlayer().getName());
                String playerFirstJoinAutoCommand_2 = playerFirstJoinAutoCommand_1.replace("{eventPlayer}", e.getPlayer().getName());
                String playerFirstJoinClickCommand_2 = playerFirstJoinClickCommand_1.replace("{eventPlayer}", e.getPlayer().getName());
                //placeHolderAPI结束
                TextComponent message = new TextComponent();//定义TextComponent
                message.setText(colorSet.CText(playerFirstJoinPrefix_2 + playerFirstJoinName_2 + playerFirstJoinSuffix_2));
                HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(colorSet.CText(playerFirstJoinHoverResult_2)));
                message.setHoverEvent(hoverEvent);
                ClickEvent clickCommand = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, playerFirstJoinClickCommand_2);
                message.setClickEvent(clickCommand);
                if (playerFirstJoinAutoCommandType.equals("player")) {
                    joinPlayer.performCommand(playerFirstJoinAutoCommand_2);
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fSuccess makes " + joinPlayer.getName() + " performs a set of instructions"));
                } else if (playerFirstJoinAutoCommandType.equals("console")) {
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    Bukkit.getServer().dispatchCommand(console, playerFirstJoinAutoCommand_2);
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fSuccess makes " + joinPlayer.getName() + " performs a set of instructions"));
                } else {
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fConfig Error!(Loc: &3{playerFirstJoin-command-type}&f)"));
                    Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fMust Be:{player/console},But Now:{&3" + playerFirstJoinAutoCommandType + "&f}"));
                }
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.spigot().sendMessage(message);
                    e.setJoinMessage(null);
                }
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&8[&b+&8] " + playerFirstJoinName_2));
            }
        }

    }
}


