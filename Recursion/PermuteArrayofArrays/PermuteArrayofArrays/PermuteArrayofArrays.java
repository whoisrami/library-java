package PermuteArrayofArrays.PermuteArrayofArrays;

/**
 * Author: Alex Yang
 * Date: 12/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class PermuteArrayofArrays {
  public static void main(String args[]) {
    char[] c1 = new char[]{'a', 'b', 'c'};
    char[] c2 = new char[]{'d', 'e', 'f'};
    char[] c3 = new char[]{'g', 'h', 'i'};

    char[][] arr = {c1 ,c2, c3};
    permute(arr);
  }

  static void permute(char[][] matrix) {
    permute(matrix, 0, "");
  }

  static void permute(char[][] matrix, int level, String permutation) {
    if (level >= matrix.length) {
      System.out.println(permutation);
      return;
    }

    for (char c : matrix[level]) {
      permute(matrix, level + 1, permutation + c);
    }
  }
}

