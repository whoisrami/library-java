package GrayCodeSequence;

/**
 * Author: Alex Yang
 * Date: 12/9/14
 * Dependencies:
 * - N/A
 * Description:
 * - Check if two numbers are consecutive numbers in gray code sequence.
 * Solution:
 * - N/A
 */
public class GrayCodeSequence {
  public static void main(String args[]) {
    System.out.println(checkSequence(4,5));

  }

  //TODO: just xor both numbers ad check if power of 2
  //can check if power of 2 with n & (n-1) == 0
  static boolean checkSequence(int i1, int i2) {
    int differences = 0;
    while (i1 > 0 || i2 > 0) {
      if ((i1 & 1) != (i2 & 1)) { //checks least significant bit for equality using &
        differences++;
        System.out.println(differences);
      }

      i1 >>= 1;
      i2 >>= 1;
    }
    return differences < 2;
  }
}
