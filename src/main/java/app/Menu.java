package app;

import utils.Constants;
import utils.InvalidInputException;
import utils.Language;

import java.io.IOException;

public class Menu {
    private static boolean startGame = true;
    private static final char START_GAME = 'y';
    private static final char END_GAME = 'n';
    private static final GameProcess gameProcess = new GameProcess();

    public void makeGameChoiceAndStartGame() throws InvalidInputException, IOException {
        while (startGame) {
            colorPrintlnWithHeader(Constants.ANSI_GREEN, " \t\tYes(Y)/No(N)",
                    "Do you want to start new game?");
            char gameChoice;
            do {
                gameChoice = Constants.SCANNER.next().charAt(0);
                if (gameChoice == 'Y' || gameChoice == 'y' || gameChoice == 'N' || gameChoice == 'n') {
                    switchGameChoice(gameChoice);
                } else {
                    simpleColorPrintln(Constants.ANSI_RED, "Invalid game choice! Enter 'Y/y' or 'N/n'!");
                }
            } while (gameChoice != 'Y' && gameChoice != 'y' && gameChoice != 'N' && gameChoice != 'n');

        }
    }

    private void colorPrintlnWithHeader(String color, String text, String textHeader) {
        System.out.println("-------------------------------");
        System.out.println(textHeader);
        System.out.println(color + text + Constants.ANSI_RESET);
        System.out.println("-------------------------------");
    }

    private void simpleColorPrintln(String color, String text) {
        System.out.println(color + text + Constants.ANSI_RESET);
    }

    private void switchGameChoice(Character gameChoice) throws InvalidInputException, IOException {
        switch (gameChoice) {
            case START_GAME -> {
                char langChoice;
                do {
                    colorPrintlnWithHeader(Constants.ANSI_GREEN, " \tRussian(R)/English(E)",
                            "RUSSIAN or ENGLISH word to guess?");
                    langChoice = Constants.SCANNER.next().charAt(0);
                    if (langChoice == 'R' || langChoice == 'r' || langChoice == 'E' || langChoice == 'e') {
                        getLanguage(langChoice);
                    } else {
                        simpleColorPrintln(Constants.ANSI_RED, "Invalid language choice! Enter 'R/r or 'E/e'!");
                    }
                } while (langChoice != 'R' && langChoice != 'r' && langChoice != 'E' && langChoice != 'e');
            }

            case END_GAME -> {
                startGame = false;
                simpleColorPrintln(Constants.ANSI_RED, "The game was ended...");
            }
            default -> simpleColorPrintln(Constants.ANSI_RED, "Try to enter again...");
        }
    }

    private void getLanguage(Character langChoice) throws InvalidInputException, IOException {
        if (langChoice == 'R' || langChoice == 'r') {
            gameProcess.showTheWord(Language.RUSSIAN);
        } else if (langChoice == 'E' || langChoice == 'e') {
            gameProcess.showTheWord(Language.ENGLISH);
        } else {
            System.out.println(Constants.ANSI_RED +
                    "Invalid input! Enter the character!" +
                    Constants.ANSI_RESET);
        }
    }
}