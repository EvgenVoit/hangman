package utils;

public class GallowsDraw {
    public static void drawGallows(int counter) {
        switch (counter) {
            case 0 -> {
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |      ");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            case 1 -> {
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            case 2 -> {
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |     |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            case 3 -> {
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            case 4 -> {
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|\\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            case 5 -> {
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|\\");
                System.out.println("  |    /");
                System.out.println("  |");
                System.out.println("__|__");
            }
            case 6 -> {
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|\\");
                System.out.println("  |    / \\");
                System.out.println("  |");
                System.out.println("__|__");
            }
            default -> {
            }
        }
    }
}