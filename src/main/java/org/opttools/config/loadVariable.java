package org.opttools.config;

public class loadVariable {
    //PlayerJoin
    public static Boolean jenable;
    public static String jname;
    public static String jprefix;
    public static String jsuffix;
    public static String jclickType;
    public static String jclickAction;
    public static String jautoType;
    public static String jautoAction;
    //FirstJoin
    public static Boolean firstEnable;
    public static String firstName;
    public static String firstPrefix;
    public static String firstSuffix;
    public static String firstAutoType;
    public static String firstAutoAction;
    public static String firstClickType;
    public static Integer firstRewardsTime;
    public static String firstWelcomeMessage;
    public static String firstClickAction;
    public static String firstWelcomeRewardsType;
    public static String firstWelcomeRewardsAction;
    public static Boolean welcomeEnable;
    public static String firstWelcomeRewardsMessage;
    //PlayerExit
    public static String name;
    public static String prefix;
    public static String suffix;
    public static String clickType;
    public static String clickAction;
    public static String autoType;
    public static String autoAction;
    public static boolean enable;
    public static void load(){


        //PlayerJoin
        jname = configTools.<String>getConfig("PlayerJoin.name",String.class);
        jprefix = configTools.<String>getConfig("PlayerJoin.prefix",String.class);
        jsuffix = configTools.<String>getConfig("PlayerJoin.suffix",String.class);
        jclickType = configTools.<String>getConfig("PlayerJoin.actions.click.type",String.class);
        jclickAction = configTools.<String>getConfig("PlayerJoin.actions.click.action",String.class);
        jautoType = configTools.<String>getConfig("PlayerJoin.actions.auto.type",String.class);
        jautoAction = configTools.<String>getConfig("PlayerJoin.actions.auto.action",String.class);
        jenable = configTools.<Boolean>getConfig("PlayerJoin.enable",Boolean.class);

        //FirstJoin
        firstName = configTools.<String>getConfig("FirstJoin.name",String.class);
        firstPrefix = configTools.<String>getConfig("FirstJoin.prefix",String.class);
        firstSuffix = configTools.<String>getConfig("FirstJoin.suffix",String.class);
        firstClickType = configTools.<String>getConfig("FirstJoin.actions.click.type",String.class);
        firstClickAction = configTools.<String>getConfig("FirstJoin.actions.click.action",String.class);
        firstAutoType = configTools.<String>getConfig("FirstJoin.actions.auto.type",String.class);
        firstAutoAction = configTools.<String>getConfig("FirstJoin.actions.auto.action",String.class);
        firstEnable = configTools.<Boolean>getConfig("FirstJoin.enable",Boolean.class);
        firstRewardsTime = configTools.<Integer>getConfig("FirstJoin.actions.welcomeRewards.time",Integer.class);
        firstWelcomeMessage = configTools.<String>getConfig("FirstJoin.actions.welcomeRewards.message",String.class);
        firstWelcomeRewardsType = configTools.<String>getConfig("FirstJoin.actions.welcomeRewards.rewards.type",String.class);
        firstWelcomeRewardsAction = configTools.<String>getConfig("FirstJoin.actions.welcomeRewards.rewards.action",String.class);
        firstWelcomeRewardsMessage = configTools.<String>getConfig("FirstJoin.actions.welcomeRewards.rewards.message",String.class);
        welcomeEnable = configTools.<Boolean>getConfig("FirstJoin.actions.welcomeRewards.enable",Boolean.class);

        //PlayerExit
        name = configTools.<String>getConfig("PlayerExit.name",String.class);
        prefix = configTools.<String>getConfig("PlayerExit.prefix",String.class);
        suffix = configTools.<String>getConfig("PlayerExit.suffix",String.class);
        clickType = configTools.<String>getConfig("PlayerExit.actions.click.type",String.class);
        clickAction = configTools.<String>getConfig("PlayerExit.actions.click.action",String.class);
        autoType = configTools.<String>getConfig("PlayerExit.actions.auto.type",String.class);
        autoAction = configTools.<String>getConfig("PlayerExit.actions.auto.action",String.class);
        enable = configTools.<Boolean>getConfig("PlayerExit.enable",Boolean.class);

        //Replace
        if (jsuffix.equals("false")){
            jsuffix = " ";
        }
        if (jprefix.equals("false")){
            jprefix = " ";
        }
        if (firstPrefix.equals("false")){
            firstPrefix = " ";
        }
        if (firstSuffix.equals("false")){
            firstSuffix = " ";
        }
        if (prefix.equals("false")){
            prefix = " ";
        }
        if (suffix.equals("false")){
            suffix = " ";
        }

        //Replace
    }


    public static void reload() {
        load();
    }
}
