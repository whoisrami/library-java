package AdjListDiGraphArrayList;

import java.util.ArrayList;

/**
 * Author: Alex Yang
 * Date: 1/24/15
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class Node {
  private ArrayList<Node> adjacent = new ArrayList<Node>(); //max input size
  public int adjacentCount = 0;
  public State.Status state;
  public String vertex;
  public static final int UNVISITED = 0;
  public static final int VISITING = 1;
  public static final int VISITED = 2;
  public int status = UNVISITED;

  public Node(String vertex) {
    this.vertex = vertex;
  }

  //code to keep adjcanet
  public void addAdjacent(Node x) {
    adjacent.add(x);
  }

  public ArrayList<Node> getAdjacent() {
    return adjacent;
  }

  public String getVertex() {
    return vertex;
  }

  public void printAdjacent() {
    for (Node n : adjacent) {
      System.out.print(n.vertex + " ");
    }
    System.out.println();
  }
}
