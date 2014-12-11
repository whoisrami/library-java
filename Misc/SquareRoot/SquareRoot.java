package SquareRoot;

/**
 * Author: Alex Yang
 * Date: 12/10/14
 * Dependencies:
 * - N/A
 * Description:
 * - Write an algorithm to compute the square root of a number that handles perfect and non-perfect squares.
 * Solution:
 * - N/A
 */
public class SquareRoot {
  public static void main(String args[]) {
    System.out.println(sqrt(4));
    System.out.println(sqrt(5));
    System.out.println(sqrt(4, 0, 4));
    System.out.println(sqrt(5, 0 ,5));
  }

  static long sqrt(int num) {
    long high = num;
    long low = 0;

    while (high - low > 1) {
      long mid = (high + low)/2;
      if (mid * mid <= num) {
        low = mid;
      } else {
        high = mid;
      }
    }

    return low;
  }

  static double sqrt(double n, double low, double high) {
    double errorMargin = 0.001;
    double mid = (low + high)/2;
    double diff = mid*mid - n;

    if (diff > errorMargin) { //if too big, num greater than n
      return sqrt(n, low, mid);
    } else if (-diff > errorMargin) { //if too small, num less than n
      return sqrt(n, mid, high);
    } else {
      return mid;
    }
  }
}
