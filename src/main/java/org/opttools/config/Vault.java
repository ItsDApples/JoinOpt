package org.opttools.config;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.opttools.Tools;

import static org.bukkit.Bukkit.getServer;
import static org.opttools.JoinOpt.econ;
import static org.opttools.event.PlayerJoin.GotPlayer;
import static org.opttools.event.WelcomeRewards.welcomePlayer2;

public class Vault {
        public static void giveCoins(Player player, double amount) {
            EconomyResponse r = econ.depositPlayer(player, amount);
            if(r.transactionSuccess()) {
                player.sendMessage(Tools.CText(loadPlugin.Normal + loadVariable.firstWelcomeRewardsMessage));
                GotPlayer.add(player);
            } else {
                player.sendMessage(Tools.CText(loadPlugin.Error + "Cant give money, Please contact admin"));
            }
        }
    }

