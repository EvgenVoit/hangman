package utils;

import java.util.regex.Pattern;

public class InputCheck {
    public static void validateInputRussian(String input) throws InvalidInputException {
        String regex = "^[а-яёА-ЯЁ]+$";
        if (!Pattern.matches(regex, input)) {
            throw new InvalidInputException(Constants.ANSI_RED + "INVALID INPUT! TRY AGAIN! (ONLY RUSSIAN)"
                    + Constants.ANSI_RESET);
        }
    }

    public static void validateInputEnglish(String input) throws InvalidInputException {
        String regex = "^[a-zA-Z]+$";
        if (!Pattern.matches(regex, input)) {
            throw new InvalidInputException(Constants.ANSI_RED + "INVALID INPUT! TRY AGAIN! (ONLY ENGLISH)"
                    + Constants.ANSI_RESET);
        }
    }
}