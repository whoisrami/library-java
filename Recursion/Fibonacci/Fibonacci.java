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
    System.out.println(fib(7));

    int[] cache = new int[10];
    System.out.println(fibDP(7, cache));

    System.out.println(fibIterative(7));
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

  static int fibIterative(int n) {
    int f1 = 1;
    int f2 = 0;
    int fn = 0;
    for (int i = 1; i < n; i++) { //one less loop since we initialize it at the first and second fib number already
      fn = f1 + f2;
      f2 = f1;
      f1 = fn;
    }

    return fn;
  }
}
