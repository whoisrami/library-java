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
    System.out.println(detectCycleStart(list));
  }

  static Node<Integer> detectCycleStart (Node<Integer> head) {
    Node<Integer> slow = head;
    Node<Integer> fast = head;

    //find collision point
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) break;
    }

    //if no cycle
    if (fast == null || fast.next == null) {
      return null;
    }

    //move slow to head, form here we count steps until they collide, which marks the loop start
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return fast;
  }
}