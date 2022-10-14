package tictactoe.model;

public class Cell {
    private final int x;
    private final int y;
    private char label;
    private boolean empty;

    public Cell(int y, int x, char label) {
        this.y = y;
        this.x = x;
        this.label = label;
        this.empty = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
        this.empty = (label == ' ');
    }

    public boolean isEmpty() {
        return empty;
    }
}
