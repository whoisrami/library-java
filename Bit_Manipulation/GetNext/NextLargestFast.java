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
public class NextLargestFast {
  public static void main(String[] args) {
    System.out.println(getNext(10)); //should get 12
  }

  // basic steps
  // 1. flip the rightmost 0 with some 1(s) to its right
  // 2. clear all bits from that index onward, saving the number of 1's
  // 3. shift in number of 1's - 1 (for the 0 we flipped earlier) from the right
  //    (steps 2 and 3 ensure that all 0's on left and all 1's on the right, after index)
  public static int getNext(int n) {
    int c = n;
    int trailingZeros = 0;
    int savedOnes = 0;

    // count all trailing 0s
    while ((c & 1) == 0 && c != 0) {
      trailingZeros++;
      c >>= 1;
    }

    // count all 1s immediately before trailing 0s
    while ((c & 1) == 1) {
      savedOnes++;
      c >>= 1;
    }

    // error check: if n == 11..1100..00, then no bigger number, or if 0 passed in
    if (trailingZeros + savedOnes == 31 || trailingZeros + savedOnes == 0) {
      return -1;
    }

    // this is the position of rightmost non-trailing 0
    int flipIndex = savedOnes + trailingZeros;

    // flip the rightmost non-trailing zero
    int set = 1 << flipIndex;
    n = n | set;

    // clear all bits right of index
    int clear = 1 << flipIndex;
    clear -= 1;
    int mask = ~(clear);
    n = n & mask;

    // insert (savedOnes - 1) ones on the right
    int insert = 1 << (savedOnes - 1);
    insert -= 1;
    n = n | insert;

    return n;
  }
}
