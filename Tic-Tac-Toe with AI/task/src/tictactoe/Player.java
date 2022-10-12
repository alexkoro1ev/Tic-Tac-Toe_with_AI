package tictactoe;

public class Player implements MoveMaking {
    protected final Controller controller;

    public Player(Controller controller) {
        this.controller = controller;
    }

    public Move makeMove() {
        return null;
    }

    protected boolean moveIsNotValid(Move move) {
        return false;
    }

    protected boolean checkMoveValidity(int y, int x) {
        return !(y < 0 || y > 2 || x < 0 || x > 2);
    }

    protected boolean isCellOccupied(int y, int x) {
        char currentCellLabel = controller.getGrid().getCurrentGrid()[y][x];
        return currentCellLabel != ' ';
    }
}
