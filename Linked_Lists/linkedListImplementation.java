/**
 * Author: Alex Yang
 * date: 8/27/2014
 * Simple implementation of a Linked List
 */
class linkedListImplementation {
  public static void main (String args[]) {
    Node head = new Node(3);
    head.appendToTail(1);
    head.appendToTail(4);
    head.appendToTail(9);
    head.appendToTail(2);
  } 
}

class Node {
  Node next = null;
  int data;

  public Node (int data) {
    System.out.println(data);
    this.data = data;
  }

  //loops through starting from head, and appends at the very end
  void appendToTail (int data) {
    Node tail = new Node(data);
    Node n = this;
    while(n.next != null){
      System.out.println("next:" + n.next.getData());
      n = n.next;
    }
    n.next = tail;
  }

  //TODO: implement delete node
  
  //TODO: implement insert node

  //returns data at given node
  public int getData(){
    return this.data;
  }
}