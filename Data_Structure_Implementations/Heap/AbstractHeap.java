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
public abstract class AbstractHeap implements Heap {
  Node[] heapArray;
  private int maxSize;
  private int currentIndex;

  protected AbstractHeap() {}

  public boolean isEmpty() {
    return getCurrentIndex() == 0;
  }

  public abstract boolean insert(int key);
  public abstract Node remove();
  protected abstract Node[] getHeapArray();
  protected abstract int getCurrentIndex();

  public void displayHeap() {

  }

  public Node peek() {
    this.heapArray = getHeapArray();
    if (this.heapArray.length > 0) {
      return this.heapArray[0];
    }

    return null;
  }
}
