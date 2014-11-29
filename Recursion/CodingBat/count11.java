package CodingBat;

/**
 * Author: Alex Yang
 * Date: 11/29/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.

 count11("11abc11") → 2
 count11("abc11x11x11") → 3
 count11("111") → 1
 * Solution:
 * - N/A
 */
public class count11 {
  public static void main(String args[]) {
    System.out.println(count11("11abc11")); //2
    System.out.println(count11("abc11x11x11")); //3
    System.out.println(count11("111")); //1
  }

  static int count11(String str) {
    if (str.length() < 2) {
      return 0;
    }

    if (str.charAt(0) == '1' && str.charAt(1) == '1') {
      return 1 + count11(str.substring(2));
    }

    return count11(str.substring(1));
  }

}
