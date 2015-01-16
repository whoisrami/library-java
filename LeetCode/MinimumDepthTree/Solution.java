package MinimumDepthTree;

/**
 * Author: Alex Yang
 * Date: 1/14/15
 * Dependencies:
 * - N/A
 * Description:
 * - The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {}

  public static int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;

    int min = Integer.MAX_VALUE;
    if (root.left != null) {
      min= Math.min(min, 1 + minDepth(root.left));
    }

    if (root.right != null) {
      min = Math.min(min, 1 + minDepth(root.right));
    }

    return min;
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