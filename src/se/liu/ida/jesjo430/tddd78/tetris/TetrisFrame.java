package se.liu.ida.jesjo430.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The graphical window containing the components.
 * All dialogwindows and the timer running the game.
 */

public class TetrisFrame extends JFrame
{
    private Board gameBoard;
    private TetrisComponent gArea;
    private static final int UPDATE_INTERVALL = 500; // in ms. used by clock-cycle.
    private static final int FONT_SIZE = 20; // size of text used in frame.
    private JMenu scoreMenu; // the menu item showing the current score in the frame.


    public TetrisFrame(final Board gameBoard) throws HeadlessException {
	super("MyWindowTitle");
	this.gameBoard = gameBoard;
	this.gArea = new TetrisComponent(gameBoard);

	createMenus();

	this.setLayout(new BorderLayout());
	this.add(gArea, BorderLayout.CENTER);
	gArea.setFont(new Font("Courier New",Font.PLAIN,FONT_SIZE));

	this.pack();
	this.setVisible(true);

	Action doOneStep = new AbstractAction() {
	    @Override public void actionPerformed(final ActionEvent e) {
		gameBoard.tick();
		frameTick();
	    }
	};

	final Timer clockTimer = new Timer(UPDATE_INTERVALL, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();

    }

    private void updateScoreViewer() {
    	String score = Integer.toString(gameBoard.getCurrentScore());
    	scoreMenu.setText("Score: " + score);
        }

    private void createMenus() {
	final JMenuBar menuBar = new JMenuBar();
	final JMenu file = new JMenu("File");
	scoreMenu = new JMenu("Score: 0");

	final JMenuItem quit = new JMenuItem("Quit");

	quit.addActionListener(this::quitSesion);
	file.add(quit);
	menuBar.add(file);
	menuBar.add(Box.createHorizontalGlue());
	menuBar.add(scoreMenu);

	this.setJMenuBar(menuBar);
    }

    /**
     * exits the sesion. errorcode 0.
     */
    private void quitSesion(ActionEvent e) {
	if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	    System.exit(0);
	}
    }

    /**
     * dialogbox to ask user if to start a new game or not.
     * if not exit sesion with error 0.
     */
    private void runNewGameDialog() {
	int option = JOptionPane.showConfirmDialog(null," > Play again? < ", "INFORMATION", JOptionPane.YES_NO_CANCEL_OPTION);

	if (option == JOptionPane.YES_OPTION) {
	    gameBoard.newGame(); }

	else {
	    System.exit(0); }
    }

    /**
     * show game over dialogbox.
     */
    private void runGameOverDialog() {
	JOptionPane.showConfirmDialog(null, "Game Over!", "", JOptionPane.OK_CANCEL_OPTION);
    }

    /**
     * dialogbox with input for string.
     */
    private String enterPlayerName() {
	String name = JOptionPane.showInputDialog(null, "Enter your name: ", "", JOptionPane.INFORMATION_MESSAGE);
	return name;

    }

    /**
     * the dialogbox to show all highscores in the highsvorelist.
     */
    private void showHighScore() {
	JOptionPane.showConfirmDialog(null, HighscoreList.getInstance().highScoreListToString(), "HighScores", JOptionPane.OK_CANCEL_OPTION);
    }

    /**
     * acoordning to variable isGameOver runs:
     * if true
     * 		inform gameover.
     * 		enter playername.
     * 		adds current score to highscorelist.
     * 		show the highscorelist.
     * 		run gameover dialog.
     *
     * 	else update score.
     */
    private void frameTick() {
	if (gameBoard.getIsGameOver()){
	    runGameOverDialog();
	    String name = enterPlayerName();
	    gameBoard.addToHighscoreList(name);
	    showHighScore();
	    runNewGameDialog();
	}
	updateScoreViewer();
    }
}
