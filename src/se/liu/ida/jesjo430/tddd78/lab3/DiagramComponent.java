package se.liu.ida.jesjo430.tddd78.lab3;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class DiagramComponent extends JComponent
{
    private List<Shape> shapes;

    public DiagramComponent() {
	this.shapes = new ArrayList();
    }

    @Override protected void paintComponent(final Graphics g) {
    	super.paintComponent(g);
	for (Shape shape: shapes) {
	    shape.draw(g);
	}
    }

    public void addShape(Shape s) {
	shapes.add(s);
    }
}
