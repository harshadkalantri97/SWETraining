package DataStructureAndAlgos.Recursion;

import java.util.Scanner;

public class PowerNumber
{
   public double power(double x, long n)
   {
      if (n == 0)
         return 1.0;
      if (x == 1)
         return n;
      if (n % 2 == 0)
         return power(x * x, n / 2);
      return x * power(x * x, n / 2);
   }

   public double myPow(double x, int n)
   {
      long num = n;
      if (num < 0)
         return (1.0 / power(x, -num));
      return power(x, num);
   }

   public static void main(String[] args)
   {
      PowerNumber pow = new PowerNumber();
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the double no: ");
      double doubleVal = sc.nextDouble();
      System.out.println("Enter the power int no: ");
      int powerVal = sc.nextInt();
      sc.close();
      System.out.println("The answer is: " + pow.power(doubleVal, powerVal));
   }
}
