package InOrderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: Alex Yang
 * Date: 3/24/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?
 * Solution:
 * - N/A
 */
public class InOrderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> results = new ArrayList<>();
    Stack<TreeNode> buffer = new Stack<TreeNode>();

    while (root != null || !buffer.isEmpty()) {
      while (root != null) {
        buffer.add(root);
        root = root.left;
      }
      root = buffer.pop();
      results.add(root.val);

      root = root.right;
    }

    return results;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {val = x;}
}

