package se.liu.ida.jesjo430.tddd78.lab3;

import java.awt.*;

public class Circle extends AbstractShape
{
    private int radius;

    public Circle(final int x, final int y, final int radius, final Color color) {
	super(color, y, x);
	if (radius < 0) {
	        throw new IllegalArgumentException("Negativ radie!");
	    }
	this.radius = radius;
    }

    @Override public void draw(final Graphics g) {
    	// System.out.println("Ritar:" + this);

	int diameter = 2*radius;
	g.setColor(color);
	g.drawOval(x,y,diameter,diameter);
    }

    @Override public String toString() {
	return "Circle{" +
	       "x=" + x +
	       ", y=" + y +
	       ", radius=" + radius +
	       ", color=" + color +
	       '}';
    }
}
