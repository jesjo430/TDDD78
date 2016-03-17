package se.liu.ida.jesjo430.tddd78.lab4;

import java.awt.*;
import se.liu.ida.jesjo430.tddd78.lab4.Player.Mode;

public class GhostPowerup implements Powerup
{
    public void paint(Graphics g, int x, int y) {
        g.fillOval(x, y, 10, 10);
    }

    @Override public String getDescription() {
        return "Makes a player into a ghost that can travel through walls";
    }

    public void PlayerHitMe(Player player) {
    	player.setMode(Mode.GHOST);
        }
}