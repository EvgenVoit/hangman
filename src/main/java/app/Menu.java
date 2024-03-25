package app;

import utils.Constants;
import utils.Language;

import java.io.IOException;

public class Menu {
    private static boolean startGame = true;
    private static final GameProcess gameProcess = new GameProcess();

    public static void makeGameChoice() throws IOException {
        while (startGame) {
            System.out.println("-------------------------------");
            System.out.println("Do you want to start new game?" +
                    Constants.ANSI_GREEN + " \n\t\tYes(Y)/No(N)" +
                    Constants.ANSI_RESET);
            System.out.println("-------------------------------");
            char gameChoice = Constants.SCANNER.next().charAt(0);
            switch (gameChoice) {
                case 'Y', 'y' -> {
                    System.out.println("-------------------------------");
                    System.out.println("RUSSIAN or ENGLISH word to guess?" +
                            Constants.ANSI_GREEN + " \n\tRussian(R)/English(E)" +
                            Constants.ANSI_RESET);
                    System.out.println("-------------------------------");
                    char langChoice = Constants.SCANNER.next().charAt(0);
                    if (Character.isLetter(langChoice)) {
                        if (langChoice == 'R' || langChoice == 'r') {
                            gameProcess.showTheWord(Language.RUSSIAN);
                        } else if (langChoice == 'E' || langChoice == 'e') {
                            gameProcess.showTheWord(Language.ENGLISH);
                        }
                    } else {
                        System.out.println(Constants.ANSI_RED +
                                "Invalid input! Enter the character!" +
                                Constants.ANSI_RESET);
                    }
                }
                case 'N', 'n' -> {
                    startGame = false;
                    System.out.println(Constants.ANSI_RED +
                            "The game was ended..." +
                            Constants.ANSI_RESET);
                }
                default -> System.out.println(Constants.ANSI_RED +
                        "Try to enter again..." +
                        Constants.ANSI_RESET);
            }
        }
    }
}