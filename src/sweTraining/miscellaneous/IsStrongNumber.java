package sweTraining.miscellaneous;

//Solution class containing Strong Number check
class Solution
{
   // Function to check if a number is Strong
   public String isStrongNumber(int n)
   {
      // Store original number
      int original = n;
      // Initialize sum of factorials
      int sum = 0;

      // Process each digit
      while (n > 0)
      {
         // Get last digit
         int digit = n % 10;
         // Compute factorial of digit
         int fact = 1;
         for (int i = 1; i <= digit; i++)
            fact *= i;
         // Add factorial to sum
         sum += fact;
         // Remove last digit
         n /= 10;
      }

      // Compare sum with original number
      return (sum == original) ? "Yes" : "No";
   }
}

// Driver class
public class IsStrongNumber
{
   public static void main(String[] args)
   {
      // Create Solution object
      Solution sol = new Solution();
      // Test numbers
      int[] nums = { 1, 2, 145, 123 };
      for (int n : nums)
         System.out.println(n + ": " + sol.isStrongNumber(n));
   }
}
