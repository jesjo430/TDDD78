package se.liu.ida.jesjo430.tddd78.lab4;

public class NumberTester
{
    private NumberTester() {}

        public static Boolean isEven(int number) {
            int remainder = number % 2;
            return remainder == 0;
        }

        public static void main(String[] args) {
            System.out.println(isEven(17));
            System.out.println(isEven(42));
        }
}
