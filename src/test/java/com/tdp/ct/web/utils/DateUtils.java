package com.tdp.ct.web.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Random;

public class DateUtils {

    public static ZonedDateTime getCurrentDate(){
        return  ZonedDateTime.now();
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
        String datePart = getFormattedCurrentDate("yyyyMMdd");
        String randomPart = generateRandomDigits(10);
        return datePart + randomPart;
    }

    private static String formatDate(ZonedDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }

    private static String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder randomDigits = new StringBuilder();
        for (int i = 0; i < length; i++) {
            randomDigits.append(random.nextInt(10)); // Generates a random digit (0-9)
        }
        return randomDigits.toString();
    }
}
