/**
 * Author: Alex Yang
 * date: 8/27/2014
 * Very basic implementation of a singly Linked List
 */
class linkedListSimple {
  public static void main (String args[]) {
    NodeSimple head = new NodeSimple(3);
    head.appendToTail(1);
    head.appendToTail(4);
    head.appendToTail(9);
    head.appendToTail(2);
    head.displayList();
    head = head.deleteNodeSimple(head, 3);
    head = head.deleteNodeSimple(head, 2);
    head.displayList();
  } 
}

class NodeSimple {
  NodeSimple next = null;
  int data;

  public NodeSimple (int data) {
    this.data = data;
  }

  //loops through starting from head, and appends at the very end
  void appendToTail (int data) {
    NodeSimple tail = new NodeSimple(data);
    NodeSimple n = this;
    while (n.next != null) {
      n = n.next;
    }
    n.next = tail;
  }

  //deletes a node from the linked list
  NodeSimple deleteNodeSimple (NodeSimple head, int d) {
    //if head is node to be removed, return head.next as the new head
    if (head.data == d) {
      System.out.println("deleting head at: " + d);
      return head.next;
    }    

    NodeSimple n = head;
    while (n.next != null) {
      if (n.next.data == d) {
        n.next = n.next.next;
        return head; 
      }
      n = n.next;
    }

    return head;
  }

  //returns data at given node
  public int getData() {
    return this.data;
  }

  //prints out all nodes in linked list
  void displayList(){
    System.out.println("Displaying Linked List: ");
    NodeSimple n = this;
    while (n != null) {
      System.out.print(n.data);
      n = n.next;
    }
    System.out.println("\n");
  }
}





