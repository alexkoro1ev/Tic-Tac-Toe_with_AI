package tictactoe;

public class Grid {
    private char[][] currentGrid;

    public Grid() {
        currentGrid = new char[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                currentGrid[y][x] = ' ';
            }
        }
    }

    public void drawEmptyGrid() {
        Console.writeLine("---------");
        Console.writeLine("|       |");
        Console.writeLine("|       |");
        Console.writeLine("|       |");
        Console.writeLine("---------");
    }

    public void drawGrid(Move move) {
        currentGrid[move.getY()][move.getX()] = move.getLabel();
        drawGrid();
    }

    public void drawGrid() {
        Console.writeLine("---------");
        for (int y = 0; y < 3; y++) {
            Console.write("| ");
            for (int x = 0; x < 3; x++) {
                Console.write(currentGrid[y][x] + " ");
            }
            Console.writeLine("|");
        }
        Console.writeLine("---------");
    }

    public char[][] getCurrentGrid() {
        return currentGrid;
    }

    public void setCurrentGrid(char[][] currentGrid) {
        this.currentGrid = currentGrid;
    }
}
