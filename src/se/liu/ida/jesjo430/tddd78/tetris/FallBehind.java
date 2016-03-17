package se.liu.ida.jesjo430.tddd78.tetris;

/**
 * Checks if fallingPoly is colliding with an outside-block.
 * If it does it returns true, else false.
 */

public class FallBehind implements CollisionHandler
{
    public boolean hasCollision(Board board) {
	Poly fallingPoly = board.getFallingPoly();
		for (int y = 0; y < fallingPoly.getHeight(); y++) {
		    for (int x = 0; x < fallingPoly.getWidth(); x++) {
			if (fallingPoly.getFallingSquareType(y, x) != SquareType.EMPTY &&
			    board.getSquareType(board.getFallingYCord() + y, board.getFallingXCord() + x) ==
			    SquareType.OUTSIDE) {
				return true;
			    }
			}
		    }
	return false;
    }
}