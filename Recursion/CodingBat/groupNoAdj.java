package CodingBat;

/**
 * Author: Alex Yang
 * Date: 12/25/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with this additional constraint: If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen. (No loops needed.)

 groupNoAdj(0, {2, 5, 10, 4}, 12) → true
 groupNoAdj(0, {2, 5, 10, 4}, 14) → false
 groupNoAdj(0, {2, 5, 10, 4}, 7) → false
 * Solution:
 * - N/A
 */
public class groupNoAdj {
  public static void main(String[] args) {
    System.out.println(groupNoAdj(0, new int[]{2,5,10,4}, 12));
    System.out.println(groupNoAdj(0, new int[]{2,5,10,4}, 14));
    System.out.println(groupNoAdj(0, new int[]{2,5,10,4}, 7));
  }

  static boolean groupNoAdj(int start, int[] nums, int target) {
    if (start >= nums.length) return target == 0;

    if (start == nums.length - 1) {
      return groupNoAdj(start + 1, nums, target - nums[start]) ||
              groupNoAdj(start + 1, nums, target);
    }

    boolean in = groupNoAdj(start + 2, nums, target - nums[start]);
    if (in) return true;

    boolean out = groupNoAdj(start + 1, nums, target);
    if (out) return true;

    return false;
  }
}
