package MinPathSum;

/**
 * Author: Alex Yang
 * Date: 1/30/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 * Solution:
 * - N/A
 */
public class Solution {
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;

    int rowIndex = grid.length - 1;
    int colIndex = grid[0].length - 1;

    //start at bottom right, try to get to 0,0
    Integer minSum = 0;
    minPathSum(grid, rowIndex, colIndex, minSum, 0);
    return minSum;
  }

  public void minPathSum(int[][] grid, int row, int col, Integer minSum, int currSum) {
    if (row < 0 || col < 0) return; //out of bounds

    if (row == 0 && col == 0) {
      minSum = Math.min(minSum, currSum);
      minSum += grid[0][0];
      return;
    }

    currSum += grid[row][col];
    minPathSum(grid, row - 1, col, minSum, currSum);
    minPathSum(grid, row, col - 1, minSum, currSum);
  }

}
