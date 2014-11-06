package LongestContiguousSum;

/**
 * Author: Alex Yang
 * Date: 11/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 * Solution:
 * - N/A
 */
public class LongestContiguousSum {
  public static void main(String args[]) {
    int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println(findSum(arr));
  }

  static int findSum(int[] arr) {
    int max_so_far = 0;
    int max_ending_here = 0;

    for (int i : arr) {
      max_ending_here = max_ending_here + i;
      if (max_ending_here < 0) {
        max_ending_here = 0;
      }

      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
      }
    }

    return max_so_far;
  }
}
