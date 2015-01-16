package ReverseLinkedList;

import LinkedList.Node;

/**
 * Author: Alex Yang
 * Date: 1/15/15
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class ReverseLinkedList2 {
  public static void main(String[] args) {
    Node<Integer> list = new Node<>(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);

//    System.out.println(reverseIterative(list).toString());
    System.out.println(reverse(list).toString());

  }

  public static Node<Integer> reverse(Node<Integer> head) {
    if (head == null || head.next == null) return head;

    Node<Integer> original = head.next;
    Node<Integer> reversed = head;
    reversed.next = null;

    while (original != null) {
      Node<Integer> tmp = original;
      original = original.next;

      tmp.next = reversed;
      reversed = tmp;
    }

    return reversed;
  }
}
