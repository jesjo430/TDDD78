package se.liu.ida.jesjo430.tddd78.lab1;

public class Exercise4
{
    public static void main(String[] args) {
      for (int i = 0; i < 10; i++) {
        System.out.println(i + "-fakultet: " + factorial(i));
      }
    }

    private static int factorial(int f) {
      if (f == 0) {
        return 1;
      }

      int result = 1;
      for (int i = 1; i <= f; i++) {
        result *= i;
      }

      return result;
    }
}
