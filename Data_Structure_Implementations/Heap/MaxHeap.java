package Heap;

/**
 * Author: Alex Yang
 * Date: 11/15/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class MaxHeap extends AbstractHeap {
  private int maxSize;
  private Node[] heapArray;
  private int currentIndex;

  public MaxHeap(int maxSize) {
    this.currentIndex = 0;
    this.maxSize = maxSize;
    this.heapArray = new Node[maxSize];
  }

  public boolean insert(int key) {
    if (currentIndex == maxSize) {
      System.out.println("Cannot insert " + key + ".  Max size reached.");
      return false;
    }
    Node node = new Node(key);
    heapArray[currentIndex] = node; //set at "bottom"
    bubbleUp(currentIndex);
    currentIndex = currentIndex + 1;
    return true;
  }

  private void bubbleUp(int index) {
    int parentIndex = (index - 1)/2;
    Node bottom = heapArray[index];

    while (index > 0 && bottom.getData() > heapArray[parentIndex].getData()) {
      heapArray[index] = heapArray[parentIndex]; //move parent element down
      index = parentIndex; //update pointer to possible insertion point
      parentIndex = (parentIndex - 1)/2; //update parent Index pointer upwards
    }

    heapArray[index] = bottom;
  }

  public Node remove() {
    Node root = null;
    if (heapArray.length > 0) {
      root = heapArray[0];
      heapArray[0] = heapArray[currentIndex - 1]; //set top to last node in tree
      bubbleDown(0);
      currentIndex = currentIndex - 1;
    }

    System.out.println("Removing " + root.data);
    return root;
  }

  private void bubbleDown(int index) {
    int largerChildIndex;
    Node top = heapArray[0];

    while (index < currentIndex/2) { //while node has at least one child
      int leftChildIndex = 2 * index + 1;
      int rightChildIndex = leftChildIndex + 1;

      //find the larger of the two children
      if (rightChildIndex < currentIndex && heapArray[rightChildIndex].getData() > heapArray[leftChildIndex].getData()) {
        largerChildIndex = rightChildIndex;
      } else {
        largerChildIndex = leftChildIndex;
      }

      //if parent larger than larger child, then break
      if (top.getData() > heapArray[largerChildIndex].getData()) {
        break;
      }

      //shift larger child upwards
      heapArray[index] = heapArray[largerChildIndex];
      index = largerChildIndex;
    }

    heapArray[index] = top;
  }

  public int getCurrentIndex() {
    return currentIndex;
  }

  public Node[] getHeapArray() {
    return heapArray;
  }
}
