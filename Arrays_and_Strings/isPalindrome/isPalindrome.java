package isPalindrome;

/**
 * Author: Alex Yang
 * Date: 11/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a string, check if it is a palindrome.s
 * Solution:
 * - N/A
 */
public class isPalindrome {
  public static void main(String args[]) {
    System.out.println(isPalindrome("racecar"));
  }

  static boolean isPalindrome(String s) {
    for (int i = 0; i < s.length()/2; i++) {
      System.out.println(s.charAt(i) + " and " + s.charAt(s.length() - i - 1));
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
