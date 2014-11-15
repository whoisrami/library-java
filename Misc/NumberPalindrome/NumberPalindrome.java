package NumberPalindrome;

/**
 * Author: Alex Yang
 * Date: 11/7/14
 * Dependencies:
 * - N/A
 * Description:
 * - Check if a given number is a palindrome without using extra space.  Number must be positive.
 * Solution:
 * - N/A
 */
public class NumberPalindrome {
  public static void main(String args[]) {
    System.out.println(isPalindrome(123));
    System.out.println(isPalindrome(12321));
  }

  //do by reverse
  static boolean isPalindromeReverse(int i) {
    if (i < 0) return false;
    int num = i;
    int rev = 0;
    while (num > 0) {
      int remainder = num%10;
      rev *= 10;
      rev += remainder;
      num /= 10; //slice off last number
    }
    if (rev == i) {
      return true;
    }
    return false;
  }

  //do by checking both ends
  static boolean isPalindrome(int i) {
    if (i < 0) return false;

    int div = 1;
    while (i/div >= 10) {
      div *= 10;
    }

    while (i != 0) {
      int front = i/div;
      int back = i%10; //grab last guy
      if (front != back) return false;
      i = (i % div) / 10;
      div /= 100;
    }

    return true;
  }
}
