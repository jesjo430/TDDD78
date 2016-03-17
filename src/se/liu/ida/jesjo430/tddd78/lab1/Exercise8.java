package se.liu.ida.jesjo430.tddd78.lab1;

import javax.swing.*;

public class Exercise8
{
    public static void main(String[] args) {
	String question1 = "Quit?";
	String question2 = "Really ?";

	while (true) {
	    if (askUser(question1) & askUser(question2))  {
		System.out.println("ja");
		break;
	    }
	}
    }


	public static boolean askUser(String question) {
	    if (JOptionPane.showConfirmDialog(null, question, "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		return true;
	    }
	    return false;
	}
}