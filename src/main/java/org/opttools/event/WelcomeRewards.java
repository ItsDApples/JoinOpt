package org.opttools.event;

import me.clip.placeholderapi.PlaceholderAPI;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.opttools.JoinOpt;
import org.opttools.Tools;
import org.opttools.config.Vault;
import org.opttools.config.loadPlugin;
import org.opttools.config.loadVariable;


import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.opttools.config.loadPlugin.hasPapi;
import static org.opttools.config.loadPlugin.hasVault;
import static org.opttools.event.PlayerJoin.*;


public class WelcomeRewards implements Listener {
    public static ArrayList<Player> welcomePlayer2;
    @EventHandler
    public static void onPlayerChat(PlayerChatEvent e) {
        if (rewardsTime){
            GotPlayer.add(Jplayer);
            welcomePlayer2 = getOnlinePlayersArray(welcomePlayer);
            if(e.getPlayer() != Jplayer && !Tools.isPlayerInArray(GotPlayer,e.getPlayer())){
                if (Tools.isPlayerInArray(welcomePlayer2,e.getPlayer())) {
                    if (e.getMessage().equalsIgnoreCase(loadVariable.firstWelcomeMessage)) {
                        if (loadVariable.firstWelcomeRewardsType.equals("coin")) {
                            if (hasVault) {
                                int coin = Integer.parseInt(loadVariable.firstWelcomeRewardsAction);
                                Vault.giveCoins(e.getPlayer(),coin);
                            }else {
                                e.getPlayer().sendMessage(Tools.CText(loadPlugin.Error + "&cCant give money, missing VaultAPI, please contact admin"));
                            }
                        } else if (loadVariable.firstWelcomeRewardsType.equals("command")) {
                            String Action1 = null;
                            String Action2 = null;
                            if (hasPapi){
                                Action1 = loadVariable.firstWelcomeRewardsAction.replace("{eventPlayer}", e.getPlayer().getName());
                                Action2 = PlaceholderAPI.setPlaceholders(e.getPlayer(),Action1);
                            }else {
                                Action2 = loadVariable.firstWelcomeRewardsAction.replace("{eventPlayer}", e.getPlayer().getName());
                            }
                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String regex = "^/.*";
                            Pattern pattern = Pattern.compile(regex);
                            boolean matches = pattern.matcher(Action2).matches();
                            if (matches) {
                                String Action3 = Action2.replace("/","");
                                System.out.println(Action3);
                                Bukkit.getServer().dispatchCommand(console,Action3);
                            } else {
                                Bukkit.broadcastMessage(Action2);
                            }
                        }
                    }
                }
            }

        }
        }

}