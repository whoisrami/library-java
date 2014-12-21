package Multiples35;

/**
 * Author: Alex Yang
 * Date: 12/21/14
 * Dependencies:
 * - N/A
 * Description:
 * - If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

 Find the sum of all the multiples of 3 or 5 below 1000.
 * Solution:
 * - N/A
 */
public class Multiples35 {
  public static void main(String args[]) {
    System.out.println(sum(1000));
  }

  static int sum(int n) {
    int total = 0;
    for (int i = 1; i < n; i++) {
      if (i % 3 == 0) {
        System.out.println(i);
        total += i;
      } else if (i % 5 == 0) {
        System.out.println(i);
        total += i;
      }

    }

    return total;
  }
}
