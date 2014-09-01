/**
 * Author: Alex Yang
 * Date: 8/31/2014
 * Dependencies: 
 *   - linkedListGeneric.java
 * Given only a node, how can you remove it from a middle of a linked list.
 * Assuming we do not know the head of the linked list.
 *
 */
class linkedListDeleteMiddleNode<T> extends linkedListGeneric<T> {
  public static void main (String args[]) {
    linkedListDeleteMiddleNode<Integer> list = new linkedListDeleteMiddleNode<Integer>();
    list.append(1); 
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);;
    System.out.println(list.toString());
    list.deleteMiddle(list.root.next.next);
    System.out.println(list.toString());
  }

  //NOTE: this technique will not work if trying to remove last node.
  public void deleteMiddle (Node<T> n) {
    if (n == null || n.next == null) return;
    n.data = n.next.data;
    n.next = n.next.next;
  }
}