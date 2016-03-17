package se.liu.ida.jesjo430.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;
import java.awt.event.ActionEvent;

/**
 * The graphical component that paints the components and choses its colors.
 * This class also keeps an eye on the keybindings.
 */

public class TetrisComponent extends JComponent implements BoardListener
{
    private Board gameBoard;
    private final EnumMap<SquareType, Color> colorMap;

    private static final int SQUARE_SIZE = 35;

    public TetrisComponent(final Board gameBoard) {
	this.gameBoard = gameBoard;
	this.colorMap = setColourMap();

	setKeyBindings();
	gameBoard.addBoardListeners(this);
    }

    /**
     * repeaints the component.
     */
    public void boardChanged() {
	this.repaint();
    }

    /**
     * returns the size of the board component.
     */
    @Override public Dimension getPreferredSize() {
	int height = (gameBoard.getHeight()) * SQUARE_SIZE;
	int width = (gameBoard.getWidth()) * SQUARE_SIZE;
	return new Dimension(width, height);
    }

    /**
     * maps all SquareTypes and what color they uses in the graphical representation.
     */
    private EnumMap setColourMap() {
	EnumMap<SquareType, Color> colorMap = new EnumMap<SquareType, Color>(SquareType.class);
	colorMap.put(SquareType.EMPTY, Color.BLACK);
	colorMap.put(SquareType.I, Color.CYAN);
	colorMap.put(SquareType.O, Color.YELLOW);
	colorMap.put(SquareType.T, Color.MAGENTA);
	colorMap.put(SquareType.S, Color.RED);
	colorMap.put(SquareType.Z, Color.GREEN);
	colorMap.put(SquareType.J, Color.PINK);
	colorMap.put(SquareType.L, Color.ORANGE);
	colorMap.put(SquareType.OUTSIDE, Color.WHITE);
	return colorMap;
    }

    @Override protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	int height = gameBoard.getHeight();
	int width = gameBoard.getWidth();

	Poly poly = gameBoard.getFallingPoly();

	int curX = gameBoard.getFallingXCord();
	int curY = gameBoard.getFallingYCord();


	for (int h = 0; h < height; h++) {
	    int polyY = h - curY;
	    for (int w = 0; w < width; w++) {
		int polyX = w - curX;

		if (poly != null && polyX >= 0 && polyX < poly.getWidth() && polyY >= 0 && polyY < poly.getHeight()) {
		    if (poly.getShape()[polyY][polyX] != SquareType.EMPTY) {
			g2d.setColor(colorMap.get(poly.getShape()[polyY][polyX]));
			g2d.fillRect(w * SQUARE_SIZE, h * SQUARE_SIZE, SQUARE_SIZE,
				     SQUARE_SIZE);
		    } else {
			g2d.setColor(colorMap.get(gameBoard.getSquareType(h, w)));
			g2d.fillRect(w * SQUARE_SIZE, h * SQUARE_SIZE, SQUARE_SIZE,
				     SQUARE_SIZE);
		    }
		} else {
		    g2d.setColor(colorMap.get(gameBoard.getSquareType(h, w)));
		    g2d.fillRect(w * SQUARE_SIZE, h * SQUARE_SIZE, SQUARE_SIZE,
				 SQUARE_SIZE);
		}
	    }
	}
    }

    /**
     * sets all keybindings thats being used in the tetris frame.
     */
    private void setKeyBindings() {
	this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
	this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
	this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "rotatePoly");
	this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "moveDown");

	this.getActionMap().put("moveRight", new ActionMoveRight());
	this.getActionMap().put("moveLeft", new ActionMoveLeft());
	this.getActionMap().put("rotatePoly", new ActionRotatePoly());
	this.getActionMap().put("moveDown", new ActionMoveDown());
    }

    private class ActionMoveRight extends AbstractAction {
	public void actionPerformed(ActionEvent e) {
	    gameBoard.moveRight();
	}
    }

    private class ActionMoveLeft extends AbstractAction {
    	public void actionPerformed(ActionEvent e) {
    	    gameBoard.moveLeft();
    	}
        }

    private class ActionMoveDown extends AbstractAction {
	public void actionPerformed(ActionEvent e) {
	    gameBoard.moveDown();
	}
    }

    private class ActionRotatePoly extends AbstractAction {
        	public void actionPerformed(ActionEvent e) {
        	    gameBoard.rotatePoly();
        	}
            }
}
