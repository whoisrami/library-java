package mergeTwoSorted;

import LinkedList.Node;
/**
 * Author: Alex Yang
 * Date: 11/5/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given two sorted linked lists, merge the two into one.
 * Solution:
 * - N/A
 */
public class mergeTwoSorted {
  public static void main(String args[]) {
    Node<Integer> list1 = new Node<Integer>(1);
    list1.append(2);
    list1.append(3);
    list1.append(4);
    list1.append(5);

    Node<Integer> list2 = new Node<Integer>(1);
    list2.append(3);
    list2.append(4);

    Node<Integer> list3 = merge(list1, list2);
    System.out.println(list3.toString());
  }

  static Node<Integer> merge(Node<Integer> list1, Node<Integer> list2) {
    Node<Integer> head = new Node<>(Integer.MIN_VALUE);

    Node<Integer> n = head;
    Node<Integer> l1 = list1;
    Node<Integer> l2 = list2;

    while (l1 != null && l2 != null) {
      if (l1.data <= l2.data) {
        n.next = l1;
        l1 = l1.next;
      } else {
        n.next = l2;
        l2 = l2.next;
      }
      n = n.next;
    }

    if (l1 != null) n.next = l1;
    if (l2 != null) n.next = l2;

    return head.next;
  }
}
