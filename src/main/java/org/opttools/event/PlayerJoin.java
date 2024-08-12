package org.opttools.event;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.checkerframework.checker.units.qual.A;
import org.opttools.JoinOpt;
import org.opttools.config.loadVariable;
import org.opttools.config.loadPlugin;
import org.opttools.Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;
import static org.opttools.config.loadPlugin.hasPapi;
import static org.opttools.event.WelcomeRewards.welcomePlayer2;


public class PlayerJoin implements Listener {

    public static ArrayList<Player> GotPlayer = new ArrayList<>();
    public static Player Jplayer;
    public static boolean rewardsTime = false;
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
                String name1 = " ";
                String autoAction1 = " ";
                String prefix1 = " ";
                String suffix1 = " ";
                String name2 = " ";
                String autoAction2 = " ";
                String prefix2 = " ";
                String suffix2 = " ";
                String clickAction1 = " ";
                String clickAction2 = " ";
                if (hasPapi) {
                    name1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.jname);
                    prefix1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.jprefix);
                    suffix1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.jsuffix);
                    clickAction1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.jclickAction);
                    autoAction1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.jautoAction);
                    name2 = name1.replace("{eventPlayer}", e.getPlayer().getName());
                    prefix2 = prefix1.replace("{eventPlayer}", e.getPlayer().getName());
                    suffix2 = suffix1.replace("{eventPlayer}", e.getPlayer().getName());
                    autoAction2 = autoAction1.replace("{eventPlayer}", e.getPlayer().getName());
                    clickAction2 = clickAction1.replace("{eventPlayer}", e.getPlayer().getName());
                }

                //Replace {eventPlayer}
                name2 = loadVariable.jname.replace("{eventPlayer}", e.getPlayer().getName());
                prefix2 = loadVariable.jprefix.replace("{eventPlayer}", e.getPlayer().getName());
                suffix2 = loadVariable.jsuffix.replace("{eventPlayer}", e.getPlayer().getName());
                autoAction2 = loadVariable.jautoAction.replace("{eventPlayer}", e.getPlayer().getName());
                clickAction2 = loadVariable.jclickAction.replace("{eventPlayer}", e.getPlayer().getName());

                //Message
                TextComponent message = new TextComponent();
                message.setText(Tools.CText(prefix2 + name2 + suffix2));
                //BuildHoverText

                if (loadVariable.jclickType.equals("suggest")) {
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, clickAction2);
                    message.setClickEvent(clickEvent);
                } else if (loadVariable.jclickType.equals("run")) {
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, clickAction2);
                    message.setClickEvent(clickEvent);
                } else {
                    if (!loadVariable.jclickType.equals("false")) {
                        Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Error + "&fConfig Error!(Loc: &3{PlayerJoin.command.click.type}&f)"));
                    }
                }
                if (loadVariable.jautoType.equals("player")) {
                    joinPlayer.chat(autoAction2);
                } else if (loadVariable.jautoType.equals("console")) {
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    String regex = "^/.*";
                    Pattern pattern = Pattern.compile(regex);
                    boolean matches = pattern.matcher(autoAction2).matches();
                    if (matches) {
                        String autoAction3 = autoAction2.replace("/", "");
                        System.out.println(autoAction3);
                        Bukkit.getServer().dispatchCommand(console, autoAction3);
                    } else {
                        Bukkit.broadcastMessage(autoAction2);
                    }
                } else {
                    if (!loadVariable.jautoType.equals("false")) {
                        Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Error + "&fConfig Error!(Loc: &3{PlayerJoin.command.auto.type}&f)"));
                    }
                }
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.spigot().sendMessage(message);
                    e.setJoinMessage(null);
                }
                Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Normal + "&8[&a+&8] " + name2));
            }
        } else {
            if (loadVariable.firstEnable) {
                //Set Join Message
                e.setJoinMessage(null);
                //Add PlaceholderAPI
                String firstName1 = " ";
                String firstPrefix1 = " ";
                String firstSuffix1 = " ";
                String firstAutoAction1 = " ";
                String firstClickAction1 = " ";
                String firstName2 = " ";
                String firstPrefix2 = " ";
                String firstSuffix2 = " ";
                String firstAutoAction2 = " ";
                String firstClickAction2 = " ";
                if (hasPapi) {
                    firstName1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.firstName);
                    firstPrefix1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.firstPrefix);
                    firstSuffix1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.firstSuffix);
                    firstAutoAction1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.firstAutoAction);
                    firstClickAction1 = PlaceholderAPI.setPlaceholders(e.getPlayer(), loadVariable.firstClickAction);
                    //Replace {eventPlayer}
                    firstName2 = firstName1.replace("{eventPlayer}", e.getPlayer().getName());
                    firstPrefix2 = firstPrefix1.replace("{eventPlayer}", e.getPlayer().getName());
                    firstSuffix2 = firstSuffix1.replace("{eventPlayer}", e.getPlayer().getName());
                    firstAutoAction2 = firstAutoAction1.replace("{eventPlayer}", e.getPlayer().getName());
                    firstClickAction2 = firstClickAction1.replace("{eventPlayer}", e.getPlayer().getName());
                }else {
                    firstName2 = loadVariable.firstName.replace("{eventPlayer}", e.getPlayer().getName());
                    firstPrefix2 = loadVariable.firstPrefix.replace("{eventPlayer}", e.getPlayer().getName());
                    firstSuffix2 = loadVariable.firstSuffix.replace("{eventPlayer}", e.getPlayer().getName());
                    firstAutoAction2 = loadVariable.firstAutoAction.replace("{eventPlayer}", e.getPlayer().getName());
                    firstClickAction2 = loadVariable.firstClickAction.replace("{eventPlayer}", e.getPlayer().getName());
                }
                //Message
                TextComponent message = new TextComponent();
                message.setText(Tools.CText(firstPrefix2 + firstName2 + firstSuffix2));
                //hoverText
                if (loadVariable.firstClickType.equals("suggest")) {
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, firstClickAction2);
                    message.setClickEvent(clickEvent);
                } else if (loadVariable.firstClickType.equals("run")) {
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, firstClickAction2);
                    message.setClickEvent(clickEvent);
                } else {
                    if (!loadVariable.firstClickType.equals("false")) {
                        Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Error + "&fConfig Error!(Loc: &3{FirstJoin.command.click.type}&f)"));
                    }
                }
                if (loadVariable.firstAutoType.equals("player")) {
                    joinPlayer.chat(firstAutoAction2);
                } else if (loadVariable.firstAutoType.equals("console")) {
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    String regex = "^/.*";
                    Pattern pattern = Pattern.compile(regex);
                    boolean matches = pattern.matcher(firstAutoAction2).matches();
                    if (matches) {
                        String firstAutoAction3 = firstAutoAction2.replace("/", "");
                        System.out.println(firstAutoAction3);
                        Bukkit.getServer().dispatchCommand(console, firstAutoAction3);
                    } else {
                        Bukkit.broadcastMessage(firstAutoAction2);
                    }
                } else {
                    if (!loadVariable.firstAutoType.equals("false")) {
                        Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Error + "&fConfig Error!(Loc: &3{FirstJoin.command.auto.type}&f)"));
                    }
                }
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.spigot().sendMessage(message);
                    e.setJoinMessage(null);
                }
                Bukkit.getConsoleSender().sendMessage(Tools.CText(loadPlugin.Normal + "&8[&b+&8] " + firstName2));
                //Welcome Rewards
                if (loadVariable.welcomeEnable) {
                    if (GotPlayer != null){
                        GotPlayer.clear();
                    }
                    if (welcomePlayer2 != null){
                        welcomePlayer2.clear();
                    }
                    Jplayer = e.getPlayer();
                    rewardsTime = true;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(getPlugin(JoinOpt.class), new Runnable() {
                        @Override
                        public void run() {
                            rewardsTime = false;
                        }
                    }, 20L * loadVariable.firstRewardsTime);
                }

                }
            }
        }
    //welcomeRewards
    public static ArrayList<Player> welcomePlayer = new ArrayList<>();
    public static ArrayList<Player> getOnlinePlayersArray(ArrayList<Player> a) {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            a.add(player);
        }
            return a;
    }
}



