package org.opttools.event;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.opttools.config.loadVariable;
import org.opttools.config.loadPlugin;
import org.opttools.Tools;

import java.util.Collections;
import java.util.List;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;


public class Commands implements CommandExecutor, TabExecutor {
    public static FileConfiguration getConfig() {
        return getPlugin(org.opttools.JoinOpt.class).getConfig();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                ((Player) sender).playSound(((Player) sender).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 3, 2);
            }
            sender.sendMessage(" ");
            sender.sendMessage(Tools.CText("&7[&3JoinOpt&7] &fv3.0.1(3)"));
            sender.sendMessage(Tools.CText("&7⨠ &7A plugin for edit &fPlayerJoin/Exit &7messages"));
            sender.sendMessage(Tools.CText("&7 "));
            sender.sendMessage(Tools.CText("&7⨠ &7Author: &fDApples_"));
            sender.sendMessage(Tools.CText("&7 "));
            //Website
            TextComponent Website = new TextComponent();
            Website.setText(Tools.CText("&7[&f۩ Website&7]"));
            ClickEvent eventWebsite = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://itsdapples.github.io/OptTools-Docs/");
            HoverEvent hoverWebsite = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(Tools.CText("&7Click To Open")));
            Website.setHoverEvent(hoverWebsite);
            Website.setClickEvent(eventWebsite);
            //Doc
            TextComponent doc = new TextComponent();
            doc.setText(Tools.CText("&7[&f\uD83D\uDDCE Documentation&7]"));
            ClickEvent eventDoc = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://itsdapples.github.io/OptTools-Docs/docs/JoinOpt/");
            HoverEvent hoverDoc = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(Tools.CText("&7Click To Open")));
            doc.setClickEvent(eventDoc);
            doc.setHoverEvent(hoverDoc);
            //Github
            TextComponent github = new TextComponent();
            github.setText(Tools.CText("&7[&f⛏ &fGithub&7]"));
            ClickEvent eventGithub = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/ItsDApples/JoinOpt");
            HoverEvent hoverGithub = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(Tools.CText("&7Click To Open")));
            github.setHoverEvent(hoverGithub);
            github.setClickEvent(eventGithub);
            TextComponent nu = new TextComponent();
            nu.setText("    ");
            TextComponent link = new TextComponent();
            link.setText(Tools.CText("&fLinks: "));
            sender.spigot().sendMessage(link, Website, nu, doc, nu, github);
            sender.sendMessage(" ");
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            if (sender instanceof Player) {
                sender.sendMessage(Tools.CText(loadPlugin.Tips + "&fReloaded"));
                ((Player) sender).playSound(((Player) sender).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 3, 2);
                loadVariable.load();
                loadPlugin.checkConfigVersion();
            } else {
                sender.sendMessage(Tools.CText(loadPlugin.Tips + "&fReloaded"));
            }

        } else {
            sender.sendMessage(Tools.CText(loadPlugin.Error + "&fThis Command Cannot be Found"));
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length > 1) return null;
            return Collections.singletonList("reload");
        }
        return null;
    }

}