import java.util.ArrayList;

/**
 * Author: Alex Yang
 * Date: 9/9/2014
 * Dependencies:
 *  - Node.java
 * Description:
 *  - Implement a stack data structure which will start a new stack when the
 *  previous stack exceeds a certain threshold.  However, push and pop should
 *  function as if there is only one stack.
 * Solution(s):
 *  - Recursive leftshift to end to implement PopAt.  Essentially uses a
 *  rollover system, to shift elements of each of the stacks, by removing
 *  the bottom element and pushing it to the previous stack, while re-setting
 *  the bottom elements.
 *  - Implemented separate StackLimited class with helpful class methods.
 */

class SetOfStacks {
  public static void main(String args[]) throws Exception {
    SetOfStacks stack = new SetOfStacks(1);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.popAt(1));
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  ArrayList<StackLimited> stacks = new ArrayList<StackLimited>();
  public int capacity;

  public SetOfStacks(int capacity) {
    this.capacity = capacity;
  }

  public StackLimited getLastStack() {
    if (stacks.size() == 0) return null;
    return stacks.get(stacks.size() - 1);
  }

  public void push(int value) {
    StackLimited last = this.getLastStack();
    if (last != null && !last.isFull()) {
      last.push(value);
    } else {
      StackLimited stack = new StackLimited(capacity);
      stack.push(value);
      stacks.add(stack);
    }
  }

  public int pop() {
    StackLimited last = this.getLastStack();
    int value = last.pop();
    if (last.size == 0) stacks.remove(stacks.size() - 1);
    return value;
  }

  public boolean isEmpty() {
    StackLimited last = getLastStack();
    return last == null || last.isEmpty();
  }

  public int popAt(int stackIndex) {
    return leftShift(stackIndex, true);
  }

  public int leftShift(int index, boolean removeTop) {
    StackLimited stack = stacks.get(index);
    int removed_item;

    if (removeTop) {
      removed_item = stack.pop();
    } else {
      removed_item = stack.removeBottom();
    }

    if (stack.isEmpty()) {
      stacks.remove(index);
    } else if (stacks.size() > index + 1) {
      int value = leftShift(index + 1, false);
      stack.push(value);
    }
    return removed_item;
  }
}

class StackLimited {
  private int capacity;
  public Node<Integer> top, bottom;
  public int size = 0;

  public StackLimited (int capacity) {
    this.capacity = capacity;
  }

  public boolean isFull() {
    return this.size == this.capacity;
  }

  public boolean push(int value) {
    if (size >= capacity) return false;
    size++;
    Node<Integer> n = new Node<Integer>(value);
    if (size == 1) bottom = n;
    join(n, top);
    top = n;
    return true;
  }

  public int pop() {
    Node<Integer> t = top;
    top = top.prev;
    size--;
    return t.data;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int removeBottom() {
    Node<Integer> b = bottom;
    bottom = bottom.next;
    if (bottom != null) bottom.prev = null;
    size--;
    return b.data;
  }

  public void join (Node<Integer> above, Node<Integer> below) {
    if (below != null) below.next = above;
    if (above != null) above.prev = below;
  }
}