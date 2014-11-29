package ZeroRowCol;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: Alex Yang
 * Date: 11/29/14
 * Dependencies:
 * - N/A
 * Description:
 * - Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 * Solution:
 * - N/A
 */
public class ZeroRowCol {
  public static void main(String args[]) {
    int[][] matrix = {{1,  2,   0,  4},
                      {0,  6,   7,  8},
                      {9,  0,  11, 12},
                      {13, 14,  15, 16}};

    printMatrix(matrix);
    System.out.println("zeroed out");
    zero(matrix);
    printMatrix(matrix);
  }

  static void zero(int[][] matrix) {
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    Iterator<Integer> iter = rows.iterator(); //just practicing iterators

    while (iter.hasNext()) {
      int i = iter.next();
      for (int c = 0; c < matrix[0].length; c++) {
        matrix[i][c] = 0;
      }
    }

    for (int j : cols) {
      for (int r = 0; r < matrix.length; r++) {
        matrix[r][j] = 0;
      }
    }
  }

  static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j]);
        System.out.print(",   ");

      }
      System.out.println();
    }
  }
}
