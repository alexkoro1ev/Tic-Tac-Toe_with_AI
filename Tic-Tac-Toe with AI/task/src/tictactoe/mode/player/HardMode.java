package tictactoe.mode.player;

import tictactoe.controller.Controller;
import tictactoe.controller.Minimax;
import tictactoe.model.Cell;
import tictactoe.util.Console;

public class HardMode extends Player {
    private final Minimax minimax;

    public HardMode(Controller controller) {
        super(controller);
        this.minimax = new Minimax(controller);
    }

    @Override
    public Cell makeMove() {
        Console.writeLine("Making move level \"hard\"");
        return minimax.getBestMove();
    }
}
