package tictactoe.mode.player;

import tictactoe.controller.Controller;
import tictactoe.model.Cell;
import tictactoe.util.Console;

public class MediumMode extends AI {

    public MediumMode(Controller controller) {
        super(controller);
    }

    @Override
    public Cell makeMove() {
        char label = controller.getLabel();
        char opponentsLabel = label == 'X' ? 'O' : 'X';
        Console.writeLine("Making move level \"medium\"");
        Cell move = lastMoveToWin(label);
        if (move.getY() != -1) {
            return move;
        }
        Cell nextOpponentsWinMove = lastMoveToWin(opponentsLabel);
        if (nextOpponentsWinMove.getY() != -1) {
            return new Cell(nextOpponentsWinMove.getY(), nextOpponentsWinMove.getX(), label);
        }

        return makeRandomMove();
    }
}
