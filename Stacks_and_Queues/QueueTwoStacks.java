import java.util.Stack;

/**
 * Author: Alex Yang
 * Date: 9/12/2014
 * Dependencies:
 *  - N/A
 * Description:
 *  - Implementation of a Queue using two Stacks.
 * Solutions:
 *  - See Code.
 *  - TODO: refactor peek and dequeue functions into one function, follow DRY
 */

class QueueTwoStacks<T> {
  public static void main(String args[]) throws Exception {
    QueueTwoStacks<Integer> queue = new QueueTwoStacks<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println(queue.peek());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }

  Stack<T> stack1, stack2;

  public QueueTwoStacks() {
    stack1 = new Stack<T>();
    stack2 = new Stack<T>();
  }

  public int size() {
    return stack1.size() + stack2.size();
  }

  public void enqueue(T data) {
    stack1.push(data);
  }

  public T peek() {
    if (stack2.isEmpty()) { //only transfer elements over if stack2 is empty
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }

  //before dequeing transfer all elements from stack1 to stack2, but only if stack2 is empty
  public T dequeue() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }
}