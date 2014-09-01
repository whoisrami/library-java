/**
 * Author: Alex Yang
 * Date: 8/31/2014
 * Dependencies: 
 *   - linkedListGeneric.java
 * Given a linked list, write code to partition it, such that all nodes with data less
 * than x come before all nodes with data greater than x.
 *
 */
class linkedListPartition<T> extends linkedListGeneric<T> {
  public static void main (String args[]) {
    linkedListPartition<Integer> list = new linkedListPartition<Integer>();
    list.append(1); 
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);;
    System.out.println(list.toString());
    list.partition(3);
    System.out.println(list.toString());
  }

  public void partition (int x) {
    return;
  }
}