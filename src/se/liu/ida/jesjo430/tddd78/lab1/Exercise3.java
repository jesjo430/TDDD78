package se.liu.ida.jesjo430.tddd78.lab1;

import javax.swing.*;

public class Exercise3
{
    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Please enter a number");
	int tabell = Integer.parseInt(input);
	multi_table(tabell);
    }

    public static void multi_table(int number) {
    	for (int i = 1; i < 13; i++) {
	    System.out.println(i + " * " + number + " = " + i*number);
	}
    }
}
