package MatrixGroups;

/**
 * Author: Alex Yang
 * Date: 10/25/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a 2d-array (matrix) of 0s and 1s, find the number of groups of 1s, where a group is defined by adjacent vertical and horizontal 1s.
 * Solution:
 * - N/A
 */
public class MatrixGroups {
  public static void main(String args[]) {
    //3 groups
    int[][] matrix = {{0, 0, 1},
                      {1, 1, 1},
                      {0, 0, 1}};

    System.out.println(numGroups(matrix));
  }

  static int numGroups(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int count = 0;
    for(int i=0; i<rows; i++) {
      for(int j=0; j<cols; j++) {
        if(matrix[i][j] == 1) {
          count++;
          traverse(matrix, i, j);
        }
      }
    }
    return count;
  }

  static void traverse(int[][] matrix, int i, int j) {
    if(i < 0 || j < 0) //negative indexes
      return;
    if(i >= matrix.length || j >= matrix[0].length) //over row/column count
      return;
    if(matrix[i][j] != 1) //0 or -1
      return;

    matrix[i][j] = -1;
    traverse(matrix, i-1, j);
    traverse(matrix, i+1, j);
    traverse(matrix, i, j-1);
    traverse(matrix, i, j+1);
  }
}
