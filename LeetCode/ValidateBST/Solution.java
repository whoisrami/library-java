package ValidateBST;

/**
 * Author: Alex Yang
 * Date: 1/15/15
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */

public class Solution {
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public boolean isValidBST(TreeNode root, int min, int max) {
    if (root == null) return true;
    if (root.val > max || root.val < min) {
      return false;
    }

    return isValidBST(root.left, min, root.val) &&
            isValidBST(root.right, root.val, max);

  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      val = x;
    }
  }
}
