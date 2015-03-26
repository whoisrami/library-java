package SurroundedRegions;

import java.awt.*;
import java.util.LinkedList;
import Helpers.HelperMethods;

/**
 * Author: Alex Yang
 * Date: 3/25/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    char[][] matrix =
            {{'X',  'X',   'X',  'X'},
            {'X',  'O',   'O',  'X'},
            {'X',  'O',  'O', 'X'},
            {'X', 'X',  'X', 'X'},
            {'X', 'O',  'O', 'X'}};

    Solution sol = new Solution();
    sol.solve(matrix);

     HelperMethods.printMatrix(matrix);
  }



  public void solve(char[][] board) {
    if (board.length == 0) return;


    int rows = board.length;
    int cols = board[0].length;

    //loop through outer shell, set to tmp diff marker
//    for (int a = 0; a < rows; a++) {
//      if (board[a][0] == 'O') flip(board, a, 0, 'V');
//      if (board[a][cols - 1] == 'O') flip(board, a, cols-1, 'V');
//    }
//
//    for (int b = 0; b < cols; b++) {
//      if (board[0][b] == 'O') flip(board, 0, b, 'V');
//      if (board[rows - 1][b] == 'O') flip(board, rows - 1, b, 'V');
//    }

    markOuter(board, rows, cols, 'O', 'V');

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == 'O') {
          flip(board, i, j, 'O', 'X');
        }
      }
    }


    //loop through outer shell, reset all to O
    markOuter(board, rows, cols, 'V', 'O');
  }

  public void markOuter(char[][] board, int rows, int cols, char orig, char result) {
    for (int a = 0; a < rows; a++) {
      if (board[a][0] == orig) flip(board, a, 0, orig, result);
      if (board[a][cols - 1] == orig) flip(board, a, cols-1, orig, result);
    }

    for (int b = 0; b < cols; b++) {
      if (board[0][b] == orig) flip(board, 0, b, orig, result);
      if (board[rows - 1][b] == orig) flip(board, rows - 1, b, orig, result);
    }
  }

  public void flip(char[][] board, int i, int j, char orig, char result) {
    LinkedList<Point> q = new LinkedList<>();
    q.add(new Point(i, j));
    board[i][j] = result;

    while (!q.isEmpty()) {
      Point p = q.poll();
      int row = p.i;
      int col = p.j;
      for (int r = row-1; r <= row + 1; r++) {
        for (int c = col-1; c <= col + 1; c++) {

          //hack to skip diagonal neighbors
          if (r != row && c != col) {
            continue;
          }
          //check if val is out of bounds
          if (r < 0  || c < 0 || r > board.length - 1 || c > board[0].length - 1) {
            continue;
          }

          if (board[r][c] == orig) {
            q.add(new Point(r, c));
            board[r][c] = result;
          }
        }
      }
    }

  }

  class Point {
    int i;
    int j;

    public Point(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}
