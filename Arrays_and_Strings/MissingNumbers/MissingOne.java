package MissingNumbers;

/**
 * Author: Alex Yang
 * Date: 11/23/14
 * Dependencies:
 * - N/A
 * Description:
 * - Find one missing number from 1 to N
 * Solution:
 * - N/A
 */
public class MissingOne {
  public static void main(String args[]) {
    int[] arr = new int[]{1,2,3,4,5,6,7,9,10}; //missing 8
    System.out.println(find(arr));
  }

  static int find(int[] arr) {
    int n = arr[arr.length - 1];
    int expectedTotal = (n*(n+1))/2;

    int sum = 0;
    for (int i : arr) {
      sum += i;
    }

    return expectedTotal - sum;
  }
}
