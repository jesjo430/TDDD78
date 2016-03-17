package se.liu.ida.jesjo430.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;


public class TestShape
{
    public static void main(String[] args) {
	final ArrayList<Shape> shapes = new ArrayList<>();

	shapes.add(new Circle(50, 50, 50, Color.MAGENTA));
	shapes.add(new Circle(50, 50, 30, Color.RED));
	shapes.add(new Circle(50, 50, 10, Color.BLUE));

	shapes.add(new Rectangle(10, 10, 10, 10, Color.ORANGE));
	shapes.add(new Rectangle(90, 90, 10, 10, Color.GREEN));
	shapes.add(new Rectangle(90, 10, 10, 10, Color.WHITE));

	shapes.add(new Text(50, 50, 90, Color.BLACK, "Hello World!"));

	System.out.println(shapes);


    }



}
