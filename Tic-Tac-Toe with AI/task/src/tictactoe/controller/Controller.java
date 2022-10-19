package tictactoe.controller;

import tictactoe.mode.Mode;
import tictactoe.mode.player.Player;
import tictactoe.model.Cell;
import tictactoe.util.Console;
import tictactoe.view.Grid;

import java.io.IOException;

public class Controller {
    private Grid grid;
    private Mode mode;
    private Player firstPlayer;
    private Player secondPlayer;
    private boolean isFinished;
    private int turnCounter;

    public Controller() {
    }

    public void createNewGame() throws IOException {
        this.grid = new Grid();
        turnCounter = 0;
        this.mode = new Mode(this);
        this.isFinished = !this.mode.isGameWillBeStarted();
    }

    public void makeMoves() {
        Cell move;
        if (turnCounter % 2 == 0) {
            move = firstPlayer.makeMove();
        } else {
            move = secondPlayer.makeMove();
        }

        redrawGrid(move);
        getState();
        turnCounter++;
    }

    public char getLabel() {
        return turnCounter % 2 == 0 ? 'X' : 'O';
    }

    private void redrawGrid(Cell move) {
        grid.drawGrid(move);
    }

    private void getState() {
        if (checkWin()) {
            Console.writeLine(getLabel() + " wins");
            isFinished = true;
            return;
        }
        if (checkDraw()) {
            Console.writeLine("Draw");
            isFinished = true;
        }
    }

    private boolean checkWin() {
        Cell[][] currentGrid = grid.getCurrentGrid();
        char currentLabel = getLabel();

        for (int i = 0; i < 3; i++) {
            if ((currentGrid[i][0].getLabel() == currentLabel &&
                    currentGrid[i][1].getLabel() == currentLabel &&
                    currentGrid[i][2].getLabel() == currentLabel) ||
                    (currentGrid[0][i].getLabel() == currentLabel &&
                            currentGrid[1][i].getLabel() == currentLabel &&
                            currentGrid[2][i].getLabel() == currentLabel)) {
                return true;
            }

            if (((currentGrid[0][0].getLabel() == currentLabel &&
                    currentGrid[1][1].getLabel() == currentLabel &&
                    currentGrid[2][2].getLabel() == currentLabel) ||
                    (currentGrid[0][2].getLabel() == currentLabel &&
                            currentGrid[1][1].getLabel() == currentLabel &&
                            currentGrid[2][0].getLabel() == currentLabel))) {
                return true;
            }
        }

        return false;
    }

    private boolean checkDraw() {
        Cell[][] currentGrid = grid.getCurrentGrid();

        for (Cell[] line : currentGrid) {
            for (Cell cell : line) {
                if (cell.getLabel() == ' ') {
                    return false;
                }
            }
        }

        return true;
    }


    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Grid getGrid() {
        return grid;
    }

    public Mode getMode() {
        return mode;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
