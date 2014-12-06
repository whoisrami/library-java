package FindSortedMatrix;

/**
 * Author: Alex Yang
 * Date: 11/30/14
 * Dependencies:
 * - N/A
 * Description:
 * - Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 * Solution:
 * - N/A
 */
public class FindSortedMatrixEasy {
  public static void main(String args[]) {
    int[][] matrix = {{1,  3,  5,  7},
                      {10,  11,  16,  20},
                      {23,  30,  34, 50}};

    int target = 3;
    System.out.println(search(matrix, 34));
  }

  static boolean search(int[][] matrix, int target) {
    int rowIndex = matrix.length - 1;
    int colIndex = matrix[0].length - 1;

    int start = 0;
    int mid = 0;
    int end = rowIndex;

    int row = -1;

    //binary search first element at each row (column 1)
    while (start <= end) {
      mid = (start + end)/2;
      if (matrix[mid][0] <= target) {
        if (matrix[mid][colIndex] >= target) { //check if target is between first and last element of row, using the column indexes 0 and last
          row = mid;
          break;
        } else {
          start = mid + 1;
        }
      } else {
        end = mid - 1;
      }
    }

    if (row == -1) return false;

    start = 0;
    mid = 0;
    end = colIndex;

    //now binary search on the row that was found, element must be in this row
    while (start <= end) {
      mid = (start + end)/2;
      if (matrix[row][mid] == target) {
        return true;
      } else if (matrix[row][mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return false;
  }


}
