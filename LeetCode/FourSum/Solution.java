package FourSum;

import java.util.*;

/**
 * Author: Alex Yang
 * Date: 1/8/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    int target = 0;
    int[] s = new int[]{1, 0, -1, 0, -2, 2};

    List<List<Integer>> results = fourSum(s, target);

    for (List<Integer> l : results) {
      for (int i : l) {
        System.out.print(i);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public static List<List<Integer>> fourSum(int[] num, int target) {
    Arrays.sort(num);
    Set<List<Integer>> results = new HashSet<>();

    for (int i = 0; i < num.length; i++) {
      for (int j = i + 1; j < num.length; j++) {
        int start = j + 1;
        int end = num.length - 1;

        while (start < end) {
          int sum = num[i] + num[j] + num[start] + num[end];

          if (sum == target) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(num[i]);
            tmp.add(num[j]);
            tmp.add(num[start]);
            tmp.add(num[end]);
            results.add(tmp);
            start++;
          } else if (sum < target) {
            start++;
          } else {
            end--;
          }
        }
      }
    }

    List<List<Integer>> resultsAsList = new ArrayList<>();
    resultsAsList.addAll(results);

    return resultsAsList;
  }
}
