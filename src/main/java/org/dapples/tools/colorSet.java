package org.dapples.tools;

import org.bukkit.ChatColor;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.md_5.bungee.api.ChatColor.COLOR_CHAR;

public class colorSet {
    //&1~9,&a~z
    public static String CText(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
