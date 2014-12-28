package CodingBat;

/**
 * Author: Alex Yang
 * Date: 12/25/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index, such that the group sums to the given target? However, with the additional constraint that all 6's must be chosen. (No loops needed.)

 groupSum6(0, {5, 6, 2}, 8) → true
 groupSum6(0, {5, 6, 2}, 9) → false
 groupSum6(0, {5, 6, 2}, 7) → false
 * Solution:
 * - N/A
 */
public class groupSum6 {
  public static void main(String[] args) {
    System.out.println(groupSum(0, new int[]{5,6,2}, 8));
    System.out.println(groupSum(0, new int[]{5,6,2}, 9));
    System.out.println(groupSum(0, new int[]{5,6,2}, 7));
  }

  static boolean groupSum(int start, int[] nums, int target) {

    if (start >= nums.length) return target == 0;

    if (nums[start] == 6) {
      //6 must be inside
      return groupSum(start + 1, nums, target - nums[start]);
    }

    boolean in = groupSum(start + 1, nums, target - nums[start]);
    if (in) return true;

    boolean out = groupSum(start + 1, nums, target);
    if (out) return true;

    return false;
  }
}
