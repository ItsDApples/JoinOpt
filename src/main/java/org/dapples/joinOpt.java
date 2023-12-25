package org.dapples;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.dapples.configs.reloadConfig;
import org.dapples.event.onPlayerExit;
import org.dapples.event.onPlayerJoin;
import org.dapples.tools.checkPlugin;
import org.dapples.papi.pluginMessage;
import org.dapples.bstats.bstatsConfig;

public final class joinOpt extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        // BStats链接
        bstatsConfig.startBstats();

        //发送开启提示信息
        pluginMessage.sendStartMessage();

        //写入Config.yml
        this.saveDefaultConfig();

        //检查插件状态
        checkPlugin.checkPapi();
        checkPlugin.checkConfigVersion();

        //注册事件
        getServer().getPluginManager().registerEvents(new onPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new onPlayerExit(),this);
        Bukkit.getPluginCommand("jt").setExecutor(new reloadConfig());
    }

    @Override
    public void onDisable() {
        // 当插件关闭时
    }
}
