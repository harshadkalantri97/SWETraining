package dsa.linkedList;

import java.util.ArrayList;
import java.util.List;

class Node3
{
   int data;
   Node3 next;

   Node3()
   {
      data = 0;
      next = null;
   }

   Node3(int data)
   {
      this.data = data;
      this.next = null;
   }

   Node3(int x, Node3 next)
   {
      data = x;
      this.next = next;
   }
}

public class LinkedListTraversal
{
   public static Node3 arrayToLinkedList(int[] arr)
   {
      if (arr.length == 0)
         return null;
      Node3 head = new Node3(arr[0]);
      Node3 current = head;
      for (int i = 1; i < arr.length; i++)
      {
         current.next = new Node3(arr[i]);
         current = current.next;
      }
      return head;
   }

   public static void main(String[] args)
   {
      int[] arr = { 12, 4, 6, 8, 10 };
      Node3 next = arrayToLinkedList(arr);

      Node3 temp = next;
      while (temp != null)
      {
         System.out.print(temp.data);
         if (temp.next != null)
            System.out.print("->");
         temp = temp.next;

      }
   }
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------//
/* Another way to traverse a node */

class ListNode
{
   public int data;
   public ListNode next;

   ListNode()
   {
      data = 0;
      next = null;
   }

   ListNode(int x)
   {
      data = x;
      next = null;
   }

   ListNode(int x, ListNode next)
   {
      data = x;
      this.next = next;
   }
}

class Solution
{
   public List<Integer> LLTraversal(ListNode head)
   {
      ListNode temp = head;
      List<Integer> ans = new ArrayList<>();
      while (temp != null)
      {
         ans.add(temp.data);
         temp = temp.next;
      }
      return ans;
   }

   public static void main(String[] args)
   {
      // Manual creation of nodes
      ListNode y1 = new ListNode(2);
      ListNode y2 = new ListNode(5);
      ListNode y3 = new ListNode(8);
      ListNode y4 = new ListNode(7);
      // Linking the nodes
      y1.next = y2;
      y2.next = y3;
      y3.next = y4;
      // Creating an instance // Solution class
      Solution solution = new Solution();
      // Calling LLTraversal method // To get the values
      List<Integer> result = solution.LLTraversal(y1);
      System.out.println("Linked List Values:");
      for (int val : result)
      {
         System.out.print(val + " ");
      }
      System.out.println();
   }
}
