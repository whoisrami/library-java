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
public class Node {
  private Node adjacent[];
  public int adjacentCount;
  private String vertex;
  public State.Status state;

  public Node(String vertex, int adjacentLength) {
    this.vertex = vertex;
    adjacentCount = 0;
    adjacent = new Node[adjacentLength];
  }

  public void addAdjacent(Node x) {
    this.adjacent[adjacentCount] = x;
    adjacentCount++;
  }

  public Node[] getAdjacent() {
    return adjacent;
  }
  public String getVertex() {
    return vertex;
  }
}