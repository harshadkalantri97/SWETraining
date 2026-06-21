package DataStructureAndAlgos.Recursion;

public class SubsequenceOfk
{
   public boolean checkSubsequenceSum(int[] nums, int k)
   {
      // your code goes here
      int n = nums.length;
      return solve(0, n, nums, k);

   }

   private boolean solve(int i, int n, int[] nums, int k)
   {
      if (k == 0)
         return true;
      // The sum has been found, true
      if (k < 0)
         return false; // subset not present
      // All elements have been processed.
      // All elements processed; target is achieved only when k becomes 0.
      if (i == n)
         return k == 0;
      return solve(i + 1, n, nums, k - nums[i]) || solve(i + 1, n, nums, k);
   }

   public static void main(String[] args)
   {
      SubsequenceOfk sol = new SubsequenceOfk();
      int[] nums = { 1, 2, 3, 4 };
      int target = 12;
      System.out.println(sol.checkSubsequenceSum(nums, target));
   }
}
