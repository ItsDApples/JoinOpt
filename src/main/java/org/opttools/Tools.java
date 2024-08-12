package org.opttools;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Tools {

    // Translate Color Code
    public static String CText(String message) {
        return ChatColor.translateAlternateColorCodes('&',message); // 返回最终的字符串
    }
    public static boolean isPlayerInArray(ArrayList<Player> playerList, Player playerToCheck) {
        return playerList.contains(playerToCheck);
    }
}



