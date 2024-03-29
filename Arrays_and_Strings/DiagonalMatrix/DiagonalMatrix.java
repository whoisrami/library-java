package DiagonalMatrix;

/**
 * Author: Alex Yang
 * Date: 10/26/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a 2D matrix, print all elements of the given matrix in diagonal order. For example, consider the following 5 X 4 input matrix.

 1     2     3     4
 5     6     7     8
 9    10    11    12
 13    14    15    16
 17    18    19    20
 Diagonal printing of the above matrix is

 1
 5     2
 9     6     3
 13    10     7     4
 17    14    11     8
 18    15    12
 19    16
 20
 * Solution:
 * - N/A
 */
public class DiagonalMatrix {
  public static void main(String args[]) {
    int[][] matrix = {{1,  2,   3,  4},
                      {5,  6,   7,  8},
                      {9,  10,  11, 12},
                      {13, 14,  15, 16},
                      {17, 18,  19, 20}};

    diagonalPrint(matrix);
    System.out.println("************2nd sol");
    diagonalPrint2(matrix);
  }

  static void diagonalPrint(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    int numDiags = rows + columns - 1;

    for (int i = 0; i < numDiags; i++) {
      int x = i;
      int y = 0;

      for (int j = 0; j < i + 1; j++) {
        if ( 0 <= x &&
             x < rows &&
             0 <= y &&
             y < columns ) {
          System.out.print(matrix[x][y] + " ");
        }
        x--;
        y++;
      }
      System.out.println();
    }
  }

  //TODO: shift the rows, then iterate the columns
  static void diagonalPrint2(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    int maximum = rows + columns - 1;
    int diagonal;
    int i, j;

    for(diagonal = 0; diagonal < maximum; diagonal++)
    {
      for(i = diagonal, j = 0; i >= 0 && j <= diagonal; i--, j++)
      { //the key is to take one away from i and add one to j on each iteration
        //j cant ever be more than diagonal because
        if( i >= rows || j >= columns) //this is the out of bounds check
          continue;
        System.out.printf("%d ", matrix[i][j]);
      }
      System.out.printf("\n");
    }
  }
}
