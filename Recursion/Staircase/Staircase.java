package Staircase;

/**
 * Author: Alex Yang
 * Date: 9/22/14
 * Dependencies:
 * - N/A
 * Description:
 * - A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.  Implement a method to count how many possible ways the child can run up the stairs.
 * Solution:
 * - Recursive O(3^N)
 * - Dynamic Programming O(N)
 */
public class Staircase {
  public static void main(String args[]) {
    System.out.println(countWays(4));

    int[] cache = new int[37]; //otherwise will overflow
    for (int i = 0; i < cache.length; i++) {
      cache[i] = -1;
    }

    System.out.println(countWaysDP(4, cache));
  }

  static int countWays(int n) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
  }

  static int countWaysDP(int n, int[] map) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    if (map[n] != -1) {
      return map[n];
    } else {
      map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
      return map[n];
    }
  }
}
