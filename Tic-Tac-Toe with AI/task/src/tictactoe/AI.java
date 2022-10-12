package tictactoe;

import java.util.Random;

public class AI extends Player implements MoveMaking {
    public static final PlayerLabel LABEL = PlayerLabel.AI;

    public AI(Controller controller) {
        super(controller);
    }

    @Override
    public Move makeMove() {
        Console.writeLine("Making move level \"easy\"");
        Random random = new Random();
        Move move;
        while (true) {
            int y = random.nextInt(3);
            int x = random.nextInt(3);
            char label = controller.getLabel();
            move = new Move(label, y, x);
            if (moveIsNotValid(move)) {
                continue;
            }

            return move;
        }
    }

    @Override
    protected boolean moveIsNotValid(Move move) {
        int y = move.getY();
        int x = move.getX();
        return !checkMoveValidity(y, x) || isCellOccupied(y, x);
    }
}
