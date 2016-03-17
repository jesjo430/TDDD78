package se.liu.ida.jesjo430.tddd78.tetris;

/**
 * The Poly itself a shape thats made by a two dimmensional array.
 */

public class Poly
{
    private SquareType[][] shape;

    public Poly(final SquareType[][] shape) {
	this.shape = shape;
    }

    public int getHeight() {
	return shape.length;
    }

    public int getWidth() {
	return shape[0].length;
    }

    public SquareType[][] getShape() {
           return shape;
       }

    public SquareType getFallingSquareType(int row, int column) {
           return shape[row][column];
       }

    /**
     * rotates the array 90 degres to the right.
     */
    public Poly rotateRight(){
        SquareType[][] newSquare = new SquareType[getHeight()][getWidth()];

        for (int r = 0; r < getHeight(); r++) {
            for (int c = 0; c < getWidth(); c++){
                newSquare[c][getHeight()-1-r] = shape[r][c];
            }
        }
        return new Poly(newSquare);
    }
}

