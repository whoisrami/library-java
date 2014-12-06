package isPalindrome;

/**
 * Author: Alex Yang
 * Date: 12/2/14
 * Dependencies:
 * - N/A
 * Description:
 * - Check if a string (including caps, whitespace, punctuation) is apalindrome without doing any preprocessing.
 * Solution:
 * - N/A
 */
public class isPalindromeDirty {
  public static void main(String args[]) {
    System.out.println(isPalindrome("Ab* a"));
    System.out.println(isPalindrome("Ab* Ba"));
    System.out.println(isPalindrome("Ab* c Ba"));

  }

  static boolean isPalindrome(String str) {
    int startPtr = 0;
    int endPtr = str.length() - 1;

    int gap = 0;
    if (str.length() %2 == 0) {
      gap = 1;
    }

    while (endPtr - startPtr >= gap) {
      System.out.print(str.charAt(startPtr) + " and " + str.charAt(endPtr));
      System.out.println();

      if (!Character.isLetter(str.charAt(startPtr))) {
        startPtr++;
      } else if (!Character.isLetter(str.charAt(endPtr))) {
        endPtr--;
      } else if (Character.toLowerCase(str.charAt(startPtr)) != Character.toLowerCase(str.charAt(endPtr))) {
        return false;
      }

      startPtr++;
      endPtr--;
    }

    return true;
  }
}
