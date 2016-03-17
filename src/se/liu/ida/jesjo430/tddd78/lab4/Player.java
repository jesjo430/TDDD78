package se.liu.ida.jesjo430.tddd78.lab4;

public class Player
{

    public enum Speed {
	SLOW, MEDIUM, FAST
    }

    public enum Mode {
	NORMAL, GHOST, INVULNERABLE
    }

    private int x, y;
    private Speed speed = Speed.MEDIUM;
    private Mode mode = Mode.NORMAL;

    public String getSpeed() {
	return speed.toString();
    }

    public void setSpeed(final Speed speed) {
	this.speed = speed;
    }

    public String getMode() {
	return mode.toString();
    }
     public void setMode(final Mode mode) {
	 this.mode = mode;
     }

    public void moveRight() {
	switch (speed) {
	    case SLOW:
		x += 5;
		break;
	    case MEDIUM:
		x += 10;
		break;
	    case FAST:
		x += 20;
		break;
	}
    }

        /**
         * Describe current speed and mode -- used for a status display
         */
    public String getDescription() {
	StringBuilder buf = new StringBuilder();
	buf.append("Player is ");

	buf.append(speed);
	buf.append(" and ");
	buf.append(mode);

	return buf.toString();
    }

    public static void main(String[] args) {
	final Player player = new Player();
	System.out.println(player.getDescription());
    }
}
