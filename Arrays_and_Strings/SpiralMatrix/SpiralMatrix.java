package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 12/11/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class SpiralMatrix {
  public static void main(String args[]) {
    int[][] matrix = {{1,  2,   3,  4, 97},
            {5,  6,   7,  8, 98},
            {9,  10,  11, 12, 99},
            {13, 14,  15, 16, 100},
            {17, 18,  19, 20, 101}};
    int[][] matrix2 = {{1,2,3,4},
            {5,6,7, 8},
            {9,10,11, 12}};

    int[][] matrix3 = {{11,  12,   13,  14, 15},
            {21,  22,   23,  24, 25},
            {31,  32,  33, 34, 35},
            {41, 42,  43, 44, 45}};

    List<Integer> results = spiralPrint(matrix);
    for (int i : results) {
      System.out.print(i);
      System.out.print(",");
    }
    System.out.println();

    List<Integer> results2 = spiralPrint(matrix2);
    for (int i : results2) {
      System.out.print(i);
      System.out.print(" ");
    }

    System.out.println();
    List<Integer> results3 = spiralPrint(matrix3);
    for (int i : results3) {
      System.out.print(i);
      System.out.print(" ");
    }
  }

  static List<Integer> spiralPrint(int[][] matrix) {
    int x = 0;
    int y = 0;

    int rows = matrix.length - 1;
    int cols = matrix[0].length - 1;

    List<Integer> results = new ArrayList<>();
    while (rows >= 0 || cols >= 0) {
      if (rows == 0 && cols == 0) {
        results.add(matrix[x][y]);
        break;
      }

      for (int i = 0; i < cols; i++) {
        results.add(matrix[x][y]);
        y++;
      }

      for (int i = 0; i < rows; i++) {
        results.add(matrix[x][y]);
        x++;
      }

      for (int i = cols; i > 0; i--) {
        results.add(matrix[x][y]);
        y--;
      }

      for (int i = rows; i > 0; i--) {
        results.add(matrix[x][y]);
        x--;
      }

      x++;
      y++;
      rows = rows - 2;
      cols = cols - 2;
    }

    return results;
  }
}
