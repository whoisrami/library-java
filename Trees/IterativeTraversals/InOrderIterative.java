package IterativeTraversals;

import Tree.TreeNode;

import java.util.Stack;

/**
 * Author: Alex Yang
 * Date: 12/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class InOrderIterative {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    root.insert(6);
    root.insert(2);
    root.insert(1);
    root.insert(3);
    root.insert(4);

    traverse(root);
  }

  static void traverse(TreeNode t) {
    Stack<TreeNode> stack = new Stack<>();

    if (t == null) return;

    while (!stack.isEmpty() || t != null) {
      if (t != null) { //always go left if you can
        stack.push(t);
        t = t.left;
      } else { //else pop from stack, print data, then attempt to go right
        TreeNode n = stack.pop();
        System.out.print(n.data);
        t = n.right;
      }
    }

  }

  static void traverseRecursive(TreeNode t) {
    if (t == null) return;

    traverseRecursive(t.left);
    System.out.println(t.data);
    traverseRecursive(t.right);
  }
}