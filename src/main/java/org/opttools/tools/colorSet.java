package org.opttools.tools;

import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class colorSet {
    //Translate Color Code
    // 定义一个静态的 LegacyComponentSerializer 实例
    private static final LegacyComponentSerializer serializer = LegacyComponentSerializer.legacy('&');

    // Translate Color Code
    public static String CText(String message) {
        return ChatColor.translateAlternateColorCodes('&',message); // 返回最终的字符串
    }
    }



