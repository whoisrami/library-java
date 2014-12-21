package CodingBat;

/**
 * Author: Alex Yang
 * Date: 12/11/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immediately before them.

 countHi2("ahixhi") → 1
 countHi2("ahibhi") → 2
 countHi2("xhixhi") → 0
 * Solution:
 * - N/A
 */
public class countHi2 {
  public static void main(String args[]) {
    System.out.println(countHi("ahixhi"));
    System.out.println(countHi("ahibhi"));
    System.out.println(countHi("xhixhi"));
  }

  static int countHi(String str) {
    if (str.length() <= 1) return 0;

    if (str.charAt(0) == 'x' && str.charAt(1) != 'x') {
      return countHi(str.substring(2));
    } else if (str.charAt(0) == 'x') { //multiple x in a row
      return countHi(str.substring(1));
    }

    if (str.charAt(0) == 'h' && str.charAt(1) == 'i') {
      return 1 + countHi(str.substring(2));
    }

    return countHi(str.substring(1));
  }
}
