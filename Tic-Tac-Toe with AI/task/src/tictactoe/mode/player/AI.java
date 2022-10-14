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

    protected Cell lastMoveToWin(char label) {
        Cell[][] currentGrid = controller.getGrid().getCurrentGrid();
        int horizontalCheck = 0;
        int verticalCheck = 0;
        int mainDiagonalCheck = 0;
        int sideDiagonalCheck = 0;
        int[] horizontalEmptyCell = new int[]{-1, - 1};
        int[] verticalEmptyCell = new int[]{-1, - 1};
        int[] mainDiagonalEmptyCell = new int[]{-1, - 1};
        int[] sideDiagonalEmptyCell = new int[]{-1, - 1};
        Cell move;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // row check----------------------------
                if (currentGrid[i][j].getLabel() == label) {
                    horizontalCheck++;
                } else if (currentGrid[i][j].isEmpty()) {
                    horizontalEmptyCell[0] = i ;
                    horizontalEmptyCell[1] = j;
                }
                if (j == 2 && horizontalCheck == 2 && horizontalEmptyCell[0] != -1) {
                    return new Cell(horizontalEmptyCell[0], horizontalEmptyCell[1], label);
                }

                // column check-------------------------
                if (currentGrid[j][i].getLabel() == label) {
                    verticalCheck++;
                } else if (currentGrid[j][i].isEmpty()) {
                    verticalEmptyCell[0] = j;
                    verticalEmptyCell[1] = i;
                }
                if (j == 2 && verticalCheck == 2 && verticalEmptyCell[0] != -1) {
                    return new Cell(verticalEmptyCell[0], verticalEmptyCell[1], label);
                }

                // main diagonal check------------------
                if (currentGrid[j][j].getLabel() == label) {
                    mainDiagonalCheck++;
                } else if (currentGrid[j][j].isEmpty()) {
                    mainDiagonalEmptyCell[0] = j;
                    mainDiagonalEmptyCell[1] = j;
                }
                if (j == 2 && mainDiagonalCheck == 2 && mainDiagonalEmptyCell[0] != -1) {
                    return new Cell(mainDiagonalEmptyCell[0], mainDiagonalEmptyCell[1], label);
                }

                // side diagonal check------------------
                if (currentGrid[j][2 - j].getLabel() == label) {
                    sideDiagonalCheck++;
                } else if (currentGrid[j][2 - j].isEmpty()) {
                    sideDiagonalEmptyCell[0] = j;
                    sideDiagonalEmptyCell[1] = 2 - j;
                }
                if (j == 2 && sideDiagonalCheck == 2 && sideDiagonalEmptyCell[0] != -1) {
                    return new Cell(sideDiagonalEmptyCell[0], sideDiagonalEmptyCell[1], label);
                }

            }
            horizontalEmptyCell = new int[]{-1, - 1};
            verticalEmptyCell = new int[]{-1, - 1};
            mainDiagonalEmptyCell = new int[]{-1, - 1};
            sideDiagonalEmptyCell = new int[]{-1, - 1};
            horizontalCheck = 0;
            verticalCheck = 0;
            mainDiagonalCheck = 0;
            sideDiagonalCheck = 0;
        }

        return new Cell(-1, -1, label);
    }
}
