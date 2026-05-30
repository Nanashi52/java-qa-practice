package com.qa.practice;

public class StringUtils {

    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Строка не может быть null");
        }
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    public static int countVowels(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Строка не может быть null");
        }
        int count = 0;
        String lower = text.toLowerCase();
        for (char c : lower.toCharArray()) {
            if ("aeiouаеёиоуыэюя".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static String reverse(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Строка не может быть null");
        }
        return new StringBuilder(text).reverse().toString();
    }

    public static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    public static String truncate(String text, int maxLength) {
        if (text == null) {
            throw new IllegalArgumentException("Строка не может быть null");
        }
        if (maxLength < 0) {
            throw new IllegalArgumentException("Максимальная длина не может быть отрицательной");
        }
        if (text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength) + "...";
    }
}
