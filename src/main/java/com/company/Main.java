package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean validateString(String str) {
        int validFlag = 0, brackets = 0;
        Pattern validSymbolsPattern = Pattern.compile("[\\w\\d\\[\\]]+");
        Pattern numbersPattern = Pattern.compile("\\d+");

        Matcher validSymbolsMatcher = validSymbolsPattern.matcher(str);
        Matcher numbersPatternMatcher = numbersPattern.matcher(str);

        //1 - valid symbols
        if (validSymbolsMatcher.find() && validSymbolsMatcher.group(0).length() == str.length()) {
            //2 - brackets after numbers
            while (numbersPatternMatcher.find()) {
                if (numbersPatternMatcher.end() < str.length() && str.charAt(numbersPatternMatcher.end()) != '[') {
                    validFlag++;
                }
            }

            //3 - numbers before brackets
            for (int i = 1; i < str.length(); ++i) {
                if (str.charAt(i) == '[' && !isInteger(str.charAt(i - 1))) {
                    validFlag++;
                }

                //brackets balance
                if (str.charAt(i) == '[') brackets++;
                if (str.charAt(i) == ']') brackets--;
            }
            return validFlag == 0 && brackets == 0;
        }

        return false;
    }

    public static boolean isInteger(char input) {
        try {
            Integer.parseInt(String.valueOf(input));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static String unboxString(String str) {
        Pattern groupPattern = Pattern.compile("(?<MUL>\\d+)\\[(?<BODY>[a-zA-Z]*)\\]");
        Matcher groupPatternMatcher = groupPattern.matcher(str);
        StringBuffer buffer = new StringBuffer();

        while (groupPatternMatcher.find()) {
            String newString = groupPatternMatcher.group("BODY") +
                    String.valueOf(groupPatternMatcher.group("BODY"))
                            .repeat(Math.max(0, Integer.parseInt(groupPatternMatcher.group("MUL")) - 1));

            groupPatternMatcher.appendReplacement(buffer, newString);

            groupPatternMatcher.appendTail(buffer);
            str = buffer.toString();
            buffer.setLength(0);
            groupPatternMatcher = groupPattern.matcher(str);
        }

        return str;
    }
}
