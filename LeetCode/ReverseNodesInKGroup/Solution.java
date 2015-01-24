package ReverseNodesInKGroup;

/**
 * Author: Alex Yang
 * Date: 1/21/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    int k = 2;
    printList(reverseKGroup(head, k));
  }

  // idea is to keep head/tail pointers, when you reach kth node you go through and reverse from kth head to tail.
  // uses a dummy node in the beginning to be able to keep track of all nodes before and after
  public static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k < 2) return head;
    ListNode start = new ListNode(0);
    start.next = head;
    ListNode curr = start;

    while (curr != null) {
      ListNode h = curr;
      ListNode t = curr;
      for (int i = 1; i < k; i++) { //search for next kth node
        t = t.next;
        if (t == null || t.next == null) return start.next;
      }

      ListNode after = t.next.next;
      ListNode reversed = reverse(h.next, t.next.next);
      h.next = reversed; //update head to point to newly reversed list
      while (reversed.next != null) {
        reversed = reversed.next;
      }
      reversed.next = after; //update tail pointer
      curr = reversed;
    }

    return start.next;
  }

  //helper method to reverse a linked list
  public static ListNode reverse(ListNode head, ListNode after) {
    ListNode reversed = null;
    ListNode curr = head;
    while (curr != after) {

      ListNode tmp = curr.next;
      curr.next = reversed;
      reversed = curr;

      curr = tmp;
    }

    return reversed;
  }

  public static void printList(ListNode result) {
    System.out.println("printing list");
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }

  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
}
