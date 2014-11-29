package CodingBat;

/**
 * Author: Alex Yang
 * Date: 11/21/14
 * Dependencies:
 *  - N/A
 * Description:
 *  -
 Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.

 endX("xxre") → "rexx"
 endX("xxhixx") → "hixxxx"
 endX("xhixhix") → "hihixxx"
 * Solution:
 *  - N/A
 */
class endX {
  public static void main(String[] args) {
    System.out.println(endXfunc("xxre"));
    System.out.println(endXfunc("xxhixx"));
    System.out.println(endXfunc("xhixhix"));
  }

  static String endXfunc(String str) {
    if (str.length() <= 1) {
      return str;
    }

    if (str.charAt(0) == 'x') {
      return endXfunc(str.substring(1)) + 'x';
    }

    return str.charAt(0) + endXfunc(str.substring(1));
  }
}
