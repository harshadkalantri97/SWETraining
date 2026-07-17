package DataStructureAndAlgos.Arrays_Sorting;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence_in_an_Array
{
   public int longestConsecutive(int[] nums)
   {
      int n = nums.length;
      if (n == 0)
         return 0; // If the array is empty
      int longest = 1; // Initialize the longest sequence length
      Set<Integer> longestSubset = new HashSet<>();
      for (int i = 0; i < n; i++)
      {
         longestSubset.add(nums[i]); // Put all the array elements into the set
      }
      /*
       * Traverse the set to find the longest sequence
       */
      for (int numberSet : longestSubset) // Check if 'it' is a starting number of a sequence
      {
         if (!longestSubset.contains(numberSet - 1)) // ****Initialize the count of the current sequence starting from 0 else it will start from one.
         {
            int count = 1;
            int numValue = numberSet; // Starting element of the sequence
            while (longestSubset.contains(numValue + 1)) // Find consecutive numbers in the set
            {
               // Move to the next element in the sequence
               numValue += 1;
               count += 1; // Increment the count of the sequence
            }
            longest = Math.max(longest, count); // Update the longest sequence length
         }
      }
      return longest;
   }

   public static void main(String[] args)
   {
      int[] a = { 100, 4, 200, 1, 3, 2, 9, 5 };
      // Create an instance of the solution class
      Longest_Consecutive_Sequence_in_an_Array solution = new Longest_Consecutive_Sequence_in_an_Array();
      // Function call to find the longest consecutive sequence
      int ans = solution.longestConsecutive(a);
      System.out.println("The longest consecutive sequence is " + ans);
   }
}
