package CodingBat;

/**
 * Author: Alex Yang
 * Date: 12/11/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".

 stringClean("yyzzza") → "yza"
 stringClean("abbbcdd") → "abcd"
 stringClean("Hello") → "Helo"
 * Solution:
 * - N/A
 */
public class stringClean {
  public static void main(String[] args) {
    System.out.println(stringClean("yyzzza"));
    System.out.println(stringClean("abbbcdd"));
    System.out.println(stringClean("Hello"));
  }

  static String stringClean(String str) {
    if (str.length() < 1) return null;
    if (str.length() == 1) return "" + str.charAt(0);

    if (str.charAt(0) ==  str.charAt(1)) {
      return stringClean(str.substring(1));
    }

    return str.charAt(0) + stringClean(str.substring(1));
  }
}