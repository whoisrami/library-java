package Robot;

import Factorial.Factorial;

import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Author: Alex Yang
 * Date: 9/25/14
 * Dependencies:
 * - Recursion/Factorial/Factorial.java
 * Description:
 * - Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions: right and down.  How many possible paths are there for the robot to go from (0, 0) to (X, Y)?
 * - FOLLOW UP: Imagine certain spots are "off limits", such that the robot cannot step on them.  Design an algorithm to find a path for the robot form the top left to the bottom right.
 * Solution:
 * - N/A
 */
public class Robot {
  public static int[][] maze = new int[10][10];

  public static void main(String args[]) {
    int xCoord = 2;
    int yCoord = 3;
    System.out.println(numPaths(xCoord, yCoord));

    ArrayList<Point> path = new ArrayList<Point>();

    block(0, 2);
    block(1, 0);

    //initialize cache
    Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();

    //call getPath
    boolean success = getPathDP(xCoord, yCoord, path, cache);

    //if true, print out the path
    if (success) {
      String s = listOfPointsToString(path);
      System.out.println(s);
    } else {
      System.out.println("No path found.");
    }
  }

  /**
   * number of paths from 0,0 to X,Y is given by (X + Y)!/X!Y! or...X+Y choose X
   *
   * this is because assuming a path is X "rights" and Y "downs", there are (X + Y)! unique combinations of paths.  But, since the X "rights" (and Y "downs") are all identical, and can be arranged in X! (or Y!) ways, we need to divide these out since they would result in the same path.
   *
   * Essentially, the final equation is:
   * All possible paths / (All possible identical right combinations * All possible identical down combinations)
   */

  static int numPaths(int x, int y) {
    return Factorial.factorial(x + y) /
            (Factorial.factorial(x) * Factorial.factorial(y));
  }

  static boolean isFree(int x, int y) {
    if (maze[x][y] == -1) {
      System.out.println("found blocked at " + x + ", " + y );
      return false;
    } else {
      return true;
    }
  }

  static void block(int x, int y) {
    maze[x][y] = -1;
  }

  public static String listOfPointsToString(ArrayList<Point> list) {
    StringBuilder buffer = new StringBuilder();
    for (Point p : list) {
      buffer.append("(" + p.x + "," + p.y + ")");
    }
    return buffer.toString();
  }

  static boolean getPath(int x, int y, ArrayList<Point> path) {
    //check if out of bounds or spot blocked
    if (y < 0 || x < 0 || !isFree(x, y)) {
      return false;
    }

    //check if at origin, or path from start to current location, and add location
    if ((x == 0 && y == 0) || getPath(x - 1, y, path) || getPath(x, y -  1, path)) {
      Point p = new Point(x, y);
      path.add(p);
      return true;
    }

    return false;
  }

  static boolean getPathDP(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache) {
    Point cachedPoint = new Point(x, y);

    //if already inside cache, return boolean
    if (cache.containsKey(cachedPoint)) {
      return cache.get(cachedPoint);
    }

    //if invalid coordinate, return false
    if (y < 0 || x < 0 || !isFree(x, y)) {
      return false;
    }

    //check if at origin, or path from start to current location, and add location
    if ((x == 0 && y == 0) || getPathDP(x - 1, y, path, cache) || getPathDP(x, y -  1, path, cache)) {
      Point p = new Point(x, y);
      path.add(p);
      cache.put(cachedPoint, true);
      return true;
    }

    //no path to 0,0 from this point, put false in cache
    cache.put(cachedPoint, false);
    return false;
  }
}
