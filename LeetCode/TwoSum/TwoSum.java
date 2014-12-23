package TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Alex Yang
 * Date: 12/23/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: 1, 2
 * Solution:
 * - N/A
 */
public class TwoSum {
  public static void main(String[] args) {
    int[] numbers = {2,7,11,15};
    int target = 9;

    twoSum(numbers, target);
  }

  static int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      if (map.get(numbers[i]) != null) {
        result[0] = map.get(numbers[i]);
        result[1] = i + 1;
      }
      map.put(target - numbers[i], i + 1);
    }

    return result;
  }
}
