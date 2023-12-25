package org.dapples.configs;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.dapples.joinOpt;
import org.dapples.papi.pluginMessage;
import org.dapples.tools.colorSet;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;


public class reloadConfig implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length==0){
            sender.sendMessage(" ");
            sender.sendMessage(colorSet.CText("&7⌈&fJoinOpt&7⌋ &7➥ &fv2.0.1(v2-201)"));
            sender.sendMessage(colorSet.CText("&7• &7A plugin for edit &fPlayerJoin/Exit &7info"));
            sender.sendMessage(colorSet.CText("&7•"));
            sender.sendMessage(colorSet.CText("&f•&fAuthor: &7DApples_"));
            sender.sendMessage(colorSet.CText("&7•"));
            sender.sendMessage(colorSet.CText("&7•"));
            //Website
            TextComponent Website = new TextComponent();
            Website.setText(colorSet.CText("&7[&f۩ Website&7]"));
            ClickEvent eventWebsite = new ClickEvent(ClickEvent.Action.OPEN_URL,"https://itsdapples.github.io");
            HoverEvent hoverWebsite = new HoverEvent(HoverEvent.Action.SHOW_TEXT,new Text(colorSet.CText("&7Click To Open")));
            Website.setHoverEvent(hoverWebsite);
            Website.setClickEvent(eventWebsite);
            //Doc
            TextComponent doc =  new TextComponent();
            doc.setText(colorSet.CText("&7[&f⊠ Documentation&7]"));
            ClickEvent eventDoc = new ClickEvent(ClickEvent.Action.OPEN_URL,"https://itsdapples.github.io/docs");
            HoverEvent hoverDoc = new HoverEvent(HoverEvent.Action.SHOW_TEXT,new Text(colorSet.CText("&7Click To Open")));
            doc.setClickEvent(eventDoc);
            doc.setHoverEvent(hoverDoc);
            //Github
            TextComponent github = new TextComponent();
            github.setText(colorSet.CText("&7[⭐ &fGithub&7]"));
            ClickEvent eventGithub = new ClickEvent(ClickEvent.Action.OPEN_URL,"https://github.com/ItsDApples/JoinOpt");
            HoverEvent hoverGithub = new HoverEvent(HoverEvent.Action.SHOW_TEXT,new Text(colorSet.CText("&7Click To Open")));
            github.setHoverEvent(hoverGithub);
            github.setClickEvent(eventGithub);
            TextComponent nu = new TextComponent();
            nu.setText("    ");
            TextComponent link = new TextComponent();
            link.setText(colorSet.CText("&fLinks: "));
            sender.spigot().sendMessage(link,Website,nu,doc,nu,github);
            sender.sendMessage(" ");
            return true;
        }
        if(args[0].equalsIgnoreCase("reload")){
            getPlugin(joinOpt.class).getServer().getPluginManager().disablePlugins();
            getPlugin(joinOpt.class).getServer().getPluginManager().enablePlugin(getPlugin(joinOpt.class));
            sender.sendMessage(colorSet.CText(pluginMessage.Normal + "&fSuccessful Reloaded"));
            Bukkit.getConsoleSender().sendMessage(colorSet.CText(pluginMessage.Normal + "&fSuccessful Reloaded Plugin"));
        }else {
            sender.sendMessage(colorSet.CText(pluginMessage.Error + "&fThis command cannot be found"));
        }
        return true;
    }
}