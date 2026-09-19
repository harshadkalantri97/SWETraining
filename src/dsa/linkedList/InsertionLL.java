package dsa.linkedList;

class ListNode2
{
   int data;
   ListNode2 next;

   ListNode2()
   {
      this.data = 0;
      this.next = null;
   }

   ListNode2(int data1)
   {
      this.data = data1;
      this.next = null;
   }

   ListNode2(int data1, ListNode2 nextVal)
   {
      this.data = data1;
      this.next = nextVal;
   }
}

public class InsertionLL
{
   // Print Linked List
   public static void printLinkedList(ListNode1 head)
   {
      ListNode1 current = head;
      while (current != null)
      {
         System.out.print(current.data + " -> ");
         current = current.next;
      }
      System.out.println("null");
   }

   // Converting array to LinkedList
   public static ListNode1 arrayToLinkedList(int[] arr)
   {
      if (arr.length == 0)
         return null;
      ListNode1 head = new ListNode1(arr[0]);
      ListNode1 current = head;
      for (int i = 1; i < arr.length; i++)
      {
         current.next = new ListNode1(arr[i]);
         current = current.next;
      }
      return head;
   }

}
