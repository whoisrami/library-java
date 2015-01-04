package ThreeSum;

import java.util.*;

/**
 * Author: Alex Yang
 * Date: 1/3/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> results = threeSum(arr);

    for (List<Integer> l : results) {
      for (int i : l) {
        System.out.print(i);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public static List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);

    Set<List<Integer>> results = new HashSet<>();

    for (int i = 0; i < num.length; i++) {
      int start = i + 1;
      int end = num.length - 1;

      while (start < end) {
        int sum = num[i] + num[start] + num[end];

        if (sum == 0) {
          List<Integer> tmp = new ArrayList<>();
          tmp.add(num[i]);
          tmp.add(num[start]);
          tmp.add(num[end]);
          results.add(tmp);
          start++;
        } else if (sum < 0) {
          start++;
        } else {
          end--;
        }
      }
    }

    List<List<Integer>> resultsAsList = new ArrayList<>();
    resultsAsList.addAll(results);

    return resultsAsList;
  }
}
