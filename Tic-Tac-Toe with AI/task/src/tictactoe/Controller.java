package tictactoe;

import java.io.IOException;

public class Controller {
    private final Grid grid;
    private Mode mode;
    private boolean isFinished;
    private int turnCounter = 0;

    public Controller(Grid grid) {
        this.grid = grid;
    }

//    public void startGame() throws IOException {
//        Console.write("Enter the cells: ");
//        char[] state = Console.readLine().toCharArray();
//
//        for (int i = 0; i < state.length; i++) {
//            Move move = getMoveFromState(state[i], i);
//            updateGrid(move);
//        }
//        grid.drawGrid();
//    }

    public void createNewGame() throws IOException {
        this.mode = new Mode(this);
        this.isFinished = !this.mode.isGameWillBeStarted();
    }

    public void makeMoves() {
        Move move;
        if (turnCounter % 2 == 0) {
            move = mode.getPlayer1().makeMove();
        } else {
            move = mode.getPlayer2().makeMove();
        }

        redrawGrid(move);
        getState();
        turnCounter++;
    }

//    private Move getMoveFromState(char c, int position) {
//        int y = position / 3;
//        int x = position % 3;
//
//        switch (c) {
//            case 'X':
//                turnCounter++;
//                return new Move('X', y, x);
//            case 'O':
//                turnCounter++;
//                return new Move('O', y, x);
//        }
//
//        return new Move(' ', y, x);
//
//    }
//
//    public void makeHumanMove() {
//        Move move = readMove();
//        redrawGrid(move);
//        getState();
//    }

//    public void makeAIMove() {
//        Console.writeLine("Making move level \"easy\"");
//        Random random = new Random();
//        Move move = null;
//        while (move == null) {
//            int y = random.nextInt(3);
//            int x = random.nextInt(3);
//            if(checkMoveValidity(y, x) && !isCellOccupied(y, x)) {
//                turnCounter++;
//                move = new Move(getLabel(), y, x);
//            }
//        }
//        redrawGrid(move);
//        getState();
//    }

//    private Move readMove() {
//        int y;
//        int x;
//        while (true) {
//            try {
//                Console.write("Enter the coordinates: ");
//                String coordinates = Console.readLine();
//                y = Integer.parseInt(String.valueOf(coordinates.charAt(0))) - 1;
//                x = Integer.parseInt(String.valueOf(coordinates.charAt(2))) - 1;
//            } catch (Exception e) {
//                Console.writeLine("You should enter numbers!");
//                continue;
//            }
//
//            if (!checkMoveValidity(y, x) || isCellOccupied(y, x)) {
//                if (!checkMoveValidity(y, x)) {
//                    Console.writeLine("Coordinates should be from 1 to 3!");
//                } else {
//                    Console.writeLine("This cell is occupied! Choose another one!");
//                }
//                continue;
//            }
//
//            turnCounter++;
//
//            return new Move(getLabel(), y, x);
//        }
//    }

    public char getLabel() {
        return turnCounter % 2 == 0 ? 'X' : 'O';
    }

//    private boolean checkMoveValidity(int y, int x) {
//        return !(y < 0 || y > 2 || x < 0 || x > 2);
//    }
//
//    private boolean isCellOccupied(int y, int x) {
//        char currentCellLabel = grid.getCurrentGrid()[y][x];
//        return currentCellLabel != ' ';
//    }

    private void updateGrid(Move move) {
        char[][] updatedGrid = grid.getCurrentGrid();
        updatedGrid[move.getY()][move.getX()] = move.getLabel();
        grid.setCurrentGrid(updatedGrid);
    }

    private void redrawGrid(Move move) {
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
        char[][] currentGrid = grid.getCurrentGrid();
        char currentLabel = getLabel();

        for (int i = 0; i < 3; i++) {
            if ((currentGrid[i][0] == currentLabel &&
                    currentGrid[i][1] == currentLabel &&
                    currentGrid[i][2] == currentLabel) ||
                    (currentGrid[0][i] == currentLabel &&
                            currentGrid[1][i] == currentLabel &&
                            currentGrid[2][i] == currentLabel)) {
                return true;
            }

            if (((currentGrid[0][0] == currentLabel &&
                    currentGrid[1][1] == currentLabel &&
                    currentGrid[2][2] == currentLabel) ||
                    (currentGrid[0][2] == currentLabel &&
                            currentGrid[1][1] == currentLabel &&
                            currentGrid[2][0] == currentLabel))) {
                return true;
            }
        }

        return false;
    }

    private boolean checkDraw() {
        char[][] currentGrid = grid.getCurrentGrid();

        for (char[] line : currentGrid) {
            for (char c : line) {
                if (c == ' ') {
                    return false;
                }
            }
        }

        return true;
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
