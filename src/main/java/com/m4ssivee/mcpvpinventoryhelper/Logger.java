package com.m4ssivee.mcpvpinventoryhelper;

public class Logger {

    public static void Log(String text) {
        System.out.println("[Mouse Tweaks For MCPVP] " + text);
    }

    public static void DebugLog(String text) {
        if (Config.debug)
            System.out.println("[Mouse Tweaks For MCPVP] " + text);
    }

}
