package tictactoe;

import java.io.IOException;

public class Game {
    private final Grid grid = new Grid();
    private final Controller controller = new Controller(grid);

    public Game() {
    }

    public void run() throws IOException {
        while (true) {

            controller.createNewGame();
            if (!controller.getMode().isGameWillBeStarted()) {
                break;
            }

            grid.drawGrid();

            while (!controller.isFinished()) {
                controller.makeMoves();
            }
        }
    }
}
