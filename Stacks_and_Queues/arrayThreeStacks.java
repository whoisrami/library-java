import java.lang.Exception;

/**
 * Author: Alex Yang
 * Date: 9/7/2014
 * Dependencies:
 *   - None
 * Describe how you could use a single array to implement three stacks.
 * Solution 1: Fixed size stacks
 * TODO: Solution 2: Flexible stacks (grow and shrink as needed)
 */

class ArrayThreeStacks {
  public static void main(String args[]) throws Exception {
    ArrayThreeStacks stacks = new ArrayThreeStacks();
    stacks.push(0,1);
    stacks.push(1,2);
    stacks.push(2,3);
    stacks.push(1,4);
    System.out.println(stacks.pop(0));
    System.out.println(stacks.pop(1));
    System.out.println(stacks.pop(2));
    System.out.println(stacks.pop(1));
    System.out.println(stacks.pop(1));
  }

  int stackSize = 100;
  int[] buffer = new int [stackSize*3];
  int[] stackPointer = {-1, -1, -1};

  void push(int stackNum, int value) throws Exception {
    if (stackPointer[stackNum]+1 >= stackSize) {
      throw new Exception("Out of Space");
    }
    stackPointer[stackNum]++;
    buffer[top(stackNum)] = value;
  }

  int pop(int stackNum) throws Exception {
    if (stackPointer[stackNum] == -1) {
      throw new Exception("Cannot pop empty stack");
    }

    //grab top element, clear value at index, decrement pointer, return
    int result = buffer[top(stackNum)];
    buffer[top(stackNum)] = 0;
    stackPointer[stackNum]--;
    return result;
  }

  int peek(int stackNum) {
    return buffer[top(stackNum)];
  }

  boolean isEmpty(int stackNum) {
    if (stackPointer[stackNum] == -1) return false;
    return true;
  }

  //returns index of the top of the stack passed in
  int top(int stackNum) {
    int startIndex = stackNum * stackSize;
    return startIndex + stackPointer[stackNum];
  }
}