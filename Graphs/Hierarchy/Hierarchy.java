package Hierarchy;

import java.util.ArrayList;
import java.io.*;

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
public class Hierarchy {
  public static void main(String args[]) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("org_chart.in"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("hierarchy.out"));

    int numCases = Integer.parseInt(reader.readLine());

    for (int caseNum = 1; caseNum <= numCases; caseNum++)
    {
      String test = reader.readLine();
      writer.write("Case #" + caseNum + "\n");
      printHierarchy(test, reader, writer);
    }

    writer.close();
    reader.close();
  }

  static void printHierarchy(String in, BufferedReader reader, BufferedWriter writer) throws IOException {
    AdjListDiGraph g = new AdjListDiGraph(); //max input size

    //add all nodes into the graph
    //split input by -- first
    String[] employees = in.split("--");
    //take resulting array split it by ,
    for (String employee : employees) {
      String[] terms = employee.split(",");
      g.addNode(new Node(terms[0], terms[1], terms[2], terms[3]));
    }

    //add all edges
    for (String employee : employees) {
      String[] terms = employee.split(",");
      if (!terms[1].equals("CEO")) {
        //how to add adjacent edges?
        //use the 2nd term and search for the node in the graph
        for (Node parent : g.getNodes()) {
          if (terms[1].equals(parent.name)) {
            //find node using terms[1]
            for (Node child : g.getNodes()) {
              if (terms[0].equals(child.name)) {
                parent.addAdjacent(child);
              }
            }
          }
        }
      }
    }

    //finished building graph
    g.printAdjList();

    //perform DFS on the graph
    //set all nodes status to be unvisited
    for (Node u : g.getNodes()) {
      u.state = State.Status.Unvisited;
    }

    for (Node v : g.getNodes()) {
      if (v.position.equals("(CEO)")) {
        dfs(g, v, 0, reader, writer);
      }
    }
  }

  //check if node is null, otherwise mark as visited, grab adjacent nodes and recurse if node is unvisited
  static void dfs(AdjListDiGraph graph, Node start, int level, BufferedReader reader, BufferedWriter writer) throws IOException{
    if (start == null) return;
    start.state = State.Status.Visited;

    //store in an additional data structure somewhere and sort alphabetically
    for (int i = 0; i < level; i++) {
      System.out.print("-");
      writer.write("-");
    }
    System.out.print(start.name + " " + start.position + " " + start.year);
    writer.write(start.name + " " + start.position + " " + start.year + "\n");
    System.out.print("\n");

    for (Node v : start.getAdjacent()) {
      if (v.state == State.Status.Unvisited) {
        dfs(graph, v, level + 1, reader, writer);
      }
    }
  }
}

class AdjListDiGraph {
  private ArrayList<Node> vertices;

  public AdjListDiGraph() {
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
  public String name;
  public String supervisor;
  public String year;
  public String position;

  public Node(String name, String supervisor, String position, String year) {
    this.name = name;
    this.supervisor = supervisor;
    this.year = year;
    this.position = "(" + position + ")";
  }

  public void addAdjacent(Node x) {
    int i = 0;
    while (i < adjacent.size() && adjacent.get(i).name.compareTo(x.name) < 0) {
      i++;
    }
    if (i > adjacent.size() - 1) {
      adjacent.add(x);
    } else {
      adjacent.add(i, x);
    }
  }

  public ArrayList<Node> getAdjacent() {
    return adjacent;
  }

  public String getVertex() {
    return name;
  }

  public void printAdjacent() {
    for (Node n : adjacent) {
      System.out.print(n.name + " ");
    }
    System.out.println();
  }
}

class State {
  public enum Status {
    Unvisited, Visited, Visiting;
  }
}

