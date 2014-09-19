/**
 * Author: Alex Yang
 * Date: 9/2014
 * Dependencies:
 *  - Node.java (in linked lists section)
 * Description:
 *  - Simple Implementation of a LinkedList, using a Node Class.
 *  - UPDATE: 9/10/2014 added prev pointer to solve some stack problems
 * Solutions:
 *  - N/A
 */
class Node<T> {
  public static void main (String args[]) {
    Node<Integer> list = new Node<Integer>(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);
    while (list != null) {
      if (list.next != null) System.out.println("Next:" + list.next.data);
      if (list.prev != null) System.out.println("Prev:" + list.prev.data);
      list = list.next;
    }
    //System.out.println(list.toString());
    //list.insert(3, 6);
    //System.out.println(list.toString());
  }

  Node<T> next = null;
  Node<T> prev = null;
  T data;

  public Node (T value) {
    this.data = value;
  }

  public Node<T> next () {
    return this.next;
  }

  public T value () {
    return this.data;
  }

  public void setNext (Node<T> elem) {
    this.next = elem;
  } 

  public void setValue (T value) {
    this.data = value;
  }

  public int getSize () {
    int size = 0;
    Node<T> n = this;
    while(n != null) {
      size++;
      n = n.next;
    }
    return size;    
  }

  //loops through starting from head, and appends at the very end
  void append (T data) {
    Node<T> tail = new Node<T>(data);
    Node<T> n = this;

    while (n.next != null) {
      n = n.next;
    }
    tail.prev = n;
    n.next = tail;
  }

  //overrides toString method to print out contents of linked list
  public String toString () {
    StringBuilder output = new StringBuilder();
    Node<T> tempNode = this;
    while(tempNode.next != null) {
      output.append(tempNode.data).append(", ");
      tempNode = tempNode.next;
    }
    output.append(tempNode.data);
    return output.toString();
  }
}