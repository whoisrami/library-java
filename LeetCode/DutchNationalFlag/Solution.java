package DutchNationalFlag;

/**
 * Author: Alex Yang
 * Date: 3/22/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 * Solution:
 * - http://en.wikipedia.org/wiki/Dutch_national_flag_problem
 */
public class Solution {
  public void sortColors(int[] A) {
    if (A == null || A.length <= 1) return;

    int top = A.length - 1;
    int middle = 0;
    int bottom = 0;

    while (middle <= top) {
      if (A[middle] == 0) {
        //swap middle with "top" of bottoms
        //everything before bottom marker is 0
        int tmp = A[middle];
        A[middle] = A[bottom];
        A[bottom] = tmp;

        middle++;
        bottom++;
      } else if (A[middle] == 1) {
        //if middle, just continue
        middle++;
      } else {
        //if top, swap middle with top of "top"
        //everything after top marker is 2
        int tmp = A[middle];
        A[middle] = A[top];
        A[top] = tmp;

        top--;

      }
    }
  }
}
