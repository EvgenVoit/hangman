package utils;

import java.util.regex.Pattern;

public class InputCheck {
    public static boolean validateInput(Enum<Language> languageEnum, String input) {
        String language = languageEnum.toString();
        String regexEnglish = "^[a-zA-Z]$";
        String regexRussian = "^[а-яёА-ЯЁ]$";
        if (language.equals("RUSSIAN")) {
            return Pattern.matches(regexRussian, input);
        } else if (language.equals("ENGLISH")) {
            return Pattern.matches(regexEnglish, input);
        } else return false;
    }

    public static boolean validateInputLength(String input) throws InvalidInputException {
        return input.length() > 1;
    }


}