package NumBitsToConvertAToB;

import Helpers.HelperMethods;
/**
 * Author: Alex Yang
 * Date: 12/28/14
 * Dependencies:
 * - N/A
 * Description:
 * - Write a function to determine the number of bits required to convert integer A to integer B.
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    int a = 23432;
    int b = 512132;
    HelperMethods.toFullBinaryString(a);
    HelperMethods.toFullBinaryString(b);
    int nbits = numBits(a, b);
    System.out.println("Required number of bits: " + nbits);
  }

  public static int numBits(int a, int b) {
    int count = 0;
    int c = a ^ b;

    while (c != 0) {
      if ((c & 1) == 1) count++;
      c >>= 1;
    }
    return count;
  }
}
