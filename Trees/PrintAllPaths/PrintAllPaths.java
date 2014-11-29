package PrintAllPaths;

import Tree.TreeNode;

/**
 * Author: Alex Yang
 * Date: 11/20/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a binary tree, print out all of its root-to-leaf paths one per line.
 * Solution:
 * - N/A
 */
public class PrintAllPaths {
  public static void main(String args[]) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);

    printPaths(tree);
  }

  static void printPaths(TreeNode root) {
    String path = "";
    printPaths(root, path);
  }

  static void printPaths(TreeNode root, String path) {
    if (root == null) return;
    path += root.data;

    if (root.left == null && root.right == null) {
      System.out.println(path);
    } else {
      printPaths(root.left, path);
      printPaths(root.right, path);
    }
  }
}
