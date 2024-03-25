import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameProcess implements Showable {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    private static int counter;
    private List<Character> inputLetters = new ArrayList<>();

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
            System.out.println("WORD: " + ANSI_YELLOW + result + ANSI_RESET);
            boolean isEnded = true;

            while (isEnded) {
                System.out.println("---------------------");
                System.out.println("Enter the letter: ");
                char letter = SCANNER.next().charAt(0);
                System.out.println("Char: " + letter);
//                 if (!inputLetters.contains((Object) letter))
                if (!word.contains(String.valueOf(letter)) && !inputLetters.contains((Object) letter)) {
                    inputLetters.add(letter);
                    counter++;
                }
                if (word.contains(String.valueOf(letter))) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == letter) {
                            arrayOfChars[i] = letter;
                        }
                    }

                    //  System.out.println(word); //УДАЛИТЬ МОДИФИЦИРОВАТЬ
                    String resultStr = new String(arrayOfChars);
                    System.out.println(ANSI_YELLOW + resultStr + ANSI_RESET);
                    System.out.println(ANSI_RED + "Errors " + "(" + counter + "): " + inputLetters + ANSI_RESET);

                } else {
                    System.out.println(ANSI_RED + "Errors " + "(" + counter + "): " + inputLetters + ANSI_RESET);
                    Gallow.drawGallow(counter);
                    if (counter == 6) {
                        isEnded = false;
                        System.out.println("----------------------------------------------------");
                        System.out.println("THE HIDDEN WORD IS : " + ANSI_GREEN + word + ANSI_RESET);
                        System.out.println(ANSI_RED + "YOU LOSE THIS GAME! PLEASE, TRY AGAIN!" + ANSI_RESET);
                        System.out.println("----------------------------------------------------");
                        inputLetters.clear();
                        counter = 0;
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}