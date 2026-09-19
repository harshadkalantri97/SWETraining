package dsa.linkedList;

class ListNode1
{
   int data;
   ListNode1 next;

   ListNode1()
   {
      this.data = 0;
      this.next = null;
   }

   ListNode1(int x)
   {
      this.data = x;
      this.next = null;
   }

   ListNode1(int x, ListNode1 next)
   {
      this.data = x;
      this.next = next;
   }
}

public class DeleteLL
{
   public static ListNode1 deleteNode(ListNode1 head)
   {
      if (head == null)
         return null;
      ListNode1 temp = head;
      head = head.next;
      temp = null;
      return head;
   }

   public static ListNode1 removeTail(ListNode1 head)
   {
      if (head == null || head.next == null)
         return null;
      ListNode1 temp = head;
      while (temp.next.next != null)
      {
         temp = temp.next;
      }
      temp.next = null;
      return head;
   }

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

   public static void main(String[] args)
   {
      int[] arr = { 1, 3, 5, 7, 9, 11 };
      ListNode1 newNode = arrayToLinkedList(arr);
      ListNode1 newTailNode = newNode;
      System.out.println("Original List:");
      printLinkedList(newNode);
      System.out.println("Delete head node list: ");
      newNode = deleteNode(newNode);
      printLinkedList(newNode);
      System.out.println("Delete Tail: ");
      newTailNode = removeTail(newTailNode);
      printLinkedList(newTailNode);
   }

}
