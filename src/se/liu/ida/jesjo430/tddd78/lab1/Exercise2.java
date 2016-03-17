package se.liu.ida.jesjo430.tddd78.lab1;
import javax.swing.*;
public class Exercise2
{
    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Please enter a value for variable >min<.");
	int min = Integer.parseInt(input);
	input = JOptionPane.showInputDialog("Please enter a value for variable >max<.");
	int max = Integer.parseInt(input);
	input = JOptionPane.showInputDialog("Type 'for' or 'while' to choose calculation-method.");

	switch (input) {
	    case "for":
		System.out.println(sumFor(min, max));
		break;
	    case "while":
		System.out.println(sumWhile(min, max));
		break;
	    default:
		System.out.println("Please enter a valid calculation-method and try again.");
		break;
	}
    }


    public static int sumFor(int min, int max){
	int result = 0;
	for (int i = min; i <= max; i++){
	    result += i;
	}
	return result;
	}


    public static int sumWhile(int min, int max) {
	int result = 0;
	while (min <= max) {
	    result += min;
	    min++;
	}
	return result;
    }
}
