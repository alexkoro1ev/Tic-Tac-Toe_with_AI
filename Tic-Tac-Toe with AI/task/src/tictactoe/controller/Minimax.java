package tictactoe.controller;

import tictactoe.model.Cell;

import java.util.ArrayList;

public class Minimax {
    private final Controller controller;
    private final Cell[][] grid;
    private char label;
    private char oppLabel;

    public Minimax(Controller controller) {
        this.controller = controller;
        this.grid = controller.getGrid().getCurrentGrid();
    }

    public int miniMax(int depth, int alpha, int beta, boolean isMax) {

        Cell[][] currentGrid = controller.getGrid().getCurrentGrid();
        ArrayList<int[]> moves = getPossibleMoves(controller.getGrid().getCurrentGrid());

        int boardVal = evaluateBoard(currentGrid, depth);
        if (Math.abs(boardVal) > 0 || moves.isEmpty()) {
            return boardVal;
        }

        if (isMax) {
            int highest = Integer.MIN_VALUE;
            for (int[] move : moves) {
                currentGrid[move[0]][move[1]].setLabel(label);
                highest = Math.max(highest, miniMax(depth++, alpha, beta, false));
                currentGrid[move[0]][move[1]].setLabel(' ');
                alpha = Math.max(alpha, highest);
                if (alpha >= beta) {
                    return highest;
                }
            }

            return highest;

        } else {
            int lowest = Integer.MAX_VALUE;
            for (int[] move : moves) {
                currentGrid[move[0]][move[1]].setLabel(oppLabel);
                lowest = Math.min(lowest, miniMax(depth++, alpha, beta, true));
                currentGrid[move[0]][move[1]].setLabel(' ');
                beta = Math.min(beta, lowest);
                if (beta <= alpha) {
                    return lowest;
                }
            }
            return lowest;
        }
    }

    public Cell getBestMove() {
        this.label = controller.getLabel();
        this.oppLabel = this.label == 'X' ? 'O' : 'X';
        int cY = -1;
        int cX = -1;
        int bestValue = Integer.MIN_VALUE;

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (grid[y][x].isEmpty()) {
                    grid[y][x].setLabel(label);
                    int moveValue = miniMax(0, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
                    grid[y][x].setLabel(' ');
                    if (moveValue > bestValue) {
                        cY = y;
                        cX = x;
                        bestValue = moveValue;
                    }
                }
            }
        }

        return new Cell(cY, cX, label);
    }

    private int evaluateBoard(Cell[][] grid, int depth) {
        int rowSum = 0;
        int colSum = 0;
        int firstWin = label * 3;
        int secondWin = oppLabel * 3;

        // Check rows and columns for winner.
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                rowSum += grid[y][x].getLabel();
                colSum += grid[x][y].getLabel();
            }
            if (rowSum == firstWin || colSum == firstWin) {
                return 100 + depth;
            } else if (rowSum == secondWin || colSum == secondWin) {
                return -100 - depth;
            }
            rowSum = 0;
            colSum = 0;
        }

        int diagSum = 0;
        for (int i = 0; i < 3; i++) {
            diagSum += grid[i][i].getLabel();
        }
        if (diagSum == firstWin) {
            return 100 + depth;
        } else if (diagSum == secondWin) {
            return -100 - depth;
        }

        int sideDiagSum = 0;
        for (int i = 0; i < 3; i++) {
            sideDiagSum += grid[i][2 - i].getLabel();
        }
        if (sideDiagSum == firstWin) {
            return 100 + depth;
        } else if (sideDiagSum == secondWin) {
            return -100 - depth;
        }

        return 0;
    }

    public static ArrayList<int[]> getPossibleMoves(Cell[][] currentGrid) {
        ArrayList<int[]> moves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (currentGrid[i][j].getLabel() == ' ') {
                    moves.add(new int[]{i, j});
                }
            }
        }

        return moves;
    }
}
