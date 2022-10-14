package tictactoe.view;

import tictactoe.model.Cell;
import tictactoe.util.Console;

public class Grid {
    private Cell[][] currentGrid;

    public Grid() {
        currentGrid = new Cell[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                currentGrid[y][x] = new Cell(y, x, ' ');
            }
        }
    }

    public void drawGrid(Cell move) {
        currentGrid[move.getY()][move.getX()].setLabel(move.getLabel());
        drawGrid();
    }

    public void drawGrid() {
        Console.writeLine("---------");
        for (int y = 0; y < 3; y++) {
            Console.write("| ");
            for (int x = 0; x < 3; x++) {
                Console.write(currentGrid[y][x].getLabel() + " ");
            }
            Console.writeLine("|");
        }
        Console.writeLine("---------");
    }

    public Cell[][] getCurrentGrid() {
        return currentGrid;
    }

    public void setCurrentGrid(Cell[][] currentGrid) {
        this.currentGrid = currentGrid;
    }
}
