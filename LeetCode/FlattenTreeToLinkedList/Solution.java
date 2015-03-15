package FlattenTreeToLinkedList;

/**
 * Author: Alex Yang
 * Date: 3/15/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 * Solution:
 * - N/A
 */
public class Solution {
  public void flatten(TreeNode root) {
    if (root == null) return;
    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;

    flatten(left);
    flatten(right);

    root.right = left;

    TreeNode curr = root;
    while (curr.right != null) {
      curr = curr.right;
    }

    curr.right = right;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {val = x;}
}
