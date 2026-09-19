package dsa.linkedList;

import java.util.Scanner;

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
   // Removing first element in LinkedList
   public static ListNode1 deleteNode(ListNode1 head)
   {
      if (head == null)
         return null;
      head = head.next;
      return head;
   }

   // Removing last Element in Linkedlist
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

   // Removing kth element from LinkedList
   public static ListNode1 removeK(ListNode1 head, int k)
   {
      if (head == null || k <= 0)
         return head;
      if (k == 1)
         return head.next;
      int counter = 0;
      ListNode1 temp = head;
      ListNode1 prev = null;
      while (temp != null)
      {
         counter++;
         if (counter == k)
         {
            prev.next = temp.next;
            return head;
         }
         prev = temp;
         temp = temp.next;
      }
      System.out.println("The kth value is more than the length of the LinkedList.");
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

   public static void main(String[] args)
   {
      int[] arr = { 1, 3, 5, 7, 9, 11 };

      ListNode1 newNode = arrayToLinkedList(arr);
      ListNode1 newTailNode = arrayToLinkedList(arr);
      ListNode1 kthNode = arrayToLinkedList(arr);
      System.out.println("Original List:");
      printLinkedList(newNode);
      System.out.println("Delete head node list:");
      newNode = deleteNode(newNode);
      printLinkedList(newNode);
      System.out.println("Delete Tail:");
      newTailNode = removeTail(newTailNode);
      printLinkedList(newTailNode);
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the kth Element");
      kthNode = removeK(kthNode, sc.nextInt());
      System.out.println("kthNodeRemoval:");
      printLinkedList(kthNode);
      sc.close();
   }

}
