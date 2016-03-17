package se.liu.ida.jesjo430.tddd78.lab2;

import java.util.Random;

public class Slump
{
    //main
    public static void main(String[] args) {

	for (int i = 0; i<25; i++) {
	    Random rnd = new Random();
	    System.out.println(rnd.nextInt(10));
	}
    }
}
