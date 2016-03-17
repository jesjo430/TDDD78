package se.liu.ida.jesjo430.tddd78.lab3;

import java.awt.*;

public interface Shape
{
    public void draw(final Graphics g);

    int getX();

    int getY();

    Color getColor();
}
