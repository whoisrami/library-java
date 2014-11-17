package CodingBat;

/**
 * Author: Alex Yang
 * Date: 11/17/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given a string, compute recursively a new string where all the 'x' chars have been removed.

 noX("xaxb") → "ab"
 noX("abc") → "abc"
 noX("xx") → ""
 * Solution:
 * - N/A
 */
public class noX {
  public static void main(String args[]) {
    System.out.println(noX("xaxb"));
    System.out.println(noX("abc"));
    System.out.println(noX("xx"));
  }

  static String noX(String str) {
    if (str.length() == 0) return str;
    if (str.charAt(0) == 'x') {
      if (str.length() <= 1) return "";
      return noX(str.substring(1));
    }
    if (str.length() == 1) return str;

    return str.charAt(0) + noX(str.substring(1));
  }
}
