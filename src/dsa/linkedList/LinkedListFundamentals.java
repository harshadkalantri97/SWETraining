package dsa.linkedList;

import java.util.Scanner;

class Node
{
   int data;
   Node next;

   Node(int data)
   {
      this.data = data;
      this.next = null;
   }
}

public class LinkedListFundamentals
{

   // Convert array to Linked List
   public static Node arrayToLinkedList(int[] arr)
   {
      if (arr.length == 0)
         return null;
      Node head = new Node(arr[0]);
      Node current = head;
      for (int i = 1; i < arr.length; i++)
      {
         current.next = new Node(arr[i]);
         current = current.next;
      }
      return head;
   }

   // Print Linked List
   public static void printLinkedList(Node head)
   {
      Node current = head;
      while (current != null)
      {
         System.out.print(current.data + " -> ");
         current = current.next;
      }
      System.out.println("null");
   }

   // Search element
   public static boolean searchElement(Node head, int target)
   {
      Node current = head;
      while (current != null)
      {
         if (current.data == target)
            return true;
         current = current.next;
      }
      return false;
   }

   public static int linkedListLength(Node head)
   {
      int length = 0;
      Node current = head;
      while (current != null)
      {
         length++;
         current = current.next;
      }
      return length;
   }

   public static void main(String[] args)
   {
      int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
      // Array -> Linked List
      Node head = arrayToLinkedList(arr);
      // Print Linked List
      printLinkedList(head);
      // Find length
      int length = linkedListLength(head);
      System.out.println("Length: " + length);
      // Search
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the element to search: ");
      int target = sc.nextInt();
      if (searchElement(head, target))
         System.out.println("Element " + target + " found.");
      else
         System.out.println("Element " + target + " not found.");
      sc.close();
   }
}
