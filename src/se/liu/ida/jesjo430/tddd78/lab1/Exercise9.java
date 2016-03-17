package se.liu.ida.jesjo430.tddd78.lab1;

import javax.swing.*;

public class Exercise9
{
    public static void main(String[] args) {
	String in = JOptionPane.showInputDialog("Please input a value");
	double input = Double.parseDouble(in);
	System.out.println("Roten ur " + input + " är " + findRoot(input));
    }


    public static double findRoot(double number) {
	double x = number;
	for (int i = 0; i < 10; i++) {
	    x = x - (x * x - number) / (2 * x);
	}
	return x;
    }

}
