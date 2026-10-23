package com.m4ssivee.mcpvpinventoryhelper;

public class Logger {

    public static void Log(String text) {
        System.out.println("[MCPVP Inventory Helper] " + text);
    }

    public static void DebugLog(String text) {
        if (Config.debug)
            System.out.println("[MCPVP Inventory Helper] " + text);
    }

}
