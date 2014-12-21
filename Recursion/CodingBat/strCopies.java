package CodingBat;

/**
 * Author: Alex Yang
 * Date: 12/20/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.

 strCopies("catcowcat", "cat", 2) → true
 strCopies("catcowcat", "cow", 2) → false
 strCopies("catcowcat", "cow", 1) → true
 * Solution:
 * - N/A
 */
public class strCopies {
  public static void main(String args[]) {
    System.out.println(strCopies("catcowcat", "cat", 2));
    System.out.println(strCopies("catcowcat", "cow", 2));
    System.out.println(strCopies("catcowcat", "cow", 1));
  }

  static boolean strCopies(String str, String sub, int n) {
    if (n == 0) return true;
    if (str.length() < sub.length()) return false;

    int i = 0;
    while (str.charAt(i) == sub.charAt(i)) {
      if (i == sub.length() - 1) {
        n--;
        return strCopies(str.substring(1), sub, n);
      }
      if (i == str.length() - 1) break;
      i++;
    }

    return strCopies(str.substring(1), sub, n);
  }
}
