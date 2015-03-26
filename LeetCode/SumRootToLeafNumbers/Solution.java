package SumRootToLeafNumbers;

/**
 * Author: Alex Yang
 * Date: 3/25/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 * Solution:
 * - N/A
 */

public class Solution {
 public int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    return sumNumbers(root, 0);
 }

  public int sumNumbers(TreeNode root, int path) {
//    if (root == null) {
//      return path;
//    }

    path = path*10 + root.val;
    int left = 0;
    int right = 0;

    if (root.left == null && root.right == null) {
      return path;
    }

    if (root.left != null) {
      left = sumNumbers(root.left, path);
    }

    if (root.right != null) {
      right = sumNumbers(root.right, path);
    }

    return left + right;
  }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
