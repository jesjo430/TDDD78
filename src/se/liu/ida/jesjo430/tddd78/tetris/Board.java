package se.liu.ida.jesjo430.tddd78.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The playingboard of the game.
 * Scores and movements of blocks and rows.
 * Placing of the falling poly.
 * Score handler.
 */

public class Board
{
    private int width, height; //The height and width of the current board.
    private int outsideFrameSize = 2; //size of the frame made of outside blocks that surrounds the board


    /**
     * Scores accordning to number of lines cleared.
     */
    private final static int ONE_ROW_SCORE = 100;
    private final static int TWO_ROW_SCORE = 300;
    private final static  int THREE_ROW_SCORE = 500;
    private final static int FOUR_ROW_SCORE = 800;

    /**
     * the two dimentional array representing the squaretype
     */
    private SquareType[][] squares;

    private int currentScore;
    private boolean isGameOver;

    private Poly fallingPoly = null;
    private int fallingXCord, fallingYCord; // cordinates accordning to the upper left corder of the falling poly.

    private List<BoardListener> boardListeners;
    private CollisionHandler collisionHandler;


    public Board(final int height, final int width) {
	this.width = width;
	this.height = height;
	this.squares = new SquareType[height+(2*outsideFrameSize)][width+(2*outsideFrameSize)];
	this.boardListeners = new ArrayList<>();

	collisionHandler = new DefaultCollisionHandler();

	initializeBoard();
	notifyListeners();
    }

    /**
     * the board-function that runs every clock-cycle.
     * moves fallinfpoly downwards and checks for collisisons.
     * checks for full rows and notifies listeners.
     */
    public void tick() {

	if (fallingPoly != null) {
	    fallingYCord += 1; // move the falling poly one step down.

	    if (collisionHandler.hasCollision(this)) { // check if the movement from the poly made a collision.
		fallingYCord -= 1; // move back step up.
		writeFallingOnBoard();
		collisionHandler = new DefaultCollisionHandler(); // in case its been changed by any powerup.
	    }
	    checkFullRows(); //check if any rows were filled.
	    notifyListeners();
	}
	else if (!isGameOver) {
	    placeNewFalling();
	    notifyListeners();
	}
    }

    /**
     * cretaes a empty board and resets all fields to standard.
     */
    private void initializeBoard() {
	this.isGameOver = false;
	this.currentScore = 0;

	for (int row = 0; row < this.squares.length; row++) {
	    for (int column = 0; column < this.squares[0].length; column++) {
		if (column < outsideFrameSize || column >= this.squares[0].length - outsideFrameSize||
		    row < outsideFrameSize || row >= this.squares.length - outsideFrameSize) {
		    squares[row][column] = SquareType.OUTSIDE;
		}
		else {
		    squares[row][column] = SquareType.EMPTY;
		}
	    }
	}
    }

    /**
     * Movement right
     */
    public void moveRight() {
	if (fallingPoly != null) {
	    this.fallingXCord += 1;
	    if (collisionHandler.hasCollision(this)) {
	    	this.fallingXCord -= 1;
	    }
	}
	notifyListeners();
    }

    /**
     * Movement right
     */
    public void moveLeft() {
	if (fallingPoly != null) {
	    this.fallingXCord -= 1;
	    if (collisionHandler.hasCollision(this)) {
	    	this.fallingXCord += 1;
	    }
	}
	notifyListeners();
    }

    /**
     * movements down
     */
    public void moveDown() {
	if (fallingPoly != null) {
	    this.fallingYCord += 1;
	    if (collisionHandler.hasCollision(this)) {
	    	this.fallingYCord -= 1;
	    }
	}
	notifyListeners();
    }

    /**
     * rotation of falling poly.
     */
    public void rotatePoly() {
	if (fallingPoly != null) {
	    Poly oldPoly = fallingPoly;
	    fallingPoly = fallingPoly.rotateRight();

	    if (collisionHandler.hasCollision(this) || isGameOver) {
		fallingPoly = oldPoly; }

	    notifyListeners();
	}
    }

    /**
     *Moves every row above int "row" one step down.
     */
    private void moveDownRows(int row) {
	for (int h = row; h > 1; h--) {
	    for (int w = 0; w < width; w++) {
		setSquareType(h, w, getSquareType(h-1, w));
	    }
	}
    }

    /**
     * ActionListeners
     */
    public void addBoardListeners(BoardListener bl) {
	boardListeners.add(bl);
    }

    private void notifyListeners() {
	for (BoardListener bl: boardListeners) {
	    bl.boardChanged();
	}
    }

    /**
     * If any row on board is full it removes it.
     * It counts how many rows that'd been removed and send that value to scoreCounter().
     * Gives a specific collisionhandler accordning to amout of cleared rows.
     */
    private void checkFullRows() {
	int numberOfFullRows = 0;
	for (int row = 0; row < height ; row++) {
	    boolean isFullRow = true;
	    for (int col = 0; col < width; col++) {
		if (getSquareType(row, col) == SquareType.EMPTY) {
		    isFullRow = false;
		}
	    }
	    if (isFullRow) {
		numberOfFullRows += 1;
		for (int i = 0; i < squares[row].length; i++) {
		    squares[row+outsideFrameSize][i] = SquareType.EMPTY;
		}
		moveDownRows(row);
	    }
	}
	if (numberOfFullRows == 2) {
	    collisionHandler = new Fallthrough();
	    System.out.println("3");
	}
	else if (numberOfFullRows == 1) {
	    collisionHandler = new FallBehind();
	    System.out.println("2");
	}
	scoreCounter(numberOfFullRows);
    }

    /**
     *returns a random integer betwen 0 and the amount of squaretypes.
     */
    private int randomInt() {
	Random rnd = new Random();
	return rnd.nextInt(TetrominoMaker.getNumberOfTypes()-2);
    }

    /**
     * Puts a new random squaretype as falling poly.
     * Sets its cordinates to be in the horizontal-center and top of the board.
     * if collision while sets isGameOver to true.
     */
    private void placeNewFalling() {
	Poly newFalling = TetrominoMaker.getPoly(randomInt());
	int xCord = ((this.width/2)-(newFalling.getWidth()/2)); //in the middle of the board, (center is in upper left corner)
	int yCord = 0; //at the top of  the board.

	this.fallingPoly = newFalling;
	this.fallingXCord = xCord;
	this.fallingYCord = yCord;

	if (collisionHandler.hasCollision(this)) {
	    isGameOver = true;
	    fallingYCord -= 1; // to place falling outside the visible board
	}
    }

    /**
     * writes falling poly to the board array.
     * sets fallingPoly to null.
     */
    private void writeFallingOnBoard() {
	for (int i = 0; i < fallingPoly.getHeight() ; i++) {
	    for (int j = 0; j < fallingPoly.getWidth() ; j++) {
		if (fallingPoly.getFallingSquareType(i, j) != SquareType.EMPTY && getSquareType(fallingYCord + i, fallingXCord + j) == SquareType.EMPTY) {
		    squares[i + fallingYCord + outsideFrameSize][j + fallingXCord + outsideFrameSize] = fallingPoly
			    .getFallingSquareType(i, j);
		}
	    }
	}
	fallingPoly = null;
}

    public Poly getFallingPoly() {
	return fallingPoly;
    }

    public int getFallingXCord() {
	return fallingXCord;
    }

    public int getFallingYCord() {
	return fallingYCord;
    }


    public void newGame() {
	initializeBoard();
    }

    public boolean getIsGameOver() {
	return isGameOver;
    }

    public int getWidth() {
	return width; }

    public int getHeight() {
	return height; }

    public void setSquareType(int y, int x, SquareType st) {
	squares[y+outsideFrameSize][x+outsideFrameSize] = st;
    }

    public SquareType getSquareType(int h, int w) {
	SquareType rowCol = squares[h+outsideFrameSize][w+outsideFrameSize];
	return rowCol;
    }

    /**
     * sets a specific square at cordinates (y,x) to SquareType.EMPTY on the visible board.
     */
    public void removeSquare(int x, int y){
    	squares[x+outsideFrameSize][y+outsideFrameSize] = SquareType.EMPTY;
        }

    /**
     * Adds the right amount of points to the current score accordning to input "rows".
     */
    private void scoreCounter(int rows) {
	switch(rows) {
	    case 1:
		currentScore += ONE_ROW_SCORE;
		break;
	    case 2:
		currentScore +=  TWO_ROW_SCORE;
		break;
	    case 3:
		currentScore += THREE_ROW_SCORE;
		break;
	    case 4:
		currentScore += FOUR_ROW_SCORE;
		break;
	    default:
		break;
	}
    }

    /**
     * adds a input "player" and the currentScore to the HighscoreList
     */
    public void addToHighscoreList(String player) {
	int score = this.currentScore;
	HighscoreList.getInstance().addHighScore(new Highscore(player, score));
    }

    public int getCurrentScore() {
    	return currentScore;
        }
}