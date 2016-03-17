package se.liu.ida.jesjo430.tddd78.tetris;

/**
 * testcases and creater of the board and visuall window.
 */

public class BoardTest
{
    public static void main(String[] args) {
	int height = 18;
	int width = 10;

	final Board board = new Board(height, width);
	new TetrisFrame(board);
    }
}