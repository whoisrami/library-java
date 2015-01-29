package AdjListDiGraphArrayList;

import java.util.ArrayList;

/**
 * Author: Alex Yang
 * Date: 11/5/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class DiGraph {
  private ArrayList<Node> vertices;

  public DiGraph() {
    vertices = new ArrayList<Node>();
  }

  public void addNode(Node x) {
    vertices.add(x);
  }

  public ArrayList<Node> getNodes() {
    return vertices;
  }

  public void printAdjList() {
    for (Node v : vertices) {
      System.out.print(v.getVertex() + ": ");
      for (Node adjacentVertex : v.getAdjacent()) {
        System.out.print(adjacentVertex.getVertex());
      }
      System.out.println();
    }
  }
}

