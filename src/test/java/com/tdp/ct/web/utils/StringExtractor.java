package com.tdp.ct.web.utils;

public class StringExtractor {

    public static String extractSelector(String input) {
        if (input == null || (!input.contains("Selector:") && !input.contains("selector:"))) {
            throw new IllegalArgumentException("Input must contain 'Selector:' or 'selector:'");
        }

        String result = input.contains("Selector:") ?
                input.substring(input.indexOf("Selector:") + 9) :
                input.substring(input.indexOf("selector:") + 9);

        if (input.matches(".*'[^']*Selector:.*") || input.matches(".*'[^']*selector:.*")) {
            result = removeLastQuote(result);
        }

        int openBrackets = countOccurrences(result, '[');
        int closeBrackets = countOccurrences(result, ']');

        if (openBrackets == closeBrackets) {
            return result;
        } else {
            return removeLastClosingBracket(result);
        }
    }

    private static int countOccurrences(String input, char character) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == character) count++;
        }
        return count;
    }

    private static String removeLastClosingBracket(String input) {
        int lastIndex = input.lastIndexOf("]");
        if (lastIndex != -1) {
            return input.substring(0, lastIndex) + input.substring(lastIndex + 1);
        }
        return input;
    }

    private static String removeLastQuote(String input) {
        if (input.endsWith("'")) {
            return input.substring(0, input.length() - 1);
        }
        return input;
    }
}
