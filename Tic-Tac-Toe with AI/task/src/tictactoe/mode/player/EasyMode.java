package tictactoe.mode.player;

import tictactoe.controller.Controller;
import tictactoe.model.Cell;
import tictactoe.util.Console;

public class EasyMode extends AI {
    public EasyMode(Controller controller) {
        super(controller);
    }

    @Override
    public Cell makeMove() {
        Console.writeLine("Making move level \"easy\"");
        return makeRandomMove();
    }
}
