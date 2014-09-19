/**
 * Author: Alex Yang
 * Date: 9/8/2014
 * Dependencies:
 *  - Node.java (in linked lists section)
 * Description:
 *  - Simple Implementation of a Stack, on top of a linked list.
 * Solutions:
 *  - N/A
 */

class StackImpl<T> {
  public static void main(String args[]) throws Exception {
    StackImpl<Integer> stack = new StackImpl<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.toString());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  Node<T> top;

  void push(T data) {
    Node<T> n = new Node<T>(data);
    n.next = top;
    top = n;
  }

  T pop() {
    if (top != null) {
      T popped = top.data;
      top = top.next;
      return popped;
    }
    return null;
  }

  T peek() {
    return top.data;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node<T> pointer = top;
    while(pointer.next != null) {
      sb.append(pointer.data);
      sb.append(", ");
      pointer = pointer.next;
    }
    sb.append(pointer.data);
    return sb.toString();
  }
}