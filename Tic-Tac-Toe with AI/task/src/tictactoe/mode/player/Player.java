package tictactoe.mode.player;

import tictactoe.controller.Controller;
import tictactoe.model.Cell;

public abstract class Player {

    Controller controller;

    public Player(Controller controller) {
        this.controller = controller;
    }

    public abstract Cell makeMove();

    boolean moveIsNotValid(Cell move) {
        int y = move.getY();
        int x = move.getX();
        return !checkMoveValidity(y, x) || isCellOccupied(y, x);
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    protected boolean checkMoveValidity(int y, int x) {
        return !(y < 0 || y > 2 || x < 0 || x > 2);
    }

    protected boolean isCellOccupied(int y, int x) {
        Cell currentCellLabel = controller.getGrid().getCurrentGrid()[y][x];
        return !currentCellLabel.isEmpty();
    }
}
