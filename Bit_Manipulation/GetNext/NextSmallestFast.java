package GetNext;

/**
 * Author: Alex Yang
 * Date: 12/28/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class NextSmallestFast {
  public static void main(String[] args) {
    System.out.println(getPrev(10)); //should return 9 1010, 1001
  }

  public static int getPrev(int n) {
    //compute trailing ones and block of zeros to the left of trailing ones
    int trailingOnes = 0;
    int zeros = 0;
    int c = n;

    while ((c & 1) == 1) {
      trailingOnes++;
      c >>= 1;
    }

    if (c == 0) return -1; //it was 1111...11, so no smaller number with same # of 1s

    while ((c & 1) == 0 && c != 0) {
      zeros++;
      c >>= 1;
    }

    int position = trailingOnes + zeros;

    //flip rightmost non-trailing one to a zero
    //clear all bits to the right of position
    //these steps are merged!
    int clear = ~0;
    clear <<= position + 1; //flip position to 0 as well!
    n = n & clear;

    //insert (trailing + 1) ones immediately to the right of position
    //then insert (zeros - 1) zeroes afterwards
    int mask = 1 << trailingOnes + 1;
    mask = mask - 1;
    mask <<= zeros - 1;
    n = n | mask;

    return n;
  }
}
