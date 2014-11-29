package ReverseLinkedList;

import LinkedList.Node;

/**
 * Author: Alex Yang
 * Date: 11/19/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class ReverseLinkedList {
  public static void main(String args[]) {
    Node<Integer> list = new Node<Integer>(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);

//    System.out.println(reverseIterative(list).toString());
    System.out.println(reverseRecursive(list).toString());
  }

  //iteratively
  static Node<Integer> reverseIterative(Node<Integer> root) {
    if (root == null || root.next == null) {
      return root;
    }

    Node<Integer> original = root.next;
    Node<Integer> reversed = root;
    reversed.next = null;

    while (original != null) {
      Node<Integer> temp = original;
      original = original.next; //study this!

      temp.next = reversed;
      reversed = temp;
    }
    return reversed;
  }

  //recursively
  static Node<Integer> reverseRecursive(Node<Integer> head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node<Integer> reverse = reverseRecursive(head.next);

    head.next.next = head;
    head.next = null;

    return reverse;
  }
}
