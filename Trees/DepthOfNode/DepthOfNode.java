package DepthOfNode;

import Tree.TreeNode;

/**
 * Author: Alex Yang
 * Date: 11/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class DepthOfNode {
  public static void main(String args[]) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);

    System.out.println(findDepth(tree, 4, 1));
  }

  static int findDepth(TreeNode root, int val, int depth) {
    if (root == null) return 0;
    if (val == root.data) return depth;
    int left = findDepth(root.left, val, depth+1);
    int right = findDepth(root.right, val, depth+1);
    return Math.max(left, right);
  }
}
