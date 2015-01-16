package BalancedBinaryTree;

/**
 * Author: Alex Yang
 * Date: 1/14/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Solution:
 * - N/A
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    int left = getHeight(root.left);
    int right = getHeight(root.right);

    if (Math.abs(left - right) > 1) {
      return false;
    }

    return isBalanced(root.left) && isBalanced(root.right);
  }

  public int getHeight(TreeNode root) {
    if (root == null) return 0;

    return 1 + Math.max(getHeight(root.left), getHeight(root.right));
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