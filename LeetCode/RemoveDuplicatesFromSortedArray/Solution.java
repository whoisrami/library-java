package RemoveDuplicatesFromSortedArray;

/**
 * Author: Alex Yang
 * Date: 1/13/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    int[] a = new int[]{1,1,2};
    System.out.println(removeDuplicates(a));
  }

  public static int removeDuplicates(int[] A) {
    if (A.length == 0) return 0;

    int slow = 0;
    int fast = 0;
    int curr = Integer.MIN_VALUE;
    int len = 0;

    while (fast < A.length) {
      if (A[fast] != curr) {
        curr = A[fast];
        A[slow] = A[fast];
        slow++;
        len++;
      }

      fast++;
    }

    return len;
  }
}
