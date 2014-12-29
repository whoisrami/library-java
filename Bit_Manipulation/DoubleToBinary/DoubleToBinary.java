package DoubleToBinary;

/**
 * Author: Alex Yang
 * Date: 12/28/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.  If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR."
 * Solution:
 * - N/A
 */
public class DoubleToBinary {
  public static void main(String[] args) {
    double num = 0.625; //.101 in binary
    System.out.println(printBinary(num));
  }

  public static String printBinary(double num) {
    if (num >= 1 || num <= 0) return "ERROR";

    StringBuilder binary = new StringBuilder();
    binary.append(".");

    while (num > 0) {
      System.out.println(binary.length());
      System.out.println(binary.toString());
      System.out.println(num);
      if (binary.length() >= 32) return "ERROR";

      double r = num * 2;
      if (r >= 1) {
        binary.append(1);
        num = r - 1;
      } else {
        binary.append(0);
        num = r;
      }
    }

    return binary.toString();
  }
}
