package SumPaths;

import Tree.TreeNode;

/**
 * Author: Alex Yang
 * Date: 11/29/14
 * Dependencies:
 * - N/A
 * Description:
 * - You are given a binary tree in which each node contains a value.  Design an algorithm to print all paths which sum to a given value.  The path does not need to start or end at the root or a leaf.
 * Solution:
 * - N/A
 */
public class SumPaths {
  public static void main(String[] args) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);
    tree.insert(-1);

    findSums(tree, 7);
  }

  static void findSums(TreeNode root, int sum) {
    int depth = depth(root);
    int[] path = new int[depth];
    findSums(root, sum, path, 0);
  }

  static void findSums(TreeNode n, int sum, int[] path, int level) {
    if (n == null) return;
    path[level] = n.data; //insert current nodes data into the path, using level as index

    //start from the current node and traverse upwards checking for if sum is matched
    int counter = 0;
    for (int i = level; i >= 0; i--) {
      counter += path[i];
      if (counter == sum) { //if sum found, call printpath with start as the current level, and level as the end
        printPath(path, i, level);
      }
    }

    findSums(n.left, sum, path, level + 1);
    findSums(n.right, sum, path, level + 1);
  }

  static int depth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(depth(root.left), depth(root.right));
  }

  static void printPath(int[] path, int start, int end) {
    for (int i = start; i <= end; i++) {
      System.out.print(path[i]);
    }
    System.out.println();
  }
}
