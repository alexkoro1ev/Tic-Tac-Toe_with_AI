package tictactoe.mode.player;

import tictactoe.controller.Controller;
import tictactoe.model.Cell;
import tictactoe.util.Console;

public class Human extends Player {

    public Human(Controller controller) {
        super(controller);
    }

    @Override
    public Cell makeMove() {
        int y;
        int x;
        char label = controller.getLabel();
        while (true) {
            try {
                Console.write("Enter the coordinates: ");
                String coordinates = Console.readLine();
                y = Integer.parseInt(String.valueOf(coordinates.charAt(0))) - 1;
                x = Integer.parseInt(String.valueOf(coordinates.charAt(2))) - 1;
            } catch (Exception e) {
                Console.writeLine("You should enter numbers!");
                continue;
            }

            Cell move = new Cell(y, x, label);
            if (moveIsNotValid(move)) {
                continue;
            }

            return move;
        }
    }

    @Override
    protected boolean moveIsNotValid(Cell move) {
        int y = move.getY();
        int x = move.getX();
        if (!checkMoveValidity(y, x) || isCellOccupied(y, x)) {
            if (!checkMoveValidity(y, x)) {
                Console.writeLine("Coordinates should be from 1 to 3!");
            } else {
                Console.writeLine("This cell is occupied! Choose another one!");
            }
            return true;
        }
        return false;
    }
}
