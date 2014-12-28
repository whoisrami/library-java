package InsertInside;

import Helpers.HelperMethods;

/**
 * Author: Alex Yang
 * Date: 12/28/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given two 32-bit integers, N and M, and two bit positions, i and j.
 * - Insert M into N, such that M starts at bit j and ends at bit i.
 * - Assume that the bits j through i have enough space to fit all of M.
 * Solution:
 * - Original source CTCI
 */
public class Solution {
  public static void main(String[] args){
    int a = 1024; //10000000000
    int b = 19; //10011
    int c = updateBits(a, b, 2, 6); //10001001100

    HelperMethods.toFullBinaryString(a);
    HelperMethods.toFullBinaryString(b);
    HelperMethods.toFullBinaryString(c);
  }

  static int updateBits(int n, int m, int i, int j) {
    // Validation
    if (i >= 32 || j < i) {
      return 0;
    }

    // Create a mask to clear bits i through j in n EXAMPLE: i = 2, j = 4.
    // Result should be 11100011.
    // Technique is to create the left side of the mask first, then the right.
    int ones = ~0; // ones = 11111111

    // get 11100000
    int left = ones << (j + 1);

    // first get         00000001
    // shift left, get   00000100
    // subtract 1, get   00000011
    // clever....the number before one with perfectly one set bit has to have all 1s starting immediately after that bit
    int right = (1 << i) - 1;

    // combine, get 11100011
    int mask = left | right;

    // clear bits in N (use x & 0 = 0)
    // example:
    // 10101010 original
    // 11100011 mask
    // 10100011 result (cleared)
    n = n & mask;

    // move m into correct position
    m = m << i;

    // OR the two (use x|0 = x)
    return n | m;
  }
}
