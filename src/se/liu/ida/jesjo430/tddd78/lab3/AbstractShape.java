package se.liu.ida.jesjo430.tddd78.lab3;

import java.awt.*;

public abstract class AbstractShape implements Shape
{
    protected int x;
    protected int y;
    protected Color color;

    public AbstractShape(final Color color, final int y, final int x) {
	this.color = color;
	this.y = y;
	this.x = x;
    }

    @Override public boolean equals(final Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;

	final AbstractShape that = (AbstractShape) o;

	if (x != that.x) return false;
	if (y != that.y) return false;
	if (color != null ? !color.equals(that.color) : that.color != null) return false;

	return true;
    }

    @Override public int hashCode() {
	int result = x;
	result = 31 * result + y;
	result = 31 * result + (color != null ? color.hashCode() : 0);
	return result;
    }

    public int getX() { return x;}

    public int getY() { return y;}

    public Color getColor() { return color;}

}
