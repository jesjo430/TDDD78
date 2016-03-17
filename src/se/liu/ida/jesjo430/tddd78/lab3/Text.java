package se.liu.ida.jesjo430.tddd78.lab3;

import java.awt.*;

public class Text extends AbstractShape
{
    private int size;
    private String string;

    public Text(final int x, final int y, final int size, final Color color, final String string) {
	super(color, y, x);
	this.size = size;
	this.string = string;
    }

    @Override public void draw(final Graphics g) {
	//System.out.println("Ritar:" + this);

	g.setColor(color);
	g.setFont(new Font("serif", Font.PLAIN, size));
	g.drawString(string, x, y);
    }

    @Override public String toString() {
	return "Text{" +
	       "x=" + x +
	       ", y=" + y +
	       ", size=" + size +
	       ", color=" + color +
	       ", string='" + string + '\'' +
	       '}';
    }

}
