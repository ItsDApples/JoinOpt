package org.opttools.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.opttools.Tools.ComponentBuilder;
import org.opttools.Tools.ConfigManager;
import org.opttools.Tools.LogMessages;

import static org.opttools.Tools.ComponentBuilder.clearLists;
import static org.opttools.Tools.ConfigManager.getBoolean;
import static org.opttools.Tools.RewardsBuilder.timer;

public class PlayerJoin implements Listener {

    public static Player Newbie = null;

    @EventHandler
    public static void PlayerJoinEvent(PlayerJoinEvent e){

        if (e.getPlayer().hasPlayedBefore()){
            // Join Logic
            if (getBoolean("PlayerJoin.enable")){
                e.setJoinMessage(null);
                LogMessages.Default(ComponentBuilder.returnMessages(e.getPlayer(),"PlayerJoin"));
            }
        }else {
            // First Join Logic
            if (getBoolean("FirstJoin.enable")){
                Newbie = e.getPlayer();
                e.setJoinMessage(null);
                LogMessages.Default(ComponentBuilder.returnMessages(e.getPlayer(),"FirstJoin"));
                timer();
            }
        }

    }
}
