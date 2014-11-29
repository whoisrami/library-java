package MissingNumbers;

/**
 * Author: Alex Yang
 * Date: 11/23/14
 * Dependencies:
 * - N/A
 * Description:
 * - Find two missing numbers from 1 to N
 * Solution:
 * - N/A
 */
public class MissingTwo {
  public static void main(String args[]) {
    int[] arr = new int[]{1,2,3,4,6,7,9,10}; //missing 8,5
    int[] missing = find(arr);
    for (int i : missing) {
      System.out.println(i);
    }
  }

  //TODO: use algorithm found here http://stackoverflow.com/questions/3492302/easy-interview-question-got-harder-given-numbers-1-100-find-the-missing-numbe
  static int[] find(int[] arr) {
    return null;
  }
}
