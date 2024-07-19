package org.opttools.event;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.opttools.config.loadVariable;
import org.opttools.papi.pluginMessage;
import org.opttools.tools.colorSet;

import java.util.regex.Pattern;

public class PlayerExit implements Listener {


    @EventHandler
    public static void onPlayerExit(PlayerQuitEvent e) {
        loadVariable.load();
        //Get Player
        Player exitPlayer = e.getPlayer();
        if (loadVariable.enable) {
            //Set Quit Message = null
            e.setQuitMessage(null);
            //Replace {eventPlayer}
            String prefix1 = loadVariable.prefix.replace("{eventPlayer}", e.getPlayer().getName());
            String suffix1 = loadVariable.suffix.replace("{eventPlayer}", e.getPlayer().getName());
            String name1 = loadVariable.name.replace("{eventPlayer}", e.getPlayer().getName());
            String clickAction1 = loadVariable.clickAction.replace("{eventPlayer}", e.getPlayer().getName());
            String autoAction1 = loadVariable.autoAction.replace("{eventPlayer}", e.getPlayer().getName());
            //Add PlaceholderAPI
            String prefix2 = PlaceholderAPI.setPlaceholders(e.getPlayer(), prefix1);
            String suffix2 = PlaceholderAPI.setPlaceholders(e.getPlayer(), suffix1);
            String name2 = PlaceholderAPI.setPlaceholders(e.getPlayer(), name1);
            String clickAction2 = PlaceholderAPI.setPlaceholders(e.getPlayer(), clickAction1);
            String autoAction2 = PlaceholderAPI.setPlaceholders(e.getPlayer(), autoAction1);
            //Build HoverText
            //Message
            TextComponent message = new TextComponent();
            message.setText(colorSet.CText(prefix2 + name2 + suffix2));
            if (loadVariable.clickType.equals("suggest")){
                ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, clickAction2);
                message.setClickEvent(clickEvent);
            } else if (loadVariable.clickType.equals("run")) {
                ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND,clickAction2);
                message.setClickEvent(clickEvent);
            }else {
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fConfig Error!(Loc: &3{PlayerExit.command.click.type}&f)"));
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fMust Be:{player/console},But Now:{&3" + loadVariable.clickType + "&f}"));
            }
            if (loadVariable.autoType.equals("player")) {
                exitPlayer.chat(autoAction2);
            } else if (loadVariable.autoType.equals("console")) {
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
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fConfig Error!(Loc: &3{PlayerExit.command.auto.type}&f)"));
                Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Error + "&fMust Be:{player/console},But Now:{&3" + loadVariable.autoType + "&f}"));
            }
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.spigot().sendMessage(message);
                e.setQuitMessage(null);
            }
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&8[&c-&8] " + name2));
        }
    }
}
