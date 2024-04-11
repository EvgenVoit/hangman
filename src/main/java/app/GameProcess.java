package app;

import utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameProcess {
    private static int errorCounter;
    private static String resultStr;
    private final List<Character> inputLetters = new ArrayList<>();

    public void showTheWord(Enum<Language> languageEnum) throws IOException, InvalidInputException {
        String wordToGuess = WordReader.getWord(languageEnum);
        char[] arrayOfChars = wordToCharArray(wordToGuess);
        String result = new String(arrayOfChars);
        System.out.println("-------------------------------");
        printColorizedOutput("WORD: ", Constants.ANSI_YELLOW, Constants.ANSI_RESET, result);
        System.out.println("Chars - " + wordToGuess.length());
        GallowsDraw.drawGallows(0);
        boolean isEnded = true;
        while (isEnded) {
            System.out.println("---------------------");
            System.out.println("Enter the letter: ");
            char letter = getFirstLetter(languageEnum);
            System.out.println("Char: " + letter);
            if (!wordToGuess.contains(String.valueOf(letter)) && !inputLetters.contains(letter)) {
                inputLetters.add(letter);
                errorCounter++;
            }
            if (wordToGuess.contains(String.valueOf(letter))) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == letter) {
                        arrayOfChars[i] = letter;
                    }
                }
                resultStr = new String(arrayOfChars);
                printColorizedOutput("", Constants.ANSI_YELLOW, Constants.ANSI_RESET, resultStr);
                printColorizedOutput("", Constants.ANSI_RED, Constants.ANSI_RESET, "Errors "
                        + "(" + errorCounter + "): " + inputLetters);

                if (wordToGuess.equals(resultStr)) {
                    isEnded = false;
                    colorPrintlnWithHeader(Constants.ANSI_GREEN, Constants.ANSI_RED, "YOU WON THIS GAME!",
                            "THE HIDDEN WORD IS : ", wordToGuess.toUpperCase(), Constants.WINNER);
                    inputLetters.clear();
                    errorCounter = 0;
                    resultStr = null;
                }
            } else {
                printColorizedOutput("", Constants.ANSI_RED, Constants.ANSI_RESET, "Errors "
                        + "(" + errorCounter + "): " + inputLetters);
                printColorizedOutput("", Constants.ANSI_YELLOW, Constants.ANSI_RESET, resultStr);
                GallowsDraw.drawGallows(errorCounter);
                if (errorCounter == 6) {
                    isEnded = false;
                    colorPrintlnWithHeader(Constants.ANSI_GREEN, Constants.ANSI_RED,
                            "YOU LOSE THIS GAME! PLEASE, TRY AGAIN!",
                            "THE HIDDEN WORD IS : ", wordToGuess.toUpperCase(), Constants.LOSS);
                    inputLetters.clear();
                    errorCounter = 0;
                    resultStr = null;
                }
            }
        }
    }

    public void printColorizedOutput(String message, String color, String reset, String text) {
        System.out.println(message + color + text + reset);
    }


    private void colorPrintlnWithHeader(String color1, String color2, String text, String textHeader, String word, String emoji) {
        System.out.println("----------------------------------------------------");
        System.out.println(textHeader + color1 + word + Constants.ANSI_RESET);
        System.out.println(color2 + text + Constants.ANSI_RESET + " " + emoji);
        System.out.println("----------------------------------------------------");
    }

    public char[] wordToCharArray(String word) {
        char[] arrayOfChars = word.toCharArray();
        for (int i = 0; i < arrayOfChars.length; i++) {
            if (Character.isLetter(arrayOfChars[i])) {
                arrayOfChars[i] = '_';
            }
        }
        return arrayOfChars;
    }

    public char getFirstLetter(Enum<Language> languageEnum) throws InvalidInputException {
        char letter = 0;
        do {
            if (String.valueOf(languageEnum).equals("RUSSIAN") || String.valueOf(languageEnum).equals("ENGLISH")) {
                String letterInput = Constants.SCANNER.next().toLowerCase();
                if (InputCheck.validateInputLength(letterInput)) {
                    printColorizedOutput("", Constants.ANSI_RED, Constants.ANSI_RESET,
                            "INVALID INPUT! TRY TO ENTER AGAIN!");
                } else {
                    letter = letterInput.charAt(0);
                }
            }
        } while (!InputCheck.validateInput(languageEnum, String.valueOf(letter)));

        return letter;
    }
}