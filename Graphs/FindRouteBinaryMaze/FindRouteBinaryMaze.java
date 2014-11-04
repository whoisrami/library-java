package FindRouteBinaryMaze;

import java.util.LinkedList;

/**
 * Author: Alex Yang
 * Date: 10/30/14
 * Dependencies:
 * - N/A
 * Description:
 * - you have a 2D matrix with 1's as blocked path. Find a path from one corner to another, backtracking should be allowed.
 * Solution:
 * - TODO: make more efficient, by adding a visited check?
 * - TODO: add DFS implementation
 */
public class FindRouteBinaryMaze {
  LinkedList<Cell> queue = new LinkedList<>();
  int[][] matrix;

  public static void main(String args[]) {
    int[][] matrix = {{0,0,0,1},
                      {0,1,0,0},
                      {1,0,1,0},
                      {0,0,0,0}};

    FindRouteBinaryMaze maze = new FindRouteBinaryMaze(matrix);
    Cell start = new Cell(0,0);
    Cell end = new Cell(3,3);

    maze.getPath(matrix, start, end);
  }

  public FindRouteBinaryMaze(int[][] matrix) {
    this.matrix = matrix;
  }

  //bfs implementation
  public void getPath(int[][] matrix, Cell start, Cell end) {

    queue.add(start);

    while(!queue.isEmpty()) {
      Cell cell = queue.poll();
      if (cell.row == end.row && cell.column == end.column) {
        //print out the path
        printPath(cell);
        break;
      }
      //add adjacent vertices to be traversed
      addAdjacentCells(cell);
    }
  }

  void addAdjacentCells(Cell cell) {
    Cell c = cell;
    int row = cell.row;
    int column = cell.column;

    //check top
    if (row != 0) {
      if(matrix[row - 1][column] == 0) {
        Cell top = new Cell(row - 1, column);
        addToPath(c, top);
      }
    }

    //check bottom
    if (row != matrix.length - 1) {
      if(matrix[row + 1][column] == 0) {
        Cell bottom = new Cell(row + 1, column);
        addToPath(c, bottom);
      }
    }

    //check right
   if (column != matrix[0].length - 1) {
     if(matrix[row][column + 1] == 0) {
       Cell right = new Cell(row, column + 1);
       addToPath(c, right);
     }
   }

    //check left
   if (column != 0) {
     if(matrix[row][column - 1] == 0) {
       Cell left = new Cell(row, column -1);
       addToPath(c, left);
     }
   }
  }

  void addToPath(Cell parent, Cell current) {
    current.parent = parent;
    queue.add(current);
  }

  void printPath(Cell cell) {
    Cell c = cell;
    while(c.parent != null) {
      System.out.println("(" + c.row + ", " + c.column + ")");
      c = c.parent;
    }
    System.out.println("(" + c.row + ", " + c.column + ")");
  }

  static class Cell {
    int row;
    int column;
    Cell parent;

    public Cell(int row, int column) {
      this.row = row;
      this.column = column;
    }
  }
}
