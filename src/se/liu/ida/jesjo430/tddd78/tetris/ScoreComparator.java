package se.liu.ida.jesjo430.tddd78.tetris;

import java.util.Comparator;

/**
 * A comparator that
 *      return 1 if score 2 is larger than score 1.
 *      return 0 if score 1 is equal to score 2.
 *      return -1 if score 1 is larger than score 2.
 */

public class ScoreComparator implements Comparator<Highscore>
{
    // sorts in descending order
       public int compare(Highscore o1, Highscore o2) {
           if (o2.getPlayerScore() > o1.getPlayerScore())
               return 1;
           if (o2.getPlayerScore() < o1.getPlayerScore())
               return -1;
           return 0;
       }
}
