package sweTraining.miscellaneous;
public class DirectorySpecificList
{

   static int findPeakIteratively(int arr[], int n)
   {
      int low = 0;
      int high = n - 1;

      while (low < high)
      {
         int mid = low + (high - low) / 2;
         if (arr[mid] < arr[mid + 1])
         {
            low = mid + 1;
         }
         else
         {
            high = mid;
         }
      }

      return low;
   }

   public static void main(String[] args)
   {
      int arr[] = { 25, 12, 22, 34, 45, 65, 55, 12, 66 };
      int n = arr.length;
      int peakIndex = findPeakIteratively(arr, n);
      System.out.println("Peak element is at index: " + peakIndex);
      System.out.println("Peak element is: " + arr[peakIndex]);
   }
}
