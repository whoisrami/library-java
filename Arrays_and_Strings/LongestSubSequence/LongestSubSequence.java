package LongestSubSequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Alex Yang
 * Date: 10/26/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given 2 arrays, return the longest subsequence between the two arrays.
 * - For example, arr1 = {1,2,3,2,3,2} arr2={2,2,3,3,4,5}, the largest common sub array is {2,2,3,3}.
 * Solution:
 * - N/A
 */
public class LongestSubSequence {
  public static void main(String args[]) {
    int[] arr1 = {1,2,3,2,3,2};
    int[] arr2 = {2,2,3,3,4,5};

    ArrayList<Integer> subArr = findSubSequence(arr1, arr2);
    for (int i : subArr) {
      System.out.print(i);
    }
  }

  static ArrayList<Integer> findSubSequence(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> arrList = new ArrayList<>();

    for(int i : arr1) {
      if (!map.containsKey(i)) {
        map.put(i, 1);
      } else {
        map.put(map.get(i), map.get(i) + 1);
      }
    }

    for (int j : arr2) {
      if (map.containsKey(j) && map.get(j) >= 1) {
        arrList.add(j);
        map.put(map.get(j), map.get(j) - 1);
      }
    }

    return arrList;
  }
}
