package org.opttools.Tools;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.opttools.JoinOpt;

import java.util.ArrayList;
import java.util.UUID;

import static org.opttools.Events.PlayerJoin.Newbie;
import static org.opttools.JoinOpt.giveRewards;

public class RewardsBuilder implements Listener{

    private static ArrayList<UUID> rewarded = new ArrayList<UUID>();
    private static Boolean isTime = false;

    public static void addPlayer(UUID uuid){
        rewarded.add(uuid);
    }

    public static Boolean checkPlayer(UUID uuid){
        return rewarded.contains(uuid);
    }

    public static void reset(){
        rewarded.clear();
    }

    public static void timer() {
        isTime = true;
        new BukkitRunnable() {
            @Override
            public void run() {
                isTime = false;
                reset();
                Newbie = null;
            }
        }.runTaskLater(JoinOpt.getInstance(), 20L*ConfigManager.getInteger("FirstJoin.welcomeRewards.second"));
    }

    @EventHandler
    public static void onPlayerChat(AsyncPlayerChatEvent e) {

        UUID uuid = e.getPlayer().getUniqueId();
        if (isTime && ConfigManager.getBoolean("FirstJoin.welcomeRewards.enable")){
                if (ConfigManager.getList(e.getPlayer(),"FirstJoin.welcomeRewards.keys").contains(e.getMessage().toString())){
                        if (!checkPlayer(uuid) && e.getPlayer() != Newbie){

                            addPlayer(uuid);
                            // Dispatcher commands
                            giveRewards(e.getPlayer(),ConfigManager.getList(e.getPlayer(),"FirstJoin.welcomeRewards.commands"));
                            LogMessages.Player(e.getPlayer(),
                                    ColorSet.output(ConfigManager.getString(e.getPlayer(),"FirstJoin.welcomeRewards.message")));
                        }
                }
        }

    }

}
