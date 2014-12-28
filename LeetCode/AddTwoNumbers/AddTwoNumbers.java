package AddTwoNumbers;

/**
 * Author: Alex Yang
 * Date: 12/27/14
 * Dependencies:
 * - N/A
 * Description:
 * - You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 * Solution:
 * - N/A
 */
public class AddTwoNumbers {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode tmp1 = new ListNode(4);
    ListNode tmp2 = new ListNode(3);

    l1.next = tmp1;
    l1.next.next = tmp2;
    l1.next.next.next = new ListNode(7);

    ListNode l2 = new ListNode(5);
    ListNode tmp3 = new ListNode(6);
    ListNode tmp4 = new ListNode(4);

    l2.next = tmp3;
    l2.next.next = tmp4;

    ListNode result = addTwoNumbers(l1, l2);
    while (result != null) {
      System.out.print(result.val);
      result = result.next;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode sum = null;
    ListNode head = null;
    while (l1 != null && l2 != null) {
      int num = l1.val + l2.val + carry;

      if (num >= 10) {
        carry = 1;
        num = num%10;
      } else {
        carry = 0;
      }

      if (sum == null) {
        sum = new ListNode(num);
        head = sum;
      } else {
        sum.next = new ListNode(num);
        sum = sum.next;
      }

      l1 = l1.next;
      l2 = l2.next;
    }

    while (l1 != null) {
      if (carry == 0 && sum != null) {
        sum.next = l1;
      }

      int num = l1.val + carry;

      if (num >= 10) {
        carry = 1;
        num = num%10;
      } else {
        carry = 0;
      }

      if (sum == null) {
        sum = new ListNode(num);
        head = sum;
      } else {
        sum.next = new ListNode(num);
        sum = sum.next;
      }

      l1 = l1.next;
    }

    while (l2 != null) {

      if (carry == 0 && sum != null) {
        sum.next = l2;
      }

      int num = l2.val + carry;

      if (num >= 10) {
        carry = 1;
        num = num%10;
      } else {
        carry = 0;
      }

      if (sum == null) {
        sum = new ListNode(num);
        head = sum;
      } else {
        sum.next = new ListNode(num);
        sum = sum.next;
      }

      l2 = l2.next;
    }

    if (carry > 0) {
      sum.next = new ListNode(1);
    }

    return head;
  }
}
