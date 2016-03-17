package se.liu.ida.jesjo430.tddd78.lab4;

import java.util.ArrayList;
import java.util.List;
import se.liu.ida.jesjo430.tddd78.lab4.*;


public class Game
{
    private Player player = new Player();
    private List activePowerups = new ArrayList<>();

    public void playerHitPowerup(Powerup power) {
        activePowerups.add(power);
	power.PlayerHitMe(player);
    }
}
