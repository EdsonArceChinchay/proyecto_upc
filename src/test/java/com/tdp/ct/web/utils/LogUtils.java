package com.tdp.ct.web.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtils {

    public static void logInfo(String str) {
        Logger.getLogger(LogUtils.class.getName()).log(Level.INFO, String.format("%s.", str));
    }

    public static void logInfo(String str, String value) {
        Logger.getLogger(LogUtils.class.getName()).log(Level.INFO, String.format("%s: %s.", str, value));
    }

    public static void logInfo(String str, int value) {
        Logger.getLogger(LogUtils.class.getName()).log(Level.INFO, String.format("%s: %d.", str, value));
    }

    public static void logInfo(String str, long value) {
        Logger.getLogger(LogUtils.class.getName()).log(Level.INFO, String.format("%s: %d.", str, value));
    }

    public static void logInfo(String str, boolean value) {
        Logger.getLogger(LogUtils.class.getName()).log(Level.INFO, String.format("%s: %b.", str, value));
    }

    public static void logSevere(String str) {
        Logger.getLogger(LogUtils.class.getName()).log(Level.SEVERE, String.format("%s.", str));
    }

    public static void logSevere(String str, String value) {
        Logger.getLogger(LogUtils.class.getName()).log(Level.SEVERE, String.format("%s: %s.", str, value));
    }


}
