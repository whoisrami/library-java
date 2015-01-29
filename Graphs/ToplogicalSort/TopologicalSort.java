package ToplogicalSort;

import AdjListDiGraphArrayList.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 1/24/15
 * Dependencies:
 * - N/A
 * Description:
 * - Simple implementation of topological sort.
 * - Based off pseudocode from: http://en.wikipedia.org/wiki/Topological_sorting
 * Solution:
 * - N/A
 */
public class TopologicalSort {
  public static void main(String[] args) {
    DiGraph graph = new DiGraph();

    Node[] temp = new Node[6];

    temp[0] = new Node("a");
    temp[1] = new Node("b");
    temp[2] = new Node("c");
    temp[3] = new Node("d");
    temp[4] = new Node("e");
    temp[5] = new Node("f");

    temp[0].addAdjacent(temp[2]);
    temp[1].addAdjacent(temp[2]);
    temp[1].addAdjacent(temp[3]);
    temp[2].addAdjacent(temp[4]);
    temp[3].addAdjacent(temp[4]);
    temp[4].addAdjacent(temp[5]);
    for (int i = 0; i < 6; i++) {
      graph.addNode(temp[i]);
    }

    // expected: b d a c e f
    LinkedList<Node> results = tsort(graph);
    for (Node n : results) {
      System.out.println(n.vertex);
    }
  }

  static LinkedList<Node> results = new LinkedList<>();

  //DFS method
  public static LinkedList<Node> tsort(DiGraph g) {
    //first, set all nodes to unvisited; (this could be skipped if data structure marks nodes to come in as unvisited)
    for (Node n : g.getNodes()) {
      n.status = Node.UNVISITED;
    }

    //loop through all nodes, skip nodes that are already visited
    //NOTE: if you are given the set of source nodes, then you can iterate through that instead to save iterations
    for (Node n : g.getNodes()) {
      if (n.status == Node.UNVISITED) {
        visit(n);
      }
    }

    return results;
  }

  static void visit(Node n) {
    //if we see a node that is already being marked as visiting, there must be a cycle!
    if (n.status == Node.VISITING) {
      System.out.println("not a valid DAG");

    } else if (n.status == Node.UNVISITED) {
      //standard dfs, goes as far down as it can
      n.status = Node.VISITING;
      for (Node child : n.getAdjacent()) {
        visit(child);
      }
      n.status = Node.VISITED;

      //this is the key! if AB => C, then:
      // it will traverse A and C in the DFS, then add C, then add A, exit the visit function, and visit B
      // it essentially adds in "reverse" dependency order
      results.addFirst(n);
    }
  }
}
