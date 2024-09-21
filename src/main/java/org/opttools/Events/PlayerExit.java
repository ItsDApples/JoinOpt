package org.opttools.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.opttools.Tools.ComponentBuilder;
import org.opttools.Tools.ConfigManager;
import org.opttools.Tools.LogMessages;

import javax.swing.*;

import static org.opttools.Tools.ComponentBuilder.clearLists;
import static org.opttools.Tools.ConfigManager.getBoolean;

public class PlayerExit implements Listener {
    @EventHandler
    public static void PlayerExitEvent(PlayerQuitEvent e){

        // Exit Logic
        if (getBoolean("PlayerExit.enable")){
            e.setQuitMessage(null);
            LogMessages.Default(ComponentBuilder.returnMessages(e.getPlayer(),"PlayerExit"));
        }

    }
}
