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
public class Test {
  public static void main(String args[]) {
    MaxHeap heap = new MaxHeap(6);
    heap.insert(1);
    heap.insert(2);
    heap.insert(4);
    heap.insert(6);
    heap.insert(9);
    heap.insert(4);
    heap.insert(123);

    int heapSize = heap.getCurrentIndex();
    for (int i = 0; i < heapSize; i++) {
      heap.remove();
    }
  }
}
