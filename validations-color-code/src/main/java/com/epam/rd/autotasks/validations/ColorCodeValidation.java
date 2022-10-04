package com.epam.rd.autotasks.validations;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color == null || color.length() == 0) {
            return false;
        }
        String regex = "#[a-fA-F0-9]{3}([a-fA-F0-9]{3})?";
        Pattern pattern = Pattern.compile(regex);
        return Pattern.matches(pattern.toString(), color);
    }
}





