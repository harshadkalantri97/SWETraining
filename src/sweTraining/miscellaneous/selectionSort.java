package sweTraining.miscellaneous;

public class selectionSort
{
   public static int[] selectionSort(int[] nums)
   {
      for (int i = 0; i < nums.length - 1; i++)
      {
         int minIndex = i;
         for (int j = i + 1; j < nums.length; j++)
         {
            if (nums[j] < nums[minIndex])
               minIndex = j;
         }
         if (minIndex != i)
         {
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
         }
      }
      return nums;
   }

   public static void main(String[] args)
   {
      int[] arr = { 7, 5, 9, 2, 8 };

      System.out.print("Original array: ");
      for (int num : arr)
      {
         System.out.print(num + " ");
      }
      System.out.println();
      int[] sortedArr = selectionSort(arr);
      System.out.print("Sorted array: ");
      for (int num : sortedArr)
      {
         System.out.print(num + " ");
      }
      System.out.println();
   }
}
