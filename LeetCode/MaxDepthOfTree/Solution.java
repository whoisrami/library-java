package MaxDepthOfTree;

/**
 * Author: Alex Yang
 * Date: 1/30/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Solution:
 * - N/A
 */
public class Solution {
  public int maxDepth(TreeNode root) {
    return maxDepth(root, 1);
  }

  public int maxDepth(TreeNode root, int depth) {
    if (root == null) return 0;

    if (root.left == null && root.right == null) {
      return depth;
    }

    int left = maxDepth(root.left, depth + 1);
    int right = maxDepth(root.right, depth + 1);

    return Math.max(left, right);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {
    val = x;
  }
}