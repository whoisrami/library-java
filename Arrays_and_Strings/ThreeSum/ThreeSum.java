package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Alex Yang
 * Date: 11/23/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Solution:
 * - N/A
 */
public class ThreeSum {
  public static void main(String args[]) {
    int[] vals = new int[]{-1, 0, 1, 2, -1, -4};
    Set<ArrayList<Integer>> results = threeSum(vals);

    for (ArrayList<Integer> list : results) {
      for (int i : list) {
        System.out.print(i);
      }
      System.out.println();
    }
  }

  //TODO: 4sum has another inner loop
  static Set<ArrayList<Integer>> threeSum(int[] num) {
    Arrays.sort(num);

    Set<ArrayList<Integer>> triplets = new HashSet<>();
    for (int i = 0; i < num.length; i++) {
      int j = i; //i is start
      int k = num.length - 1; //k is end

      while (j < k) {
        int twoSum = num[i] + num[j];
        if (twoSum + num[k] < 0) {
          j++;
        } else if (twoSum + num[k] > 0) {
          k--;
        } else {
          ArrayList<Integer> triplet = new ArrayList<>();
          triplet.add(num[i]);
          triplet.add(num[j]);
          triplet.add(num[k]);
          triplets.add(triplet);
          j++;
          k--;
        }
      }
    }

    return triplets;
  }
}
