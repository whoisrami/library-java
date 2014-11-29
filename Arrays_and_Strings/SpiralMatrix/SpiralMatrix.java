package SpiralMatrix;

import java.util.ArrayList;

/**
 * Author: Alex Yang
 * Date: 11/23/14
 * Dependencies:
 * - N/A
 * Description:
 * - Print a matrix in clockwise order.
 * Solution:
 * - N/A
 */
public class SpiralMatrix {
  public static void main(String[] args) {
    int[][] matrix = {{1,  2,   3,  4},
            {5,  6,   7,  8},
            {9,  10,  11, 12},
            {13, 14,  15, 16},
            {17, 18,  19, 20}};

    ArrayList<Integer> results = spiralPrint(matrix);
    for (int i : results) {
      System.out.print(i);
      System.out.print(",");
    }
  }

  static ArrayList<Integer> spiralPrint(int[][] matrix) {
    ArrayList<Integer> results = new ArrayList<Integer>();

    if (matrix == null || matrix.length == 0) return results;

    int row = matrix.length;
    int col = matrix[0].length;

    int x = 0;
    int y = 0;

    while (row > 0 && col > 0) {
      //if one row or column left, cannot form circle, so break
      if (row == 1) {
        for (int i = 0; i < col; i++) {
          results.add(matrix[x][y++]);
          break;
        }
      } else if (col == 1) {
        for (int i = 0; i < row; i++) {
          results.add(matrix[x++][y]);
        }
        break;
      }

      //move right
      for (int i = 0; i < col - 1; i++) {
        results.add(matrix[x][y++]);
      }

      //move down on the right (note at this point y is already positioned at the last column)
      for (int i = 0; i < row - 1; i++) {
        results.add(matrix[x++][y]);
      }

      //move bottom from right to left
      for (int i = 0; i < col - 1; i++) {
        results.add(matrix[x][y--]);
      }

      //move up from left to top
      for (int i = 0; i < row - 1; i++) {
        results.add(matrix[x--][y]);
      }

      x++;
      y++;
      row = row-2;
      col = col-2;
    }

    return results;
  }

  //TODO: recursive solution here: http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
}
