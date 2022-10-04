package com.epam.training.student_dmitry_shamko;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null || email.length() == 0) {
            return false;
        }
        String regex = "[a-z0-9]+_[a-z0-9]+@epam\\.com";
        Pattern pattern = Pattern.compile(regex);
        return Pattern.matches(pattern.toString(), email);
    }
}





