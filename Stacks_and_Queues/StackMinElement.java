import java.util.Stack;

/**
 * Author: Alex Yang
 * Date: 9/8/2014
 * Dependencies:
 *  - N/A
 * Description:
 *  - How to design a stack with a function min that returns the min element.  Constraint is that push, pop, and min all have to operate in O(1) time.
 * Solution(s):
 *  - store min value in a separate stack
 *  - TODO: store a min attribute in every node in the stack, then just check the min attribute of the top node
 */

class StackMinElement extends Stack<Integer> {
  public static void main(String args[]) throws Exception {
    StackMinElement stack = new StackMinElement();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.min());
    System.out.println(stack.toString());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  Stack<Integer> minStack;

  public StackMinElement() {
    this.minStack = new Stack<Integer>();
  }

  void push(int value) {
    if (min() > value) {
      minStack.push(value);
    }
    super.push(value);
  }

  public Integer pop() {
    Integer popped = super.pop();
    if (popped == min()) minStack.pop();
    return popped;
  }

  int min() {
    return minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
  }
}