package dsa.linkedList;

class Node
{
   int data;
   Node next;

   Node(int data1, Node next1)
   {
      this.data = data1;
      this.next = next1;
   }

   Node(int data1)
   {
      this.data = data1;
      this.next = null;
   }
}

public class LinkedList
{
   public static void main(String[] args)
   {
      int[] arr = { 1, 2, 3, 4, 5 };
      Node y = new Node(arr[3]);
      Node z = new Node(arr[2], y);
      System.out.println(y.data);
      System.out.println(y.next);
      System.out.println(z.data);
      System.out.println(z.next.data);
      System.out.println(z.next.next);

   }
}
