package SpiralMatrix;

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
public class SpiralPrint {
  public static void main (String args[]) {
    int[][] matrix = {{11,  12,   13,  14, 15},
                     {21,  22,   23,  24, 25},
                     {31,  32,  33, 34, 35},
                     {41, 42,  43, 44, 45}};

    int[][] matrix2 = {{1,2,3,4},
                       {5,6,7, 8},
                       {9,10,11, 12}};

    spiralPrint(matrix);
    System.out.println();
    spiralPrint(matrix2);
  }

  static void spiralPrint(int[][] matrix) {
    //initialize with the index of the last row/cols, these will be the "bounds"
    //as well as two markers that will mark the current row/col position in the matrix
    spiralPrint(matrix, matrix.length - 1, matrix[0].length - 1, 0, 0);
  }

  static void spiralPrint(int[][] matrix, int rowIndex, int colIndex, int a, int b) {
    if (rowIndex < 0 || colIndex < 0) return;

    //TODO: this has a bug, on certain matrixes, check SpiralMatrixRecursive for fix
    //on last element
    if (rowIndex == 0 && colIndex == 0) {
      System.out.print(matrix[a][b]);
      System.out.print("lol");
      return;
    }

    //print from top-left to top-right
    for (int i = 0; i < colIndex; i++) {
      System.out.print(matrix[a][b]);
      System.out.print(" ");
      b++;
    }

    //print from top-right to bottom-right
    for (int i = 0; i < rowIndex; i++) {
      System.out.print(matrix[a][b]);
      System.out.print(" ");
      a++;
    }

    //print from bottom-right to bottom-left
    for (int i = 0; i < colIndex; i++) {
      System.out.print(matrix[a][b]);
      System.out.print(" ");
      b--;
    }

    //print from bottom-left to top-left
    for (int i = 0; i < rowIndex; i++) {
      System.out.print(matrix[a][b]);
      System.out.print(" ");
      a--;
    }

    if (rowIndex == 0 || colIndex == 0) {
      spiralPrint(matrix, 0, 0, a, b);
    } else {
      a++;
      b++;
      rowIndex = rowIndex - 2;
      colIndex = colIndex - 2;
      spiralPrint(matrix, rowIndex, colIndex, a, b);
    }
  }
}
