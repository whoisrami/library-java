package ArrayHopper;

/**
 * Author: Alex Yang
 * Date: 3/23/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 * Solution:
 * - optimal sol: work your way from backwards
 * - other sol: you can check for 0's and work your way backwards from each one making sure its possible to jump to it, if you find a jump then break and continue, keep checking until you hit 0 and return false if you cant jump
 */
public class Solution {
  public boolean canJump(int[] A) {
    if (A.length < 1) return false;

    int last = A.length - 1;
    for (int i = A.length - 1; i >= 0; i--) {
      if (i + A[i] >= last) {
        last = i;
      }
    }

    return last == 0;
  }
}
