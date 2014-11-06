package ConvertIntToBinary;

/**
 * Author: Alex Yang
 * Date: 11/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - Write a method which transforms an integer into a binary number, no libraries
 * Solution:
 * - N/A
 */
public class ConvertIntToBinary {
  public static void main(String args[]) {
    System.out.println(convert(9));
  }

  static String convert(int val) {
    StringBuffer sb = new StringBuffer();

    while(val > 0) {
      int bit = val%2;
      sb.insert(0, bit);
      val = val/2;
    }
    return sb.toString();
  }
}
