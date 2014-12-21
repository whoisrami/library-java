package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 12/20/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class SpiralMatrixRecursive {
  public static void main (String args[]) {
    int[][] matrix = {{1,  2,   3,  4, 97},
                      {5,  6,   7,  8, 98},
                      {9,  10,  11, 12, 99},
                      {13, 14,  15, 16, 100},
                      {17, 18,  19, 20, 101}};
    int[][] matrix2 = {{1,2,3,4},
                        {5,6,7, 8},
                        {9,10,11, 12}};

    List<Integer> results = spiralPrint(matrix);
    for (int i : results) {
      System.out.print(i);
      System.out.print(",");
    }
    System.out.println();

    results = spiralPrint(matrix2);
    for (int i : results) {
      System.out.print(i);
      System.out.print(" ");
    }
  }

  static List<Integer> spiralPrint(int[][] matrix) {
    return spiralPrint(matrix, matrix.length - 1, matrix[0].length - 1, 0, 0);
  }

  static List<Integer> spiralPrint(int[][] matrix, int rowIndex, int colIndex, int a, int b) {
    System.out.println(rowIndex + " " + colIndex + " positions: " + a + " " + b);
    List<Integer> results = new ArrayList<Integer>();

    if (rowIndex < 0 || colIndex < 0) return results;
    if (rowIndex == 0 && colIndex == 0) {
//      results.add(matrix[a][b]);
      return results;
    }

    for (int i = 0; i < colIndex; i++) {
      results.add(matrix[a][b]);
      b++;
    }

    for (int i = 0; i < rowIndex; i++) {
      results.add(matrix[a][b]);
      a++;
    }

    if (rowIndex > 0) {
      for (int i = 0; i < colIndex; i++) {
        results.add(matrix[a][b]);
        b--;
      }
    }

    if (colIndex > 0) {
      for (int i = 0; i < rowIndex; i++) {
        results.add(matrix[a][b]);
        a--;
      }
    }

    if (rowIndex == 0 || colIndex == 0) {
      results.addAll(spiralPrint(matrix, 0, 0, a, b));
    } else {
      a++;
      b++;
      rowIndex = rowIndex - 2;
      colIndex = colIndex - 2;
      results.addAll(spiralPrint(matrix, rowIndex, colIndex, a, b));
    }

    return results;
  }
}
