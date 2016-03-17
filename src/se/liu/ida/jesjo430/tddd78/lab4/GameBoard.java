package se.liu.ida.jesjo430.tddd78.lab4;

import javafx.util.Pair;

public class GameBoard
{
    private enum CellType
    {
        EMPTY(false), TREE(true), BUILDING(true), ROCK(true),
        POWERUP(false), BORDER(true);

        public final boolean isObstacle;

        CellType(final boolean isObstacle) {
            this.isObstacle = isObstacle;
        }
    }

    public enum Move {
        DOWN(0,1), UP(0,-1), RIGHT(1,0), LEFT(-1,0);

        private final int deltaX;
        private final int deltaY;

        Move(final int deltaX, final int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }
    }

    private CellType[][] cells;
    private int currentX, currentY;

    public GameBoard(int width, int height) {
        this.cells = new CellType[height][width];
        this.currentX = width / 2;
        this.currentY = height / 2;
    }

    public void move(Move direction) {
	this.currentX += direction.deltaX;
	this.currentY += direction.deltaY;
    }

    public boolean canMove(Move direction) {
        return !cells[currentY + direction.deltaY][currentX + direction.deltaX].isObstacle;
    }

}
