package se.liu.ida.jesjo430.tddd78.lab4;

import java.awt.*;
import se.liu.ida.jesjo430.tddd78.lab4.Player.*;

public class SpeedPowerup implements Powerup
{
    @Override public String getDescription() {
        return "Makes a player faster";
    }

    public void paint(Graphics g, int x, int y) {
        g.fillRect(x, y, 10, 10);
    }

    public void PlayerHitMe(Player player) {
	player.setSpeed(Speed.FAST);
    }
}
