package se.liu.ida.jesjo430.tddd78.tetris;

/**
 * Out default collisionhandler that return true if falling poly overlaps any other
 * blocktype than empty-blocks.
 */

public class DefaultCollisionHandler implements CollisionHandler
{
    public boolean hasCollision(Board board) {
	Poly fallingPoly = board.getFallingPoly();
	for (int y = 0; y < fallingPoly.getHeight(); y++) {
	    for (int x = 0; x < fallingPoly.getWidth(); x++) {

		if (fallingPoly.getFallingSquareType(y , x)
		    != SquareType.EMPTY && board.getSquareType(board.getFallingYCord() + y,
								   board.getFallingXCord() + x) != SquareType.EMPTY) {
		    return true;
		}
	    }
	}
	return false;
    }

}
