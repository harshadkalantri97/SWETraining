package dsa.linkedList;

class Node1
{
   int data;
   Node1 next;

   Node1(int data1, Node1 next1)
   {
      this.data = data1;
      this.next = next1;
   }

   Node1(int data1)
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
      Node1 y = new Node1(arr[3]);
      Node1 z = new Node1(arr[4], y);
      System.out.println("Y.data is = " + y.data);
      System.out.println("Y.next is = " + y.next);
      System.out.println("Z.data is = " + z.data);
      System.out.println("Z.next.data is = " + z.next.data);
      System.out.println("Z.next.next is = " + z.next.next);

   }
}
