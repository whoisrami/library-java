package CodingBat;

/**
 * Author: Alex Yang
 * Date: 11/21/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".

 allStar("hello") → "h*e*l*l*o"
 allStar("abc") → "a*b*c"
 allStar("ab") → "a*b"
 * Solution:
 * - N/A
 */
public class allStar {
  public static void main(String args[]) {
    System.out.println(allStar("hello"));
    System.out.println(allStar("abc"));
    System.out.println(allStar("ab"));
  }

  static String allStar(String str) {
    if (str.length() <= 1) {
      return str;
    }

    return str.charAt(0) + "*" + allStar(str.substring(1));
  }
}
