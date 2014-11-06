package TwoNumberSubsetSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Alex Yang
 * Date: 11/3/14
 * Dependencies:
 * - N/A
 * Description:
 * -  write an algorithm to check if the sum of any two numbers in an array/list matches a given number
 * Solution:
 * - N/A
 */
public class TwoNumberSubsetSum {
  public static void main(String args[]) {
    int[] arr1 = {1,2,3,4,5};
    int sum = 7;

    findSum(arr1, sum);
  }

  static void findSum(int[] arr, int sum) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : arr) {
      if(!map.containsKey(i)) {
        map.put(i, 1);
      } else {
        map.put(i, map.get(i) + 1);
      }
    }

    for (int i : arr) {
      int complement = sum - i;
      if (map.containsKey(complement)) {
        System.out.println("[" + i + "," + complement + "]");
      }
    }
  }

  //TODO: alternatively, with no extra space allowed, we can sort the array and perform binary search to find the complement of each element
}
