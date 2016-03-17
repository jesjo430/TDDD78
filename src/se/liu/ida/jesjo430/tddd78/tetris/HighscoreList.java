package se.liu.ida.jesjo430.tddd78.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Singelton list made once (INSTANCE), keeps all highscores in one and the same list.
 */

public final class HighscoreList
{
    private static final HighscoreList INSTANCE = new HighscoreList();
    private List<Highscore> highScores;

    private HighscoreList() {
        highScores = new ArrayList<>();
    }

    public static HighscoreList getInstance() {
        return INSTANCE;
    }

    public void addHighScore(Highscore score) {
        highScores.add(score);
        Collections.sort(highScores, new ScoreComparator());
    }

    public String highScoreListToString() {
        StringBuilder res = new StringBuilder();
        for (Highscore place : highScores) {
            res.append(place);
            res.append("\n");
        }
        return res.toString();
    }
}
