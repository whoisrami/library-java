package FindPossibleRoute;

import AdjListDiGraph.AdjListDiGraph;
import AdjListDiGraph.Node;
import AdjListDiGraph.State;
import java.util.LinkedList;

import static AdjListDiGraph.Test.createGraph;

/**
 * Author: Alex Yang
 * Date: 10/27/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * Solution:
 * - N/A
 */
public class FindPossibleRoute {
  public static void main(String args[]) {
    AdjListDiGraph graph = createGraph();
    graph.printAdjList();

    Node[] n = graph.getNodes();
    Node start = n[3];
    Node end = n[5];

    System.out.println(findBfs(graph, start, end));
  }

  //TODO: implement DFS version


  static boolean findBfs(AdjListDiGraph graph, Node start, Node end) {
    LinkedList<Node> queue = new LinkedList<>();

    //set all nodes status to be unvisited
    for (Node u : graph.getNodes()) {
      u.state = State.Status.Unvisited;
    }

    start.state = State.Status.Visiting;
    queue.add(start);

    Node n;
    while(!queue.isEmpty()) {
      n = queue.removeFirst();

      if (n != null) {
        for (Node v : n.getAdjacent()) {
          if (v.state == State.Status.Unvisited) { //if status of node is unvisited
            if (v == end) {
              return true; //we have found node
            } else {
              v.state = State.Status.Visiting;
              queue.add(v);
            }
          }
        }
        n.state = State.Status.Visited;
      }
    }
    return false;
  }
}
