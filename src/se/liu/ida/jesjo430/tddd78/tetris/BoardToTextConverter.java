package se.liu.ida.jesjo430.tddd78.tetris;

/**
 * Convert blocktypes to letters and a visualization of letters.
 */

public class BoardToTextConverter {

    public static String convertToText(Board myBoard) {
	StringBuilder stringBuilder = new StringBuilder();

	int height = myBoard.getHeight();
	int width = myBoard.getWidth();

	Poly poly = myBoard.getFallingPoly();

	int curX = 2;
	int curY = 1;


	for (int h = 0; h < height; h++) {
	    int polyY = h - curY;
	    for (int w = 0; w < width; w++) {
		int polyX = w - curX;
		if (poly != null && polyX >= 0 && polyX < poly.getWidth() && polyY >= 0 && polyY < poly.getHeight()) {
		    if (poly.getShape()[polyY][polyX] != SquareType.EMPTY) {
			squareType(poly.getShape()[polyY][polyX], stringBuilder);
		    } else {
			squareType(myBoard.getSquareType(h, w), stringBuilder);
		    }
		} else {
		    squareType(myBoard.getSquareType(h, w), stringBuilder);
		}
		stringBuilder.append(' ');
	    }
	    stringBuilder.append('\n');
	}
	String text = stringBuilder.toString();
	return text;
    }

    public static StringBuilder squareType(SquareType squareType, StringBuilder stringBuilder) {
   	switch (squareType) {
   	    case EMPTY:
		stringBuilder.append(" ");
   		break;
   	    case I:
		stringBuilder.append("I");
   		break;
   	    case J:
		stringBuilder.append("J");
   		break;
   	    case L:
		stringBuilder.append("L");
   		break;
   	    case O:
		stringBuilder.append("O");
   		break;
   	    case S:
		stringBuilder.append("S");
   		break;
   	    case T:
		stringBuilder.append("T");
   		break;
   	    case Z:
		stringBuilder.append("Z");
   		break;
	    case OUTSIDE:
		break;
   	}
   	return stringBuilder;
       }

}
