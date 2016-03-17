package se.liu.ida.jesjo430.tddd78.lab3;

import java.util.ArrayList;
import java.awt.Color;


public class TestCircle
{
    public static void main(String[] args) {
	final ArrayList<Circle> circles = new ArrayList<>();

	circles.add(new Circle(50, 50, 50, Color.MAGENTA));
	circles.add(new Circle(50, 50, 30, Color.RED));
	circles.add(new Circle(50, 50, 10, Color.BLUE));

	for (Circle circle : circles) {
	    System.out.println(circle.getX());
	}
    }



}
