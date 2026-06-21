package DataStructureAndAlgos.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet
{
   private void backtrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> ans)
   {
      if (index == n) // if the below condition is added above, if will abrupt recursion as soon as one value is generated.
      {
         if (!current.isEmpty()) // --> This condition is added to not generated empty set
            ans.add(new ArrayList<>(current));
         return;
      }
      backtrack(index + 1, n, nums, current, ans);
      current.add(nums[index]);
      backtrack(index + 1, n, nums, current, ans);
      current.remove(current.size() - 1);
      /*
       * We need to remove the current.size() because Then the element you added stays in current even after returning from recursion. As a result: The state is
       * not restored. Future branches start with extra elements that shouldn't be there. You get incorrect subsets (and often duplicates or oversized subsets).
       */
   }

   public List<List<Integer>> powerSet(int[] nums)
   {
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> current = new ArrayList<>();
      backtrack(0, nums.length, nums, current, ans);
      return ans;
   }

   public static void main(String[] args)
   {
      PowerSet obj = new PowerSet();
      int[] arr = { 1, 2, 3, 5, 7 };
      List<List<Integer>> result = obj.powerSet(arr);
      for (List<Integer> subset : result)
      {
         System.out.println(subset);
      }
   }

}
