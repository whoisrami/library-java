/**
 * Author: Alex Yang
 * Date: 8/31/2014
 * Dependencies: 
 *   - linkedListGeneric.java
 *   - Node.java
 * Given a linked list, write code to partition it, such that all nodes with data less
 * than x come before all nodes with data greater than x.
 *
 */
class LinkedListPartition<T> extends linkedListGeneric<T> {
  public static void main (String args[]) {
    LinkedListPartition<Integer> list = new LinkedListPartition<Integer>();
    list.append(1); 
    list.append(5);
    list.append(3);
    list.append(2);
    list.append(5);
    System.out.println(list.toString());
    LinkedListPartition<Integer> partitionedList = list.partition(3);
    System.out.println(partitionedList.toString());
  }

  public LinkedListPartition<Integer> partition (int x) {
    LinkedListPartition<Integer> ltXList = new LinkedListPartition<Integer>();
    LinkedListPartition<Integer> gteXList = new LinkedListPartition<Integer>(); 
    Node<T> n = this.root;

    while (n != null) {
      int data = (Integer)n.data;
      if (data < x) {
        ltXList.append(data);
      } else {
        gteXList.append(data);
      }
      n = n.next;
    }
    //append both lists together by finding last element of ltXList and settings its next to the root of gteXList
    Node<Integer> beforeNode = ltXList.root; 
    if (beforeNode == null) return null;
    while (beforeNode.next != null) {
      beforeNode = beforeNode.next;
    } 
    beforeNode.next = gteXList.root;
    return ltXList;
  }
}