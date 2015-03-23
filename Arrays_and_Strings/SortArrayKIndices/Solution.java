package SortArrayKIndices;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author: Alex Yang
 * Date: 3/16/15
 * Dependencies:
 * - N/A
 * Description:
 * - Sort an array where each item is at most k indices from its position in the sorted array. What's the run time?
 * Solution:
 * - use priority queue
 */
public class Solution {
  public static void main(String[] args) {
    int[] arr = {1, 4, 5, 2, 3, 6};
    List<Integer> results = sort (arr, 3);
    for (int i : results) {
      System.out.print(i);
    }
  }

  public static List<Integer> sort(int[] arr, int k) {
    List<Integer> results = new ArrayList<Integer>();

    PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer one, Integer two) {
        return one - two;
      }
    });

    //we have offer, peek, poll, and size()
    for (int i = 0; i < k; i++) {
      pq.offer(i);
    }

    //for k until the end, offer, then add new element to pq
    //at the end, offer the remaining left in pq

    return results;
  }
}
