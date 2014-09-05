/**
 * Author: Alex Yang
 * Date: 9/2/2014
 * Dependencies:
 *   - Node.java
 * Given linked list, detect if it contains a cycle. (aka is it circular)
 * Moreover, detect the node at the beginning of the loop and return it.
 *
 */

class linkedListDetectCycle {
  public static void main(String args[]) {
    Node<Integer> list = new Node<Integer>(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);
    list.append(4);
    list.append(3);
    list.append(2);
    list.append(1);
    System.out.println(list.toString());
  }


}