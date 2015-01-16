package TreeLevelOrderTraversal;

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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
  public List<List<Integer>> levelOrder(TreeNode root) {

    LinkedList<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> results = new ArrayList<>();
    if (root == null) return results;

    queue.add(root);
    while (!queue.isEmpty()) {
      LinkedList<TreeNode> curr = new LinkedList<>();
      curr.addAll(queue);
      queue.clear();
      List<Integer> level = new ArrayList<>();

      while (!curr.isEmpty()) {

        TreeNode t = curr.poll();
        if (t.left != null) {
          queue.add(t.left);
        }

        if (t.right != null) {
          queue.add(t.right);
        }

        level.add(t.val);
      }
      results.add(level);
    }

    return results;
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