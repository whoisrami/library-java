package DivideTwoIntegers;

/**
 * Author: Alex Yang
 * Date: 2/13/15
 * Dependencies:
 * - N/A
 * Description:
 * - Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 * Solution:
 * - N/A
 */
public class Solution {
  public int divide(int dividend, int divisor) {
    return divide(dividend, divisor, dividend);
  }

  //dividend = numerator, divisor = denominator
  //use ax = b property of division
  public int divide(int dividend, int divisor, int tmp) {
    if (tmp > dividend) return Integer.MAX_VALUE;

    tmp >>= 2;
    int mid = tmp * divisor;
    if (mid == dividend) {
      return mid;
    } else if (mid < dividend) {
      return divide(dividend, divisor, tmp + 1);
    } else {
      return divide(dividend, divisor, tmp - 1);
    }
  }
}
