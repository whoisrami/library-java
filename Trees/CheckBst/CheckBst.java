package CheckBst;

import Tree.TreeNode;

/**
 * Author: Alex Yang
 * Date: 11/4/14
 * Dependencies:
 * - N/A
 * Description:
 * - Implement a function to check if a binary tree is a binary search tree.
 * Solution:
 * - N/A
 */
public class CheckBst {
  public static void main(String args[]) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);

    System.out.println(checkBst(tree));
  }

  //SOLUTION 1: do an inorder traversal, put all the elements into an array, check if array is sorted.  Takes some extra space, and cannot handle duplicates.


  //SOLUTION 2: leverage the fact that left <= current < right
  static boolean checkBst(TreeNode root) {
    return checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  static boolean checkBst(TreeNode current, int min, int max) {
    if (current == null) return true;
    if (current.data <= min || current.data > max) return false;

    boolean left = checkBst(current.left, min, current.data);
    boolean right = checkBst(current.right, current.data, max);
    if (left && right) return true;

    return false;
  }
}
