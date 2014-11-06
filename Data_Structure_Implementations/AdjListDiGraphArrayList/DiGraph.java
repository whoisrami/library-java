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

class Node {
  private ArrayList<Node> adjacent = new ArrayList<Node>(); //max input size
  public int adjacentCount = 0;
  public State.Status state;
  public String vertex;

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

class State {
  public enum Status {
    Unvisited, Visited, Visiting;
  }
}