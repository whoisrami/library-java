package VerticalLevelOrder;

import Tree.TreeNode;

import java.util.*;

/**
 * Author: Alex Yang
 * Date: 11/20/14
 * Dependencies:
 * - N/A
 * Description:
 * - Print a Binary Tree in Vertical Order
 * Solution:
 * - N/A
 */
public class VerticalLevelTraversal {
  public static void main(String args[]) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);

    printVerticals(tree);
  }

  static void verticalOrderTraversal(TreeNode root, int horizontalDistance, Map<Integer, ArrayList<Integer>> map) {
    if (root == null) return;

    if (!map.containsKey(horizontalDistance)) {
      ArrayList<Integer> vertical = new ArrayList<>();
      vertical.add(root.data);
      map.put(horizontalDistance, vertical);
    } else {
      ArrayList<Integer> vertical = map.get(horizontalDistance);
      vertical.add(root.data);
      map.put(horizontalDistance, vertical);
    }

    verticalOrderTraversal(root.left, horizontalDistance - 1, map);
    verticalOrderTraversal(root.right, horizontalDistance + 1, map);
  }

  static void printVerticals(TreeNode root) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    verticalOrderTraversal(root, 0, map);

    List<Integer> sortedKeys =new ArrayList<>(map.keySet());
    Collections.sort(sortedKeys);

    for (Object i : sortedKeys) {
      ArrayList<Integer> vertical = map.get(i);
      for (int n : vertical) {
        System.out.print(n);
      }
      System.out.println();
    }
  }
}
