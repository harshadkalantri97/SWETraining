package sweTraining.miscellaneous;

import java.util.Arrays;

class newSolution
{
   public int[] newProduct(int[] nums)
   {
      int[] answer = new int[nums.length];
      int prefix = 1;
      for (int i = 0; i < nums.length; i++)
      {
         answer[i] = prefix;
         prefix *= nums[i];
      }
      int suffix = 1;
      for (int j = nums.length - 1; j >= 0; j--)
      {
         answer[j] *= suffix;
         suffix *= nums[j];
      }
      return answer;
   }
}

public class ProductExceptSelf
{
   public static void main(String[] args)
   {
      int nums[] = { 4, 6, 8, 10 };
      newSolution solution = new newSolution();
      int[] value = solution.newProduct(nums);
      System.out.println(Arrays.toString(value));
   }

}
