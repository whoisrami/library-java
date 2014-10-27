package AdjListDiGraph;

/**
 * Author: Alex Yang
 * Date: 10/27/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */

public class AdjListDiGraph {
  private Node vertices[];
  public int currentVertices;
  public int maxVertices;

  public AdjListDiGraph(int v) {
    vertices = new Node[v];
    maxVertices = v;
    currentVertices = 0;
  }

  public void addNode(Node x) {
    if (currentVertices < maxVertices) {
      vertices[currentVertices] = x;
      currentVertices++;
    } else {
      System.out.print("Graph full with " + currentVertices + " vertices out of " + maxVertices +" possible.");
    }
  }

  public Node[] getNodes() {
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
