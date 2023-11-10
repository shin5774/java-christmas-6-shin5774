package christmas;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBER = Pattern.compile("[0-9]+");

    public static boolean isNotNumber(String target) {
        return !NUMBER.matcher(target).matches();
    }
}
