package com.udea.sitas.util;

public class StringUtil {

    public static String formatStrings(String str) {
        {
            if (str == null || str.isEmpty()) {
                return str;
            }

            String[] words = str.toLowerCase().split("\\s+");
            StringBuilder capitalizedWords = new StringBuilder();

            for (String word : words) {
                if (word.length() > 0) {
                    capitalizedWords.append(Character.toUpperCase(word.charAt(0)))
                            .append(word.substring(1))
                            .append(" ");
                }
            }

            // Trim the trailing space
            return capitalizedWords.toString().trim();
        }
    }

}
