package CodingBat;

/**
 * Author: Alex Yang
 * Date: 11/21/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class pairStar {
  public static void main(String args[]) {
    System.out.println(pairStar("hello"));
    System.out.println(pairStar("xxyy"));
    System.out.println(pairStar("aaaa"));
  }

  static String pairStar(String str) {
    if (str.length() <= 1) {
      return str;
    }

    if (str.charAt(0) == str.charAt(1)) {
      return str.charAt(0) + "*" + pairStar(str.substring(1));
    }

    return str.charAt(0) + pairStar(str.substring(1));
  }
}
