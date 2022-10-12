package tictactoe;

import java.io.IOException;

public class Mode {
    Controller controller;
    private final Player player1;
    private final Player player2;
    private final boolean isGameWillBeStarted;

    public Mode(Controller controller) throws IOException {
        this.controller = controller;
        String[] mode = start();

        this.isGameWillBeStarted = mode[0].equals("start");
        if (this.isGameWillBeStarted) {
            this.player1 = mode[1].equals("user") ? new Human(controller) : new AI(controller);
            this.player2 = mode[2].equals("user") ? new Human(controller) : new AI(controller);
        } else {
            this.player1 = null;
            this.player2 = null;
        }

    }

    private String[] start() throws IOException {
        Console.write("Input command: ");
        String[] mode;
        do {
            mode = Console.readLine().split(" ");
            if (!isCommandsValid(mode)) {
                Console.writeLine("Bad parameters!");
            }
        } while (!isCommandsValid(mode));

        return mode;
    }

    private boolean isCommandsValid(String[] mode) {
        if (mode.length == 1 && mode[0].equals("exit")) {
            return true;
        }

        if (mode.length != 3) {
            return false;
        }
        return isStartOrExit(mode[0]) && isEasyOrUser(mode[1]) && isEasyOrUser(mode[2]);
    }

    private boolean isStartOrExit(String command) {
        return command.equals("start") || command.equals("exit");
    }

    private boolean isEasyOrUser(String option) {
        return option.equals("easy") || option.equals("user");
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean isGameWillBeStarted() {
        return isGameWillBeStarted;
    }
}
