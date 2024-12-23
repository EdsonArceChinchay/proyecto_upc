package com.tdp.ct.web.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Random;

import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;

public class DateUtils {

    public static ZonedDateTime getCurrentDate() {
        return ZonedDateTime.now();
    }

    public static String getFormattedCurrentDate(String format) {
        return formatDate(getCurrentDate(), format);
    }

    public static String getNextDayFormatted(String format) {
        ZonedDateTime nextDay = getCurrentDate().plusDays(1);
        return formatDate(nextDay, format);
    }

    public static String getEndOfMonthNextDayFormatted(String format) {
        ZonedDateTime nextDay = getCurrentDate().plusDays(1);
        ZonedDateTime endOfMonth = nextDay.with(TemporalAdjusters.lastDayOfMonth());
        return formatDate(endOfMonth, format);
    }

    public static String generate18DigitString() {
        return getFormattedCurrentDate("yyyyMMdd") + generateRandomDigits(10);
    }

    private static String formatDate(ZonedDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }

    private static String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder randomDigits = new StringBuilder();
        for (int i = 0; i < length; i++) {
            randomDigits.append(random.nextInt(10));
        }
        return randomDigits.toString();
    }

    public static void formatTime(long time, String msg) {
        try {
            String message = String.format("%s - Time of execution: %s", msg, formatTime(time));
            logInfo(message);
        } catch (Exception e) {
            logSevere(String.format("ERROR %s", e.getMessage()));
        }
    }

    private static String formatTime(long time) {
        if (time < 60000) {
            return String.format("%d seconds", time / 1000);
        } else if (time < 3600000) {
            long minutes = time / 60000;
            long seconds = (time % 60000) / 1000;
            return String.format("%d minutes and %d seconds", minutes, seconds);
        } else {
            long hours = time / 3600000;
            long minutes = (time % 3600000) / 60000;
            long seconds = (time % 60000) / 1000;
            return String.format("%d hours, %d minutes and %d seconds", hours, minutes, seconds);
        }
    }
}
