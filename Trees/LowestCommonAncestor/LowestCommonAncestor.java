package LowestCommonAncestor;

import Tree.TreeNode;

/**
 * Author: Alex Yang
 * Date: 11/4/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class LowestCommonAncestor {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    root.insert(6);
    root.insert(2);
    root.insert(1);
    root.insert(3);
    root.insert(4);

    TreeNode lca = findLca(root, root.left.left, root.left.right);
    System.out.println(lca.data); //should print 2
  }

  static TreeNode findLca(TreeNode root, TreeNode t1, TreeNode t2) {
    if (root == null) return null;
    if (root == t1 || root == t2) return root;

    boolean isT1Left = find(root.left, t1);
    boolean isT2Left = find(root.left, t2);

    //if not both on left, lca found
    if (isT1Left != isT2Left) return root;

    //else both on same side, traverse whatever side that is
    TreeNode child_side = isT1Left? root.left : root.right;

    return findLca(child_side, t1, t2);
  }

  static boolean find(TreeNode root, TreeNode t) {
    if (root == null) return false;
    if (root == t) return true;
    return find(root.left, t) || find(root.right, t);
  }
}
