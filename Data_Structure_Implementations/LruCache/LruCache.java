package LruCache;

import java.util.HashMap;

/**
 * Author: Alex Yang
 * Date: 11/7/14
 * Dependencies:
 * - N/A
 * Description:
 * - Implementation of a LRU cache exposing a get and set api
 * Solution:
 * - N/A
 */
public class LruCache {
  public static void main(String args[]) {
    LruCache cache = new LruCache(3);
    cache.set(3,3);
    cache.set(2,2);
    cache.set(1,1);
    System.out.println(cache.get(3));  //should return 3
    cache.set(4,4);
    System.out.println(cache.get(3));  //should return 3
    System.out.println(cache.get(2));  //should return -1
    System.out.println(cache.get(4));  //should return 4;
    cache.set(5,5);
    System.out.println(cache.get(1));  //should return 1;
    System.out.println(cache.get(5));  //should return 5;
  }

  private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<>();
  private DoubleLinkedListNode head;
  private DoubleLinkedListNode end;

  private int maxCapacity;
  private int currentCapacity = 0;

  public LruCache(int capacity) {
    this.maxCapacity = capacity;
  }

  //Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1
  public int get(int key) {
    if (map.containsKey(key)) {
      //move node with key to head
      DoubleLinkedListNode n = map.get(key);
      promote(n);
      return n.data;
    }
    return -1;
  }

  //Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
  public void set(int key, int value) {
    if (map.containsKey(key)) {
      DoubleLinkedListNode n = map.get(key);
      n.data = value;
      promote(n);
      return;
    }

    //key not already in map
    DoubleLinkedListNode n = new DoubleLinkedListNode(key, value);
    if (currentCapacity < maxCapacity) {
      map.put(key, n);
      setHead(n);  //no need to promote here..
      currentCapacity++;
    } else {
      //need to remove LRU node from cache
      dump();
      map.put(key, n);
      setHead(n);
      end = end.prev;
      if (end != null) {
        end.next = null;
      }
    }
  }

  private void promote(DoubleLinkedListNode n) {
    remove(n);
    setHead(n);
  }

  private void dump() {
    map.remove(this.end.key);
    remove(this.end);
    //need to remove from map too!
  }

  private void setHead(DoubleLinkedListNode n) {
    n.next = null;
    n.prev = null;

    if (this.head == null) { //if first element
      this.head = n;
      this.end = n;
      return;
    }

    //existing elements already in list
    this.head.prev = n;
    n.next = this.head;
    this.head = n;

    if (this.end == null) {
      this.end = n;
    }
  }

  private void remove(DoubleLinkedListNode n) {
    if (this.head == null || n == null) return;

    //if only one item
    if (this.head == this.end) {
      this.head = null;
      this.end = null;
      return;
    }

    //if node is head
    if (n == this.head) {
      this.head.next.prev = null;
      this.head = this.head.next;
      return;
    }

    //if node is end
    if (n == this.end) {
      this.end.prev.next = null;
      this.end = this.end.prev;
      return;
    }

    //remove node in the middle
    n.prev.next = n.next;
    n.next.prev = n.prev;
  }
}