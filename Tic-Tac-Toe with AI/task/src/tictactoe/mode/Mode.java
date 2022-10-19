package tictactoe.mode;

import tictactoe.mode.player.*;
import tictactoe.util.Console;
import tictactoe.controller.Controller;

import java.io.IOException;

public class Mode {
    Controller controller;
    private final boolean isGameWillBeStarted;

    public Mode(Controller controller) throws IOException {
        this.controller = controller;
        String[] mode = start();

        this.isGameWillBeStarted = mode[0].equals("start");
        if (this.isGameWillBeStarted) {
            Player firstPlayer = selectPlayer(mode[1]);
            controller.setFirstPlayer(firstPlayer);
            Player secondPlayer = selectPlayer(mode[2]);
            controller.setSecondPlayer(secondPlayer);
        } else {
            controller.setFirstPlayer(null);
            controller.setSecondPlayer(null);
        }

    }

    private Player selectPlayer(String player) {
        switch (player) {
            case "easy":
                return new EasyMode(controller);
            case "medium":
                return new MediumMode(controller);
            case "hard":
                return new HardMode(controller);
        }
        return new Human(controller);
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

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
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
        return option.equals("hard") ||
                option.equals("medium") ||
                option.equals("easy") ||
                option.equals("user");
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isGameWillBeStarted() {
        return isGameWillBeStarted;
    }
}
