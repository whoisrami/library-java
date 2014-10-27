package AdjMatrixDiGraph;

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
public class AdjMatrixDiGraph {
  Vertex[] vertices;
  int[][] adjMat;
  int maxVertices;
  int count = 0;

  static class Vertex {
    int data;
    int index;
    public Vertex (int data) {
      this.data = data;
    }
  }

  public AdjMatrixDiGraph (int maxVertices) {
    this.adjMat = new int[maxVertices][maxVertices];
    this.maxVertices = maxVertices;
    this.vertices = new Vertex[maxVertices];
  }

  Vertex addNode (int data) {
    if (count >= maxVertices) {
      System.out.println("No vertex added. Graph is full.");
      return null;
    }

    Vertex v = new Vertex(data);
    v.index = count;
    vertices[count++] = v;
    return v;
  }

  void addAdjacent (Vertex n, Vertex m) {
    this.adjMat[n.index][m.index] = 1;
  }

  void printMatrix () {
    for (int i = 0; i < count; i++) {
      for (int j = 0; j < count; j++) {
        System.out.print(adjMat[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main (String[] args) {
    AdjMatrixDiGraph g = new AdjMatrixDiGraph(4);
    Vertex v0 = g.addNode(4);
    Vertex v1 = g.addNode(2);
    Vertex v2 = g.addNode(5);
    Vertex v3 = g.addNode(7);
    g.addAdjacent(v0, v1);
    g.addAdjacent(v1, v2);
    g.addAdjacent(v1, v2);
    g.addAdjacent(v3, v2);

    g.printMatrix();
  }

}