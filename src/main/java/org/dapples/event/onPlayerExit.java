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
import org.bukkit.event.player.PlayerQuitEvent;
import org.dapples.papi.pluginMessage;
import org.dapples.tools.colorSet;

import static org.dapples.papi.config.playerExit.*;
import static org.dapples.papi.config.playerExit.playerExitName;

public class onPlayerExit implements Listener {
    @EventHandler
    public static void onPlayerExit(PlayerQuitEvent e) {
        Player exitPlayer = e.getPlayer();
        /*1*/
        Bukkit.getConsoleSender().sendMessage("1");
        if (playerExitIsEnable) {//判断是否启用
            e.setQuitMessage(null);
            StringBuilder playerExitHover = new StringBuilder();
            for (String item : playerExitHoverText) {
                playerExitHover.append(item);
                playerExitHover.append("\n");
            }
            String playerExitHoverResult = playerExitHover.toString();//将hoverText的数值转换为List
            /*2*/
            Bukkit.getConsoleSender().sendMessage("2");
            //开始接入placeholderAPI
            String playerExitHoverResult_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerExitHoverResult);
            String playerExitPrefix_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerExitPrefix);
            String playerExitName_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerExitName);
            String playerExitSuffix_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerExitSuffix);
            String playerExitAutoCommand_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerExitAutoCommand);
            String playerExitClickCommand_1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), playerExitClickCommand);
            /*3*/
            Bukkit.getConsoleSender().sendMessage("3");
            //开始调用{eventPlayer}变量
            String playerExitHoverResult_2 = playerExitHoverResult_1.replace("{eventPlayer}", e.getPlayer().getName());
            String playerExitPrefix_2 = playerExitPrefix_1.replace("{eventPlayer}", e.getPlayer().getName());
            String playerExitName_2 = playerExitName_1.replace("{eventPlayer}", e.getPlayer().getName());
            String playerExitSuffix_2 = playerExitSuffix_1.replace("{eventPlayer}", e.getPlayer().getName());
            String playerExitAutoCommand_2 = playerExitAutoCommand_1.replace("{eventPlayer}", e.getPlayer().getName());
            String playerExitClickCommand_2 = playerExitClickCommand_1.replace("{eventPlayer}", e.getPlayer().getName());
            //placeHolderAPI结束
            TextComponent message = new TextComponent();//定义TextComponent
            message.setText(colorSet.CText(playerExitPrefix_2 + playerExitName_2 + playerExitSuffix_2));
            HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(colorSet.CText(playerExitHoverResult_2)));
            message.setHoverEvent(hoverEvent);
            ClickEvent clickCommand = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, playerExitClickCommand_2);
            message.setClickEvent(clickCommand);
            /*4*/
            Bukkit.getConsoleSender().sendMessage("4");
            if (playerExitAutoCommandType.equals("player")) {
                exitPlayer.performCommand(playerExitAutoCommand_2);
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fSuccess makes " + exitPlayer.getName() + " performs a set of instructions"));
            } else if (playerExitAutoCommandType.equals("console")) {
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                Bukkit.getServer().dispatchCommand(console, playerExitAutoCommand_2);
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fSuccess makes " + exitPlayer.getName() + " performs a set of instructions"));
            } else {
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fConfig Error!(Loc: &3{playerExit-command-type}&f)"));
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fMust Be:{player/console},But Now:{&3" + playerExitAutoCommandType + "&f}"));
            }
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.spigot().sendMessage(message);
                e.setQuitMessage(null);
            }
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&8[&c-&8] " + playerExitName_2));
        }
    }
}
