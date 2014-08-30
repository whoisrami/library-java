/**
 * Author: Alex Yang
 * Date: 8/30/2014
 * Dependencies: 
 *   - Node.java
 * Better implementation of a SINGLY Linked List supporting different data types
 * No prev pointer.
 */
class linkedListGeneric<T> {
  public static void main (String args[]) {
    linkedListGeneric<Integer> list = new linkedListGeneric<Integer>();
    list.append(1);
    System.out.println(list.toString());
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);
    System.out.println(list.toString());
    //list.insert(3, 6);
    list.remove(4);
    System.out.println(list.toString());
  }

  Node<T> root;
  int size;
  
  public linkedListGeneric () {
    this.root = null;
    this.size = 0;
  }

  //inserts node at a position in the linked list
  public void insert (int position, T data) {
    if(size == 0) {
      this.root = new Node<T>(data);
      size++;
    } else if (position > this.size) {
      System.out.println("Cannot insert in position greater than size of linked list");
    } else {
      Node<T> n = new Node<T>(data);
      Node<T> currentNode = this.root;
      for(int i = 1; i <= this.size; i++ ) {
        if (position == i) {
          n.next = currentNode.next;
          currentNode.next = n;
        }
        currentNode = currentNode.next;
      }
      size++;
    }
  }

  //inserts node at head of linked list
  public void prepend (T data) { 
    if (size == 0) {
      root = new Node<T>(data);
    } else {
      Node<T> n = new Node<T>(data);
      n.next = root;
      root = n;
    }
    size++;
  }

  //inserts node at end of linked list
  public void append (T data) {
    if (size == 0) {
      root = new Node<T>(data);
    } else {
      Node<T> n = root;
      while(n.next != null) {
        n = n.next;
      }
      n.next = new Node<T>(data);
    }
    size++;
  }

  //removes node at a position in the linked list
  public void remove (int position) {
    if(size == 0) {
      System.out.println("Cannot remove node from empty linked list");
    } else if (position > this.size) {
      System.out.println("Cannot remove in position greater than size of linked list");
    } else if (position == this.size) {
      removeAtTail();
    } else {
      Node<T> n = this.root;
      int counter = 1;
      while (n.next.next != null) {
        if (counter == position - 1 ) {
          //shoudl be n.prev = n.next, but since we dont have prev pointer, we use
          //position - 1 to remove the node early before we iterate onto it
          n.next = n.next.next;
          break;
        }
        n = n.next;
        counter++;
      }
      size--;
    }
  }

  //removes node at head of linked list
  public void removeAtHead () {
    if(size==0){
      System.out.println("Cannot remove node from empty linked list");
    }
    Node<T> n = this.root;
    //cover case if only one node in linked list
    if(n.next != null) {
      n = n.next;
    } else {
      n = null;
    }
    size--;
  }

  //removes node at end of linked list
  public void removeAtTail () {
    if(size==0){
     System.out.println("Cannot remove node from empty linked list");
    }
    
    Node<T> n = this.root;
    //cover case if only one node in linked list
    if(n.next != null) {
      while (n.next.next != null) {
        n = n.next;
      }
      n.next = null;
    } else {
      n = null;
    }
    size--;
  }

  //returns size of linked list
  public int size () {
    return size;
  }
 
 //overrides toString method to print out contents of linked list 
 public String toString () {
  if (size==0) {
   return "";
  } else {
   StringBuilder output = new StringBuilder();
   Node<T> tempNode = root;
   while(tempNode.next != null) {
    output.append(tempNode.data).append(", ");
    tempNode = tempNode.next;
   }
   output.append(tempNode.data);
   return output.toString();
  }
 } 
}