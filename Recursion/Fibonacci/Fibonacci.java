package Fibonacci;

/**
 * Author: Alex Yang
 * Date: 9/24/14
 * Dependencies:
 * - N/A
 * Description:
 * - Calculate the Nth Fibonacci number.
 * Solution:
 * - Recursion O(2^N)
 * - Dynamic Programming O(N)
 */
public class Fibonacci {
  public static void main (String args[]) {
    System.out.println(fib(6));

    int[] cache = new int[10];
    System.out.println(fibDP(6, cache));
  }

  static int fib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
  }

  static int fibDP(int n, int[] cache) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (cache[n] != 0) return cache[n];
    cache[n] = fibDP(n - 1, cache) + fibDP(n - 2, cache);
    return cache[n];
  }
}
