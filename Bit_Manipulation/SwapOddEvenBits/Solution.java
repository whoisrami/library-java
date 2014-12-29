package SwapOddEvenBits;

/**
 * Author: Alex Yang
 * Date: 12/29/14
 * Dependencies:
 * - N/A
 * Description:
 * - Write a program to swap odd and even bits in an integer with as few instructions as possible (e.g. bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on)
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    int a = 10; //1010
    System.out.println(swap(a));
  }

  public static int swap(int n) {
    // mask with 1010..., assume 32 bit integer
    int oddMask = 0xaaaaaaaa;
    int odds = n & oddMask;
    odds >>= 1;

    // mask with 0101....
    int evenMask = 0x55555555;
    int evens = n & evenMask;
    evens <<= 1;

    return odds | evens;
  }
}
