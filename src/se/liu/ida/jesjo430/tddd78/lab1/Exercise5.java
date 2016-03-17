package se.liu.ida.jesjo430.tddd78.lab1;

public class Exercise5
{
    public static void main(String[] args) {
	for (int i = 2; i < 100; i++) {
	    System.out.println(i + " returned " + isPrime(i));
	}
    }

    public static boolean isPrime(int number) {
	for (int i = 2; i < number; i++) {
	    int rest = number % i;
	        if (rest == 0) {
		    return false;
	        }
	}
	return true;
    }
}
