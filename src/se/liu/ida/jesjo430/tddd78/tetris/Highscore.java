package se.liu.ida.jesjo430.tddd78.tetris;

/**
 * The highscores thats beeing created by the user after each game.
 */


public class Highscore
{
    private int playerScore;
    private String playerName;

    public Highscore(final String playerName, final int playerScore) {
	this.playerScore = playerScore;
	this.playerName = playerName;
    }

    public int getPlayerScore() {
	return playerScore;
    }

    /**
     * creates a nice string thats being used for showing the highcores and its points.
     */
    @Override public String toString() {
	return playerName + "  .......................  " + playerScore + "p";
    }
}
