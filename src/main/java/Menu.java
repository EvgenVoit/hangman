import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    static boolean startGame = true;

    public static void makeChoice() throws IOException {
        while(startGame){
            System.out.println(ANSI_GREEN + "Do you want to start new game? Yes(Y)/No(N)" + ANSI_RESET);
            char choice = SCANNER.next().charAt(0);
            switch(choice){
                case 'Y'-> {
                    System.out.println(WordReader.getWord());
                    System.out.println("Enter first letter");
                }

                case 'N' -> {
                    startGame = false;
                    System.out.println("The game was ended...");
                }

                default -> System.out.println("Try to enter again...");

            }
        }

    }
}
