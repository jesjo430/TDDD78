package se.liu.ida.jesjo430.tddd78.lab1;

public class Exercise10
{
    public static void main(String[] args) {
	int tal = 16777217;
	double decimaltal = tal;
	int tillbaka = (int) decimaltal;
	System.out.println(tal);
	System.out.println(decimaltal);
	System.out.println(tillbaka);

	System.out.println("----------------------");

	long big = 2147483647;
	long bigger = big+1;
	System.out.println(big);
	System.out.println(bigger);
    }
}
