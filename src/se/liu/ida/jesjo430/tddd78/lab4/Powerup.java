package se.liu.ida.jesjo430.tddd78.lab4;

import java.awt.*;

public interface Powerup
{
    String getDescription();

    public void paint(Graphics g, int x, int y);

    public void PlayerHitMe(Player player);
}
