package app;

import utils.Constants;
import utils.GallowDraw;
import utils.Language;
import utils.WordReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameProcess implements Showable {
    private static int errorCounter;
    private static String resultStr;
    private final List<Character> inputLetters = new ArrayList<>();
    @Override
    public void showTheWord(Enum<Language> languageEnum) {
        try {
            String word = WordReader.getWord(languageEnum);
            char[] arrayOfChars = word.toCharArray();
            for (int i = 0; i < arrayOfChars.length; i++) {
                if (Character.isLetter(arrayOfChars[i])) {
                    arrayOfChars[i] = '_';
                }
            }
            String result = new String(arrayOfChars);
            System.out.println("-------------------------------");
            System.out.println("WORD: " + Constants.ANSI_YELLOW + result + Constants.ANSI_RESET);
            System.out.println("Chars - " + word.length());
            boolean isEnded = true;
            while (isEnded) {
                System.out.println("---------------------");
                System.out.println("Enter the letter: ");
                char letter = Constants.SCANNER.next().charAt(0);
                System.out.println("Char: " + letter);
                if (!word.contains(String.valueOf(letter)) && !inputLetters.contains(letter)) {
                    inputLetters.add(letter);
                    errorCounter++;
                }
                if (word.contains(String.valueOf(letter))) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == letter) {
                            arrayOfChars[i] = letter;
                        }
                    }
                    resultStr = new String(arrayOfChars);
                    System.out.println(Constants.ANSI_YELLOW + resultStr + Constants.ANSI_RESET);
                    System.out.println(Constants.ANSI_RED + "Errors " + "(" + errorCounter + "): " +
                            inputLetters + Constants.ANSI_RESET);
                    if (word.equals(resultStr)) {
                        isEnded = false;
                        System.out.println("----------------------------------------------------");
                        System.out.println("THE HIDDEN WORD IS : " + Constants.ANSI_GREEN + word.toUpperCase() +
                                Constants.ANSI_RESET);
                        System.out.println(Constants.ANSI_RED + "YOU WON THIS GAME!" +
                                Constants.ANSI_RESET + " " + Constants.WINNER);
                        System.out.println("----------------------------------------------------");
                        inputLetters.clear();
                    }
                } else {
                    System.out.println(Constants.ANSI_RED + "Errors " + "(" + errorCounter + "): " +
                            inputLetters + Constants.ANSI_RESET);
                    System.out.println(Constants.ANSI_YELLOW + resultStr + Constants.ANSI_RESET);
                    GallowDraw.drawGallow(errorCounter);
                    if (errorCounter == 6) {
                        isEnded = false;
                        System.out.println("----------------------------------------------------");
                        System.out.println("THE HIDDEN WORD IS : " + Constants.ANSI_GREEN + word.toUpperCase() +
                                Constants.ANSI_RESET);
                        System.out.println(Constants.ANSI_RED + "YOU LOSE THIS GAME! PLEASE, TRY AGAIN!" +
                                Constants.ANSI_RESET + " " + Constants.LOSS);
                        System.out.println("----------------------------------------------------");
                        inputLetters.clear();
                        errorCounter = 0;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}