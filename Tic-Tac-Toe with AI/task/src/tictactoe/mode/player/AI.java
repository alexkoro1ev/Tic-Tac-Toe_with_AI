package tictactoe.mode.player;

import tictactoe.controller.Controller;
import tictactoe.model.Cell;

import java.util.Random;

public abstract class AI extends Player {
    public AI(Controller controller) {
        super(controller);
    }

    @Override
    public abstract Cell makeMove();

    protected Cell makeRandomMove() {
        Random random = new Random();
        Cell move;
        while (true) {
            int y = random.nextInt(3);
            int x = random.nextInt(3);
            char label = controller.getLabel();
            move = new Cell(y, x, label);
            if (moveIsNotValid(move)) {
                continue;
            }

            return move;
        }
    }
}
