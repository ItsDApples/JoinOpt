package org.opttools.Tools;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.opttools.JoinOpt;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ComponentBuilder {

    private static CopyOnWriteArrayList<String> clickEventsSuggest = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<String> clickEventsRun = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<String> autoEventsRun = new CopyOnWriteArrayList<>();
    private static String mutiLine;

    public static BaseComponent[] returnMessages(Player player, String prefix) {

        // Build Logic
        BaseComponent[] baseComponents = TextComponent.fromLegacyText(ColorSet.output(ConfigManager.getString(player, prefix + ".message")));

        // Set hover text
        if (ConfigManager.getList(player, prefix + ".hoverTexts") != null){
            HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT,TextComponent.fromLegacyText(converString(ConfigManager.getList(player, prefix + ".hoverTexts"))));
            for (BaseComponent component : baseComponents){
                component.setHoverEvent(hoverEvent);
            }
        }

        ArrayList<String> tempClickEventsRun = new ArrayList<>();
        ArrayList<String> tempClickEventsSuggest = new ArrayList<>();
        ArrayList<String> tempAutoEventsRun = new ArrayList<>();

        for (String s : ConfigManager.getList(player, prefix + ".actions")) {
            if (s.startsWith("[click]")) {
                if (s.contains("[run]")) {
                    tempClickEventsRun.add(s.replace("[click]", "").replace("[run]", ""));
                } else if (s.contains("[suggest]")) {
                    tempClickEventsSuggest.add(s.replace("[click]", "").replace("[suggest]", ""));
                }
            } else if (s.startsWith("[auto]") && s.contains("[run]")) {
                tempAutoEventsRun.add(s.replace("[auto]", "").replace("[run]", ""));
            }
        }

        synchronized (clickEventsRun) {
            clickEventsRun.addAll(tempClickEventsRun);
        }
        synchronized (clickEventsSuggest) {
            clickEventsSuggest.addAll(tempClickEventsSuggest);
        }
        synchronized (autoEventsRun) {
            autoEventsRun.addAll(tempAutoEventsRun);
        }

        addEvent(clickEventsRun, ClickEvent.Action.RUN_COMMAND, baseComponents);
        addEvent(clickEventsSuggest, ClickEvent.Action.SUGGEST_COMMAND, baseComponents);

        // Set click commands
        if (!autoEventsRun.isEmpty()) {
            Bukkit.getScheduler().runTask(JoinOpt.getInstance(), () -> {
                for (String command : autoEventsRun) {
                    player.performCommand(command);
                }
                clearLists();
            });
        }

        return baseComponents;
    }

    private static void addEvent(CopyOnWriteArrayList<String> arrayList, ClickEvent.Action action, BaseComponent[] baseComponents) {

        if (!arrayList.isEmpty()) {
            for (String s : arrayList) {
                ClickEvent clickEvent = new ClickEvent(action, s);
                for (BaseComponent component : baseComponents) {
                    component.setClickEvent(clickEvent);
                }
            }
        }
    }

    public static void clearLists() {
        autoEventsRun.clear();
        clickEventsSuggest.clear();
        clickEventsRun.clear();
    }

    private static String converString(List<String> list){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append("\n");
            }
        }
        return ColorSet.output(sb.toString());
    }

}