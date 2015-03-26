package LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Alex Yang
 * Date: 3/24/15
 * Dependencies:
 * - N/A
 * Description:
 * - Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * Solution:
 * - N/A
 */
public class LRUCache {
 int capacity;
 int currCapacity;
 Map<Integer, CacheNode> map;
 CacheNode head = null;
 CacheNode tail = null;

 public LRUCache(int capacity) {
  this.capacity = capacity;
  this.currCapacity = 0;
  map = new HashMap<>();
 }

 public int get(int key) {
  if (!map.containsKey(key)) return -1;
  promote(map.get(key));
  return map.get(key).data;
 }

 public void set(int key, int value) {
  if (!map.containsKey(key)) {
    if (currCapacity >= capacity) {
      dump();
    }
    CacheNode n = new CacheNode(key, value);
    map.put(n.key, n);
    setHead(n);
  } else {
    map.get(key).data = value;
    promote(map.get(key));
  }
 }

  public void dump() {
    map.remove(tail.key);
    remove(tail);
  }

 public void promote(CacheNode n) {
  remove(n);
  setHead(n);
 }

 public void remove(CacheNode n) {
   if (n == head && n == tail) {
    head = null;
    tail = null;
  } else if (n == head) {
    head = head.next;
    head.prev = null;
  } else if (n == tail) {
    tail = tail.prev;
    tail.next = null;
  } else {
     n.prev.next = n.next;
     n.next.prev = n.prev;
  }

  currCapacity--;
 }

 public void setHead(CacheNode n) {
   n.prev = null;
   n.next = null;

   if (head == null) {
     head = n;
     tail = n;
   } else {
     n.next = head;
     head.prev = n;
     head = n;
   }

   //todo: check if tail is null here?

   currCapacity++;
 }
}

class CacheNode {
 CacheNode prev;
 CacheNode next;
  int key;
 int data;

 public CacheNode(int key, int data) {
  this.data = data;
   this.key = key;
 }
}
