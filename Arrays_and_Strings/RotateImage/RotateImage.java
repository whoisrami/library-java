package RotateImage;

/**
 * Author: Alex Yang
 * Date: 11/29/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class RotateImage {
  public static void main(String args[]) {
    int[][] matrix = {{1,  2,   3,  4},
            {5,  6,   7,  8},
            {9,  10,  11, 12},
            {13, 14,  15, 16}};

    printMatrix(matrix);
    rotate(matrix);

    System.out.println("rotated form");
    printMatrix(matrix);
  }
  //TODO: look at cracking the coding interview for cleaner code
  static void rotate(int[][] matrix) {
    int layers = matrix.length/2;

    int col = matrix[0].length - 1;
    int row = matrix.length - 1;
    int counter = 0; //keeps track of layers done

    for (int l = 0; l < layers; l++) {
      for (int i = 0; i < col - counter; i++) { //note to not go all the way to the right, stop 1 before!
        int top = matrix[l][i + l];
        int right = matrix[i + l][col - l];
        int bottom = matrix[row - l][col - i - l];
        int left = matrix[row - i - l][l];

        matrix[l][i + l] = left;
        matrix[i + l][col - l] = top;
        matrix[row - l][col - i - l] = right;
        matrix[row - i - l][l] = bottom;
      }

      counter += 2;
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
