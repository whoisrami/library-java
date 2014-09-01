/**
 * Author: Alex Yang
 * Date: 8/30/2014
 * Dependencies: 
 *   - linkedListGeneric.java
 * Given an unsorted linked list, remove all duplicates.
 * My version of the solution assumes we are not given a data buffer, otherwise 
 * the solution would be trivial, just use a hashmap.
 * Instead, we are use two pointers, current and runner, to run through the linked list and remove duplicates. 
 */
class linkedListRemoveDuplicates<T> extends linkedListGeneric<T> {
  public static void main (String args[]) {
    linkedListRemoveDuplicates<Integer> list = new linkedListRemoveDuplicates<Integer>();
    list.append(1); 
    list.append(3);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(3);
    list.append(5);
    list.append(5);
    System.out.println(list.toString());
    list.removeDuplicates();
    System.out.println(list.toString());
  }

  public void removeDuplicates () {
    if (this.root == null) {
      System.out.println("Cannot remove node from empty linked list");
    }

    Node<T> current = this.root;
    while(current != null) {
      Node<T> runner = current;
      while (runner.next != null) {
        if (current.data == runner.next.data) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      current = current.next;
    }
  }
}