package se.liu.ida.jesjo430.tddd78.lab3;

import javax.swing.*;
import java.awt.*;

public class DiagramViewer
{
    public static void main(String[] args) {

    	DiagramComponent comp = new DiagramComponent();

	Shape c1 = new Circle(50, 100, 500, Color.MAGENTA);
	Shape c2 = new Circle(50, 100, 300, Color.RED);
	Shape c3 = new Circle(50, 100, 100, Color.BLUE);

	Shape r1 = new Rectangle(10, 10, 10, 10, Color.ORANGE);
	Shape r2 = new Rectangle(90, 90, 10, 10, Color.GREEN);
	Shape r3 = new Rectangle(90, 10, 10, 10, Color.WHITE);

	Shape t1 = new Text(10, 100, 90, Color.BLACK, "Hello World!");

	comp.addShape(c1);
	comp.addShape(c2);
	comp.addShape(c3);
	comp.addShape(r1);
	comp.addShape(r2);
	comp.addShape(r3);
	comp.addShape(t1);

    	JFrame frame = new JFrame("Mitt fönster");
    	frame.setLayout(new BorderLayout());
    	frame.add(comp, BorderLayout.CENTER);
    	frame.setSize(800,600);
    	frame.setVisible(true);
        }
}
