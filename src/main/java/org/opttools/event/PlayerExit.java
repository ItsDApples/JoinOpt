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
import org.bukkit.scheduler.BukkitRunnable;
import org.opttools.JoinOpt;
import org.opttools.config.loadVariable;
import org.opttools.config.loadPlugin;
import org.opttools.Tools;

import java.util.regex.Pattern;

import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.hasWhitelist;
import static org.bukkit.plugin.java.JavaPlugin.getPlugin;
import static org.opttools.config.loadPlugin.hasPapi;

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
            String prefix1 = " ";
            String suffix1 = " ";
            String name1 = " ";
            String autoAction1 = " ";
            String clickAction1 = " ";
            String prefix2 = " ";
            String suffix2 = " ";
            String name2 = null;
            String autoAction2 = " ";
            String clickAction2 = " ";
            if (hasPapi) {
                prefix1 = loadVariable.prefix.replace("{eventPlayer}", e.getPlayer().getName());
                suffix1 = loadVariable.suffix.replace("{eventPlayer}", e.getPlayer().getName());
                name1 = loadVariable.name.replace("{eventPlayer}", e.getPlayer().getName());
                clickAction1 = loadVariable.clickAction.replace("{eventPlayer}", e.getPlayer().getName());
                autoAction1 = loadVariable.autoAction.replace("{eventPlayer}", e.getPlayer().getName());
                prefix2 = PlaceholderAPI.setPlaceholders(e.getPlayer(), prefix1);
                suffix2 = PlaceholderAPI.setPlaceholders(e.getPlayer(), suffix1);
                name2 = PlaceholderAPI.setPlaceholders(e.getPlayer(), name1);
                clickAction2 = PlaceholderAPI.setPlaceholders(e.getPlayer(), clickAction1);
                autoAction2 = PlaceholderAPI.setPlaceholders(e.getPlayer(), autoAction1);
            }
            prefix2 = loadVariable.prefix.replace("{eventPlayer}", e.getPlayer().getName());
            suffix2 = loadVariable.suffix.replace("{eventPlayer}", e.getPlayer().getName());
            name2 = loadVariable.name.replace("{eventPlayer}", e.getPlayer().getName());
            clickAction2 = loadVariable.clickAction.replace("{eventPlayer}", e.getPlayer().getName());
            autoAction2 = loadVariable.autoAction.replace("{eventPlayer}", e.getPlayer().getName());
            //Message
            TextComponent message = new TextComponent();
            message.setText(Tools.CText(prefix2 + name2 + suffix2));
            if (loadVariable.clickType.equals("suggest")) {
                ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, clickAction2);
                message.setClickEvent(clickEvent);
            } else if (loadVariable.clickType.equals("run")) {
                ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, clickAction2);
                message.setClickEvent(clickEvent);
            } else {
                if (!loadVariable.clickType.equals("false")) {
                    Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Error + "&fConfig Error!(Loc: &3{PlayerExit.command.click.type}&f)"));
                }
            }
            if (loadVariable.autoType.equals("player")) {
                exitPlayer.chat(autoAction2);
            } else if (loadVariable.autoType.equals("console")) {
                ConsoleCommandSender console = getServer().getConsoleSender();
                String regex = "^/.*";
                Pattern pattern = Pattern.compile(regex);
                boolean matches = pattern.matcher(autoAction2).matches();
                if (matches) {
                    String autoAction3 = autoAction2.replace("/", "");
                    System.out.println(autoAction3);
                    getServer().dispatchCommand(console, autoAction3);
                } else {
                    Bukkit.broadcastMessage(autoAction2);
                }
            } else {
                if (!loadVariable.autoType.equals("false")) {
                    Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Error + "&fConfig Error!(Loc: &3{PlayerExit.command.auto.type}&f)"));
                }
            }
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.spigot().sendMessage(message);
                e.setQuitMessage(null);
            }
            Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Normal + "&8[&c-&8] " + name2));
        }

        }
    }

