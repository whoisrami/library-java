package CodingBat;

/**
 * Author: Alex Yang
 * Date: 12/1/14
 * Dependencies:
 * - N/A
 * Description:
 * - Move all non-zero elements into the front of array.
 * Solution:
 * - N/A
 */
public class zeroFront {
  public static void main(String[] args) {
    System.out.println(moveZeros("re00"));
    System.out.println(moveZeros("00hi00"));
    System.out.println(moveZeros("0hi0hi0"));
  }

  static String moveZeros(String str) {
    if (str.length() < 1) {
      return str;
    }

    if (str.charAt(str.length() - 1) == '0') {
      return '0' + moveZeros(str.substring(0, str.length() - 1));
    }

    return moveZeros(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
  }
}
