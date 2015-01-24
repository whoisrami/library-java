package TreePathSum;

/**
 * Author: Alex Yang
 * Date: 1/23/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    TreeNode t = new TreeNode(1);
    t.left = new TreeNode(2);

    System.out.println(hasPathSum(t, 3));
  }


  public static boolean hasPathSum(TreeNode root, int sum) {
    return hasPathSum(root, sum, 0);
  }

  public static boolean hasPathSum(TreeNode root, int sum, int curr) {
    if (root == null) return false;

    curr += root.val;

    if (root.left == null && root.right == null) {
      return sum == curr;
    }

    boolean left = hasPathSum(root.left, sum, curr );
    boolean right = hasPathSum(root.right, sum, curr);

    return left || right;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {val = x;}
}