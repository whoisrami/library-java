package ReverseInteger;

/**
 * Author: Alex Yang
 * Date: 12/26/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Have you thought about this?
 Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * Solution:
 * - N/A
 */
public class ReverseInteger {
  public static void main(String[] args) {
    System.out.println(reverse(123));
    System.out.println(reverse(-123));
  }

  static int reverse(int x) {
    int reverse = 0;
    boolean negative = false;

    if (x < 0) {
      negative = true;
      x *= -1; //temp flip to positive
    }

    while (x > 0) {
      int right = x%10;

      int tmp = reverse * 10 + right;
      if ((tmp - right)/10 != reverse) return 0; //checks for overflow

      reverse = tmp;
      x = x/10;
    }

    if (negative) reverse *= -1;
    return reverse;
  }
}
