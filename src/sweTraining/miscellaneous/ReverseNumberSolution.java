package sweTraining.miscellaneous;

import java.util.Scanner;

public class ReverseNumberSolution
{
   // Function to reverse given number n
   public int reverseNumber(int originalNum)
   {
      int revNum = 0;
      while (originalNum > 0)
      {
         int lastDigit = originalNum % 10;
         revNum = (revNum * 10) + lastDigit;
         originalNum = originalNum / 10;
      }
      return revNum;
   }

   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the integer - ");
      int n = sc.nextInt();
      ReverseNumberSolution sol = new ReverseNumberSolution();
      int ans = sol.reverseNumber(n);
      System.out.println("The reverse of given number is: " + ans);
      sc.close();
   }
}
