package CodingBat;

/**
 * Author: Alex Yang
 * Date: 11/17/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class array11 {
  public static void main(String args[]) {
    System.out.println(array11(new int[]{1, 2, 11}, 0));
    System.out.println(array11(new int[]{11, 11}, 0));
    System.out.println(array11(new int[]{1, 2, 3, 4}, 0));
  }

  static int array11(int[] nums, int index) {
    if (index >= nums.length) return 0;
    if (nums[index] == 11) {
      return 1 + array11(nums, index + 1);
    } else {
      return array11(nums, index + 1);
    }
  }
}
