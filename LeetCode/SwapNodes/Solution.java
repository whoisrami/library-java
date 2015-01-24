package SwapNodes;

/**
 * Author: Alex Yang
 * Date: 1/19/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a linked list, swap every two adjacent nodes and return its head.
 * <p/>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p/>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    ListNode result = swapPairs(head);

    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }

  public static ListNode swapPairs(ListNode head) {
    ListNode start = new ListNode(0);
    if (head == null || head.next == null) return head;

    ListNode slow = head;
    ListNode fast = head.next;
    ListNode n = start;

    while (fast != null) {
      ListNode tmp = fast.next;
      n.next = fast;
      n.next.next = slow;
      n = n.next.next;
      n.next = null;

      if (tmp == null) {
        break;
      } else if (tmp.next == null) {
        //if no last node to swap, leave last node unswapped and return
        n.next = tmp;
        break;
      }

      slow = tmp;
      fast = tmp.next;
    }

    return start.next;
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