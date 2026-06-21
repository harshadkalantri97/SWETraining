package sweTraining.miscellaneous;
public class ClassRecursion
{
   static void printNumbers(int n)
   {
      if (n == 0)
      {
         return;
      }
      printNumbers(n - 1); // Head recursion
      System.out.print(n + " ");
   }

   static void printTailNumbers(int n)
   {
      if (n == 0)
      {
         return;
      }
      System.out.print(n + " "); // Tail recursion
      printTailNumbers(n - 1); // ✅ correct recursive call
   }

   public static void main(String[] args)
   {
      printNumbers(5);
      System.out.println(); // ✅ move to next line
      printTailNumbers(5);
   }
}
