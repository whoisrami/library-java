/**
 * Author: Alex Yang
 * Date: 9/2/2014
 * Dependencies:
 *   - linkedListGeneric.java
 *   - Node.java
 * Given linked list, detect if it is a palindrome.
 * Two solutions,
 * iterative - assuming we do not know the size of the list
 * recursive - assuming we know the size of the list
 * if we do have the size, a simple for loop iterating through the first half of the list, reversing then comparing would suffice.
 */
import java.util.Stack;

class linkedListPalindrome<T> extends linkedListGeneric<T> {
  public static void main (String args[]) {
    linkedListPalindrome<Integer> list = new linkedListPalindrome<Integer>();
    list.append(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);
    list.append(4);
    list.append(3);
    list.append(2);
    list.append(1);
    System.out.println(list.toString());
    System.out.println(isPalindromeIterative(list.root));
    System.out.println(isPalindrome(list.root));
    System.out.println(list.root.getSize());
  }

  static boolean isPalindromeIterative (Node<Integer> head) {
    if (head == null) return false;

    Stack<Integer> frontHalf = new Stack<Integer>();
    Node<Integer> slow = head;
    Node<Integer> fast = head;

    //iterate slow through first half of list
    while (fast != null && fast.next != null) {
      System.out.println("slow: " + slow.data + " fast: " + fast.data);
      frontHalf.push(slow.data);
      slow = slow.next;
      fast = fast.next.next;
    }

    //we want to skip the middle element if odd, its odd if fast is not null
    //if there is an even number of elements you will always go one past the last element, because you are incrementing by 2 starting from 1
    if (fast != null) {
      slow = slow.next;
    }

    while (slow != null) {
      int top = frontHalf.pop();
      if (slow.data != top) return false;
      slow = slow.next;
    }

    return true;
  }

  //TODO: review this recursive solution again later
  static Result isPalindromeRecursive (Node<Integer> head, int length) {
    if (head == null || length == 0) {
      return new Result(null, true);
    } else if (length == 1) {
      return new Result(head.next, true);
    } else if (length == 2) {
      return new Result(head.next.next, head.data == head.next.data);
    }

    Result res = isPalindromeRecursive(head.next, length - 2);
    if (!res.result || res.node == null) {
      return res;
    } else {
      res.result = head.data == res.node.data;
      res.node = res.node.next;
      return res;
    }
  }

  static boolean isPalindrome (Node<Integer> head) {
    Result p = isPalindromeRecursive(head, head.getSize());
    return p.result;
  }
}

class Result {
  public Node<Integer> node;
  public boolean result;

  public Result(Node<Integer> node, boolean result) {
    this.node = node;
    this.result = result;
  }
}