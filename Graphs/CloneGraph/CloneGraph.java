package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Alex Yang
 * Date: 12/4/14
 * Dependencies:
 * - N/A
 * Description:
 * - Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 * Solution:
 * - N/A
 */
public class CloneGraph {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return null;
    return cloneGraph(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
  }

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode,
          UndirectedGraphNode> map) {

    UndirectedGraphNode clone = new UndirectedGraphNode(node.label); //make clone of node
    map.put(node, clone); //put clone into map containing a mapping of original node -> cloned node

    for (UndirectedGraphNode n : node.neighbors) {
      if (!map.containsKey(n)) {
        UndirectedGraphNode tmp = cloneGraph(n, map); //traverse using dfs; returns cloned neighbor
        //remember map.get(node) returns the CLONED node.
        map.get(node).neighbors.add(tmp); //add each cloned neighbor to curr clone node
      } else {
        //node already in map, add neighbor to clone node without recursing
        map.get(node).neighbors.add(map.get(n));
      }

    }

    return clone;
  }
}

class UndirectedGraphNode {
   int label;
   List<UndirectedGraphNode> neighbors;
   UndirectedGraphNode(int x) {
     label = x;
     neighbors = new ArrayList<UndirectedGraphNode>();
   }
}

