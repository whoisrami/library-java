package SortLinkedList;

/**
 * Author: Alex Yang
 * Date: 3/24/15
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    ListNode head = new ListNode(4);
    head.next = new ListNode(3);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(1);

    ListNode result = sortList(head);
    while (result != null) {
      System.out.print(result.val);
      result = result.next;
    }
  }

  public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode slow = head;
    ListNode fast = head;
    //divide list into two halves
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    //call sortList on both halves to split the list further
    ListNode tmp = head;
    while (tmp.next != slow) {
      tmp = tmp.next;
    }
    tmp.next = null;

    ListNode left = sortList(head);
    ListNode right = sortList(slow);

    //merge both halves
    return merge(left, right);
  }

  //merges two linked lists, assuming each param list is sorted
  static ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode tmp = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        dummy.next = l1;
        l1 = l1.next;
      } else {
        dummy.next = l2;
        l2 = l2.next;
      }
      dummy = dummy.next;
    }

    while (l1 != null) {
      dummy.next = l1;
      l1 = l1.next;
      dummy = dummy.next;
    }

    while (l2 != null) {
      dummy.next = l2;
      l2 = l2.next;
      dummy = dummy.next;
    }

    return tmp.next;
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
