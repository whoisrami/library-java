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
public interface Heap {
  boolean isEmpty();
  boolean insert(int key);
  Node remove();
  Node peek();
  void displayHeap();
}
