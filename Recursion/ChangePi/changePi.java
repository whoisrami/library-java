package ChangePi;

/**
 * Author: Alex Yang
 * Date: 11/17/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".

 changePi("xpix") → "x3.14x"
 changePi("pipi") → "3.143.14"
 changePi("pip") → "3.14p"
 * Solution:
 * - N/A
 */
public class changePi {
  public static void main(String args[]) {
    System.out.println(changePi("pi"));
    System.out.println(changePi("p"));
    System.out.println(changePi("xpix"));
    System.out.println(changePi("pipi"));
    System.out.println(changePi("pip"));
  }

  static String changePi(String str) {
    String pi = "3.14";
    if (str.length() <= 1) return str;
    if (str.substring(0,2).equals("pi")) {
      return pi + changePi(str.substring(2));
    }
    return str.charAt(0) + changePi(str.substring(1));
  }
}
