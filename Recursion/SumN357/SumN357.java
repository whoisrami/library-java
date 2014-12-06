package SumN357;

/**
 * Author: Alex Yang
 * Date: 12/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - print all possible combinations of the numbers 3,5,7 that sum up to some number n
 * Solution:
 * - N/A
 */
public class SumN357 {
  public static void main(String args[]) {
    System.out.println(printCombinations(10));
  }

  static int printCombinations(int n) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    return printCombinations(n - 3) + printCombinations(n - 5) + printCombinations(n - 7);
  }
}
