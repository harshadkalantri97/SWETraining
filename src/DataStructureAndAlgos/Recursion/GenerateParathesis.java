package DataStructureAndAlgos.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParathesis
{
   public List<String> getParathesis(int n)
   {
      List<String> arrayList = new ArrayList<>();
      generate(0, 0, n, "", arrayList);
      return arrayList;
   }

   private void generate(int open, int close, int n, String current, List<String> result)
   {
      // TODO Auto-generated method stub
      if (open == close && open + close == 2 * n)
      {
         result.add(current);
         return;
      }

      if (open < n)
      {
         generate(open + 1, close, n, current + '(', result);
      }
      if (close < open)
      {
         generate(open, close + 1, n, current + ')', result);
      }
   }

   public static void main(String[] args)
   {
      GenerateParathesis sol = new GenerateParathesis();
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter n for no of parathesis: ");
      int n = sc.nextInt();
      List<String> result = sol.getParathesis(n);
      System.out.println("All combinations of balanced parentheses for n = " + n + " are:");
      for (String combination : result)
      {
         System.out.println(combination);
      }
      sc.close();
   }
}
