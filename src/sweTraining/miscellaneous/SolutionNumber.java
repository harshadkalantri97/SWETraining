package sweTraining.miscellaneous;

public class SolutionNumber
{
   /*
    * We know using maths that sum of all numbers in a range from 0 to n is n(n+1) / 2 Here we use the same formula to set the full sum and then get sum of the
    * array Missing number is the sum of range - sum of array Simple, easy and optimized.
    */
   public int missingNumber(int[] nums)
   {
      int N = nums.length;
      int sum1 = (N * (N + 1)) / 2;
      int sum2 = 0;
      for (int num : nums)
      {
         sum2 += num;
      }
      int missingNum = sum1 - sum2;
      return missingNum;
   }

   public static void main(String[] args)
   {
      int[] nums = { 0, 1, 2, 4 };
      SolutionNumber solution = new SolutionNumber();
      int ans = solution.missingNumber(nums);
      System.out.println("The missing number is: " + ans);
   }
}
