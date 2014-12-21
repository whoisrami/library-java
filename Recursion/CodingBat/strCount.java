package CodingBat;

/**
 * Author: Alex Yang
 * Date: 12/20/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping.

 strCount("catcowcat", "cat") → 2
 strCount("catcowcat", "cow") → 1
 strCount("catcowcat", "dog") → 0
 * Solution:
 * - N/A
 */
public class strCount {
  public static void main(String args[]) {
    System.out.println(strCount("catcowcat", "cat"));
    System.out.println(strCount("catcowcat", "cow"));
    System.out.println(strCount("catcowcat", "dog"));
  }

  static int strCount(String str, String sub) {
    if (str.length() < sub.length()) return 0;

    if (str.charAt(0) == sub.charAt(0)) {
      int i = 0;
      while (str.charAt(i) == sub.charAt(i)) {
        if (i == sub.length() - 1) {
          return 1 + strCount(str.substring(i + 1), sub);
        }
        i++;
      }
    }

    return strCount(str.substring(1), sub);
  }
}
