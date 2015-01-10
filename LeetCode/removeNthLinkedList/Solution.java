package removeNthLinkedList;

/**
 * Author: Alex Yang
 * Date: 1/9/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 * Solution:
 * - N/A
 */



class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
       val = x;
       next = null;
   }
 }

public class Solution {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);

    head.next = two;
    head.next.next = three;
    head.next.next.next = four;
    head.next.next.next.next = five;

    int n = 4;

    ListNode result = removeNthFromEnd(head, n);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start = new ListNode(0);
    ListNode slow = start;
    ListNode fast = start;
    slow.next = head;

    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
      fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
  }
}