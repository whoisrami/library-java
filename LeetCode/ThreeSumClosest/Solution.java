package ThreeSumClosest;

import java.util.Arrays;

/**
 * Author: Alex Yang
 * Date: 1/3/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
//    int[] arr = new int[]{-1, 2, 1, -4};
//    System.out.println(threeSumClosest(arr, 1));

    //should be 3
    int[] arr2 = new int[]{0,1,2};
    System.out.println(threeSumClosest(arr2, 0));

    //should be -2
    int[] arr3 = new int[]{-3, -2, -5, 3, -4};
    System.out.println(threeSumClosest(arr3, -1));
    // -5, -4, -3, -2, 3

    //should be 2
    int[] arr4 = new int[]{1, 1, 1, 0};
    System.out.println(threeSumClosest(arr4, -100));
  }

  public static int threeSumClosest(int[] num, int target) {
    Arrays.sort(num);
    int closestSum = num[0] + num[1] + num[num.length - 1];

    for (int i = 0; i < num.length; i++) {
      int start = i + 1;
      int end = num.length - 1;
      while (start < end) {
        int sum = num[i] + num[start] + num[end];
//        System.out.println("sum: " + sum);
        if (sum < target) {
          if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
            closestSum = sum;
//            System.out.println("closest: " + closestSum);
          }
          start++;
        } else if (sum > target) {
          if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
            closestSum = sum;
//            System.out.println("closest: " + closestSum);
          }
          end--;
        } else {
          //sum == target
          return sum;
        }
      }
    }

    return closestSum;
  }
}
