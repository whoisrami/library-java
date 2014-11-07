package LruCache;

/**
 * Author: Alex Yang
 * Date: 11/7/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class DoubleLinkedListNode {
  public int data;
  public int key;

  public DoubleLinkedListNode prev;
  public DoubleLinkedListNode next;

  public DoubleLinkedListNode(int key, int data) {
    this.data = data;
    this.key = key;
  }
}
