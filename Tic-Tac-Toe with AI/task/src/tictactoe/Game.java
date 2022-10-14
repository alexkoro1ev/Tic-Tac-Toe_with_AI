package tictactoe;

import tictactoe.controller.Controller;
import tictactoe.view.Grid;

import java.io.IOException;

public class Game {
    private final Controller controller = new Controller();

    public Game() {
    }

    public void run() throws IOException {
        while (true) {

            controller.createNewGame();
            if (!controller.getMode().isGameWillBeStarted()) {
                break;
            }

            Grid grid = controller.getGrid();
            grid.drawGrid();

            while (!controller.isFinished()) {
                controller.makeMoves();
            }
        }
    }
}
