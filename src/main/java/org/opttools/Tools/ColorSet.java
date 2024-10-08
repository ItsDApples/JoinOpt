package org.opttools.Tools;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorSet {

    public static String output(String string) {

        string = ChatColor.translateAlternateColorCodes(ChatColor.COLOR_CHAR, string);
        // Translate hex code
        string = replaceRegex("!#[0-9,a-f,A-F]{6}", string);
        string= replaceRegex("&#[0-9,a-f,A-F]{6}", string);
        string = ChatColor.translateAlternateColorCodes('&', string);
        // Return
        return string;

    }

    private static String replaceRegex(String regex, String input) {

        int i = 0;

        ArrayList<String> matches = new ArrayList<>();
        ArrayList<ChatColor> colorSet = new ArrayList<>();
        Matcher patternMatcher = Pattern.compile(regex).matcher(input);

        while(patternMatcher.find()) {
            matches.add(patternMatcher.group());
        }
        for(String match : matches) {
            colorSet.add(ChatColor.of(match.substring(1)));
        }

        Iterator<String> matchIterator = matches.iterator();
        Iterator<ChatColor> colorIterator = colorSet.iterator();

        while(matchIterator.hasNext() && colorIterator.hasNext()) {
            input = input.replaceFirst(matchIterator.next(), colorIterator.next().toString());
        }

        return input;

    }
}
