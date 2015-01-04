package PalindromeNumber;

/**
 * Author: Alex Yang
 * Date: 12/30/14
 * Dependencies:
 * - N/A
 * Description:
 * - Determine whether an integer is a palindrome. Do this without extra space.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {

    System.out.println(isPalindrome(101));
    System.out.println(isPalindrome(1001));
    System.out.println(isPalindrome(-1001));
  }

  public static boolean isPalindrome(int x) {
    if (x < 0) return false;

    int div = 1;
    while (x/div >= 10) {
      div *= 10;
    }

    while (x != 0) {
      int front = x/div;
      int back = x%10; //grab last guy
      if (front != back) return false;
      x = (x % div) / 10;
      div /= 100;
    }

    return true;
  }


}
