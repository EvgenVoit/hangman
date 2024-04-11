package app;

import utils.InvalidInputException;

import java.io.IOException;

public class Game {
    public void startGame() throws IOException, InvalidInputException {
        Menu menu = new Menu();
        menu.makeGameChoiceAndStartGame();
    }

}