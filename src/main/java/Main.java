import app.Game;
import app.Menu;
import utils.InvalidInputException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidInputException {
        Game game = new Game();
        game.startGame();
    }
}