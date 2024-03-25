import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    private static boolean startGame = true;

    private static final GameProcess gameProcess = new GameProcess();

    public static void makeChoice() throws IOException {
        while (startGame) {
            System.out.println("-------------------------------");
            System.out.println("Do you want to start new game?" + ANSI_GREEN + " \n\t\tYes(Y)/No(N)" + ANSI_RESET);
            System.out.println("-------------------------------");
            char gameChoice = SCANNER.next().charAt(0);
            switch (gameChoice) {
                case 'Y' -> {
                    System.out.println("-------------------------------");
                    System.out.println("RUSSIAN or ENGLISH word to guess?" + ANSI_GREEN + " \n\tRussian(R)/English(E)" + ANSI_RESET);
                    System.out.println("-------------------------------");
                    char langChoice = SCANNER.next().charAt(0);
                    if (Character.isLetter(langChoice)) {
                        if (langChoice == 'R') {
                           // System.out.println(WordReader.getWord(Language.RUSSIAN));
                            gameProcess.showTheWord(Language.RUSSIAN);
                        } else if (langChoice == 'E') {
                            gameProcess.showTheWord(Language.ENGLISH);
                        }
                    } else {
                        System.out.println(ANSI_RED + "Invalid input! Enter the character!" + ANSI_RESET);
                    }
                }
                case 'N' -> {
                    startGame = false;
                    System.out.println(ANSI_RED + "The game was ended..." + ANSI_RESET);
                }
                default -> System.out.println(ANSI_RED + "Try to enter again..." + ANSI_RESET);
            }
        }
    }
}
