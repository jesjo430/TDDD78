package se.liu.ida.jesjo430.tddd78.tetris;

/**
 * Checks if the falling poly is colliding with any outside-block.
 * if it does it returns true
 * if it not collides with an outside-block but with an "visible" block
 * then it removes that block and puts a emptyblock in its place.
 */

public class Fallthrough implements CollisionHandler
{
    public boolean hasCollision(Board board) {
	Poly fallingPoly = board.getFallingPoly();
	for (int y = 0; y < fallingPoly.getHeight(); y++) {
	    for (int x = 0; x < fallingPoly.getWidth(); x++) {

		if (fallingPoly.getFallingSquareType(y, x) != SquareType.EMPTY) {
		    if (board.getSquareType(board.getFallingYCord() + y, board.getFallingXCord() + x) == SquareType.OUTSIDE) {
			return true;
		    }
		}
	    }
	}
	for (int y = 0; y < board.getFallingPoly().getHeight(); y++) {
	    for (int x = 0; x < board.getFallingPoly().getWidth(); x++) {
		if (board.getSquareType(board.getFallingYCord() + y, board.getFallingXCord() + x) !=
		    SquareType.EMPTY && board.getFallingPoly().getFallingSquareType(y, x) != SquareType.EMPTY) {
		    board.removeSquare(board.getFallingYCord() + y, board.getFallingXCord() + x);
		}
	    }
	}
	return false;
    }
}
