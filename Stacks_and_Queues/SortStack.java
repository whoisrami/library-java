import java.util.Stack;

/**
 * Author: Alex Yang
 * Date: 9/12/2014
 * Dependencies:
 *  - N/A
 * Description:
 *  - Sort a given stack in ascending order.
 *  - LIMITATION: can only use one additional stack.
 *  - LIMITATION: stack only supports push, pop, peek, and isEmpty
 * Solutions:
 *  - Insert all elements from stack 1 into stack 2 in order, by saving the
 *  value popped from stack 1 in a temp var, then popping all vals into stack 1,
 *  and moving them back to stack 2 after value inserted
 */

class SortStack {
  public static void main(String args[]) throws Exception {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(3);
    stack.push(2);
    stack = sortStack(stack);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  public static Stack<Integer> sortStack(Stack<Integer> stack) {
    Stack<Integer> stack2 = new Stack<>();

    while (!stack.isEmpty()) {
      int tmp = stack.pop();
      while (!stack2.isEmpty() && stack2.peek() > tmp) {
        stack.push(stack2.pop());
      }
      stack2.push(tmp);
    }
    return stack2;
  }
}